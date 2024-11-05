package petespike.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import backtracker.Configuration;
import petespike.view.AsciiColorCodes;
import petespike.view.PetesPikeObserver;

public class PetesPike implements Configuration<PetesPike>{
    //do not change symbols, these are based on data files
    public static final char MOUNTAINTOP_SYMBOL = 'T';
    public static final char EMPTY_SYMBOL = '-';
    public static final char PETE_SYMBOL = 'P';
    public static List<Character> GOAT_SYMBOLS = Stream.of("0".charAt(0),"1".charAt(0),"2".charAt(0),"3".charAt(0),"4".charAt(0),"5".charAt(0),
    "6".charAt(0),"7".charAt(0),"8".charAt(0),"9".charAt(0)).collect(Collectors.toList());
    // GOAT_SYMBOLS {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    
    public static List<String> COLOR_LIST = Stream.of(
        AsciiColorCodes.ORANGE,AsciiColorCodes.GREEN,
        AsciiColorCodes.GOLD,AsciiColorCodes.PURPLE,
        AsciiColorCodes.LT_GRAY,AsciiColorCodes.CYAN,AsciiColorCodes.BLUE,
        AsciiColorCodes.YELLOW,AsciiColorCodes.MAGENTA).collect(Collectors.toList());
        //lot of the colors are almost white, so moved them to the end
    
    private int moveCount = 0;
    private char[][] gameGrid;
    // private Position mountaintop;
    private int mountaintopRow;
    private int mountaintopCol;
    private Position petePosition;
    private HashSet<Position> goatPositions = new HashSet<Position>();
    private GameState gameState;
    private String filename;
    private List<PetesPikeObserver> observers = new ArrayList<>();

    
    public PetesPike(String filenam){
        filename = filenam;
        initializeGame(filenam);
        
    }

    public PetesPike(PetesPike other){
        this.moveCount = other.moveCount;
        this.gameGrid = deepCopy(other.gameGrid);
        this.gameState = other.gameState;
        update();
        
    }

    private char[][] deepCopy(char[][] other) {
        int rows = other.length;
        int cols = other[0].length;
        char[][] newBoard = new char[rows][cols];
        newBoard = Arrays.copyOf(other, rows);
        return newBoard;
    }

    public String getFilename() {
        return filename;
    }
    
    public int getMoveCount() {
        return moveCount;
    }
    
    public int getRows() {
        return gameGrid.length;
    }

    public int getCols() {
        return gameGrid[0].length;
    }
    
    public GameState getGameState() {
        return gameState;
    }

    public char getSymbolAt(Position position){
        return gameGrid[position.getRow()][position.getCol()];
    }

    public Position getMountainTop() {
        return new Position(mountaintopRow,mountaintopCol);
    }

    
    public Position getPete() {
        return petePosition;
    }

    public void registerObserver(PetesPikeObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for(PetesPikeObserver observer : observers) {
            observer.pieceMoved();
        }
    }

    private void initializeGame(String filename){
        gameState = GameState.NEW;
        moveCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] dimensions = line.split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);
            gameGrid = new char[rows][cols];

            for (int row = 0; row < rows; row++) {
                line = reader.readLine();
                if (line == null || line.length() != cols) {
                    throw new PetesPikeException("Invalid gameGrid row or column count.");
                }
                gameGrid[row] = line.toCharArray();
                for(int col=0;col<gameGrid[row].length;col++){
                    if (gameGrid[row][col] == MOUNTAINTOP_SYMBOL) {
                        mountaintopRow = row;
                        mountaintopCol = col;
                    }
                    if (gameGrid[row][col] == PETE_SYMBOL) {
                        petePosition = new Position(row, col);
                    }
                    if (GOAT_SYMBOLS.contains(gameGrid[row][col])){
                        goatPositions.add(new Position(row,col));
                    }

                }
            }
        } catch (PetesPikeException e) {
            System.out.println("Invalid row/column format in file: " + filename);
        } catch (IOException e) {
            System.out.println("Failed to load the game from the file: " + filename);
        }
    }


public void displayGame(){
    String color= AsciiColorCodes.RESET;
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                char symbol = gameGrid[i][j];
                switch (symbol) {
                    case PetesPike.PETE_SYMBOL:
                        color = AsciiColorCodes.RED;
                        break;
                    case PetesPike.MOUNTAINTOP_SYMBOL:
                        symbol = "+".charAt(0);
                        break;
                    case PetesPike.EMPTY_SYMBOL:
                        if(i==mountaintopRow && j == mountaintopCol){
                            symbol = "+".charAt(0);
                        }
                        default:
                    if(GOAT_SYMBOLS.contains(symbol)){
                        color = COLOR_LIST.get(symbol-48);//ASCII issue, took me 4 hours to fix
                        break;
                    }
                    color = AsciiColorCodes.RESET;
                }
                System.out.print(color + symbol + AsciiColorCodes.RESET + " ");
            }
            System.out.println();
        }
        System.out.println("Moves: " + moveCount);
    }

    public void makeMove(Move move){
        //only called if move is valid so no need to check again
        int row = move.getPosition().getRow();
        int col = move.getPosition().getCol();
        boolean stopped = false;
        switch (move.getDirection()) {
            case UP:
                for(int i=row-1;i>=0;i--){
                    if(!(gameGrid[i][col] == EMPTY_SYMBOL) && !(gameGrid[i][col] == MOUNTAINTOP_SYMBOL)){
                        if ((getPete().equals(move.getPosition())) && (new Position(i+1,col).equals(getMountainTop()))){
                            gameState = GameState.WON;
                            stopped = true;
                        }
                        // to= new Position(i+1,col);
                        gameGrid[i+1][col] = gameGrid[row][col];
                        gameGrid[row][col] = EMPTY_SYMBOL;
                        moveCount++;
                        stopped= true;
                        notifyObservers();
                    }
                }
                break;
            case DOWN:
            for(int i=row+1;i<getRows();i++){
                if(!(gameGrid[i][col] == EMPTY_SYMBOL) && !(gameGrid[i][col] == MOUNTAINTOP_SYMBOL)){
                    if ((getPete().equals(move.getPosition())) && (new Position(i-1,col).equals(getMountainTop()))){
                        gameState = GameState.WON;
                        stopped= true;
                        
                    }
                    // to= new Position(i-1,col);
                    gameGrid[i-1][col] = gameGrid[row][col];
                    gameGrid[row][col] = EMPTY_SYMBOL;
                    moveCount++;
                    stopped= true;
                    notifyObservers();
                }
            }
                break;
            case LEFT:
            for(int i=col-1;i>=0;i--){
                if(!(gameGrid[row][i] == EMPTY_SYMBOL) && !(gameGrid[row][i] == MOUNTAINTOP_SYMBOL)){
                    if ((getPete().equals(move.getPosition())) && (new Position(row,i+1).equals(getMountainTop()))){
                        gameState = GameState.WON;
                        stopped= true;
                        
                    }
                    // to= new Position(row,i+1);
                    gameGrid[row][i+1] = gameGrid[row][col];
                    gameGrid[row][col] = EMPTY_SYMBOL;
                    moveCount++;
                    stopped= true;
                    notifyObservers();
                }
            }
                break;
            case RIGHT:
            for(int i=col+1;i<getCols();i++){
                if(!(gameGrid[row][i] == EMPTY_SYMBOL) && !(gameGrid[row][i] == MOUNTAINTOP_SYMBOL)){
                    if ((getPete().equals(move.getPosition())) && (new Position(row,i-1).equals(getMountainTop()))){
                        gameState = GameState.WON;
                        
                    }
                    // to= new Position(row,i-1);
                    gameGrid[row][i-1] = gameGrid[row][col];
                    gameGrid[row][col] = EMPTY_SYMBOL;
                    moveCount++;
                    stopped= true;
                    notifyObservers();
                }
            }
                break;
        }
        

            if(!stopped){
                gameGrid[row][col] = EMPTY_SYMBOL;
            }
            update();
        
    }

    public Position findPosAfterMove(Move move){
        //only called if move is valid so no need to check again
        int row = move.getPosition().getRow();
        int col = move.getPosition().getCol();
        Position to = null;
        switch (move.getDirection()) {
            case UP:
                for(int i=row-1;i>=0;i--){
                    if(!(gameGrid[i][col] == EMPTY_SYMBOL) && !(gameGrid[i][col] == MOUNTAINTOP_SYMBOL)){
                        to= new Position(i+1,col);
                    }
                }
                break;
            case DOWN:
            for(int i=row+1;i<getRows();i++){
                if(!(gameGrid[i][col] == EMPTY_SYMBOL) && !(gameGrid[i][col] == MOUNTAINTOP_SYMBOL)){
                    to= new Position(i-1,col);
                }
            }
                break;
            case LEFT:
            for(int i=col;i>=0;i--){
                if(!(gameGrid[row][i] == EMPTY_SYMBOL) && !(gameGrid[row][i] == MOUNTAINTOP_SYMBOL)){
                    to= new Position(row,i+1);
                }
            }
                break;
            case RIGHT:
            for(int i=col+1;i<getCols();i++){
                if(!(gameGrid[row][i] == EMPTY_SYMBOL) && !(gameGrid[row][i] == MOUNTAINTOP_SYMBOL)){
                    to= new Position(row,i-1);
                }
            }
                break;
        }
        
        return to;
        
    }

    public Direction findDir(Position source, Position target){
        if (target == null){
            boolean FreeDirection = true;
            for(int i=source.getRow()-1;i>=0;i--){
                if(!(gameGrid[i][source.getCol()] == EMPTY_SYMBOL) && !(gameGrid[i][source.getCol()] == MOUNTAINTOP_SYMBOL)){
                    FreeDirection = false;
                }
            }
            if(FreeDirection==true){
                return Direction.UP;
            }
            FreeDirection = true;
            for(int i=source.getRow()+1;i<getRows();i++){
                if(!(gameGrid[i][source.getCol()] == EMPTY_SYMBOL) && !(gameGrid[i][source.getCol()] == MOUNTAINTOP_SYMBOL)){
                    FreeDirection = false;
                }
            }
            if(FreeDirection==true){
                return Direction.DOWN;
            }
            FreeDirection = true;
            for(int i=source.getCol();i>=0;i--){
                if(!(gameGrid[source.getRow()][i] == EMPTY_SYMBOL) && !(gameGrid[source.getRow()][i] == MOUNTAINTOP_SYMBOL)){
                    FreeDirection = false;
                }
            }
            if(FreeDirection==true){
                return Direction.LEFT;
            }
            FreeDirection = true;
            for(int i=source.getCol()+1;i<getCols();i++){
                if(!(gameGrid[source.getRow()][i] == EMPTY_SYMBOL) && !(gameGrid[source.getRow()][i] == MOUNTAINTOP_SYMBOL)){
                    FreeDirection = false;
                }
            }
            if(FreeDirection==true){
                return Direction.RIGHT;
            }
            return null;
        }

        if(source.getCol() == target.getCol()){
            if(source.getRow() < target.getRow()){
                return Direction.DOWN;
            }else{
                return Direction.UP;
            }
        }else if(source.getCol() < target.getCol()) {
            return Direction.RIGHT;
        }else{
            return Direction.LEFT;
        }
    }

    public List<Move> getPossibleMoves(Position movable) {
        List<Move> possibleMoves = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            if(isValidMoveOnBoard(new Move(movable,direction))){
                possibleMoves.add(new Move(movable,direction));
            }
        }
        return possibleMoves;        
    }

    public List<Move> getAllPossibleMoves() {
        List<Move> possibleMoves = new ArrayList<>();
        for(Position goat: goatPositions){
            for (Direction direction : Direction.values()) {
                if(isValidMoveOnBoard(new Move(goat,direction))){
                    possibleMoves.add(new Move(goat,direction));
                }
            }
        }
        for (Direction direction : Direction.values()) {
            if(isValidMoveOnBoard(new Move(petePosition,direction))){
                possibleMoves.add(new Move(petePosition,direction));
            }
        }
        return possibleMoves;        
    }

    public boolean isValidMoveOnBoard(Move move) {
        int row = move.getPosition().getRow();
        int col = move.getPosition().getCol();
        switch (move.getDirection()) {
            case UP:
                if (row <= 0){
                    return false;
                }
                for(int i=0;i<row-1;i++){
                    if(!(gameGrid[i][col] == EMPTY_SYMBOL) && !(gameGrid[i][col] == MOUNTAINTOP_SYMBOL)){
                        return true;
                    }
                    // if anything above is non empty, its a valid move
                }
                break;
            case DOWN:
                if (row >= getRows()-1){
                    return false;
                }
                for(int i=row+2;i<getRows();i++){
                    if(!(gameGrid[i][col] == EMPTY_SYMBOL) && !(gameGrid[i][col] == MOUNTAINTOP_SYMBOL)){
                        return true;
                    }
                    // if anything below is non empty, its a valid move
                }
                break;
            case LEFT:
            if (col <= 0){
                return false;
            }
            for(int i=0;i<col-1;i++){
                if(!(gameGrid[row][i] == EMPTY_SYMBOL) && !(gameGrid[row][i] == MOUNTAINTOP_SYMBOL)){
                    return true;
                }
            }
                break;
            case RIGHT:
            if (col >= getCols()-1){
                return false;
            }
            for(int i=col+2;i<getCols();i++){
                if(!(gameGrid[row][i] == EMPTY_SYMBOL) && !(gameGrid[row][i] == MOUNTAINTOP_SYMBOL)){
                    return true;
                }
            }
                break;
        }
        return false;
    }

    public Move hint(){
        //extra work, could've just returned the first in the list too
        Random rand = new Random();
        List<Move> possibleMoves = new ArrayList<>();
        possibleMoves = getAllPossibleMoves();
        if(possibleMoves.size()==0){
            return null;
        }
        int randIndex = rand.nextInt(possibleMoves.size());
        return possibleMoves.get(randIndex);
    }

    private void update() {
        try{
            goatPositions.clear();
        }catch(NullPointerException e){
            
        }
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                if (gameGrid[row][col] == PETE_SYMBOL) {
                    petePosition = new Position(row, col);
                }
                if (GOAT_SYMBOLS.contains(gameGrid[row][col])){
                    goatPositions.add(new Position(row,col));
                }
            }
        }
        if(gameGrid[mountaintopRow][mountaintopCol] == EMPTY_SYMBOL){
            gameGrid[mountaintopRow][mountaintopCol]= MOUNTAINTOP_SYMBOL;
        }
        
    }

    public boolean checkPositionOnBoard(int nextRow, int nextCol) {
        return (nextRow >= 0 && nextRow < getRows() && nextCol >= 0 && nextCol < getCols());
    }

    public boolean checkSymbolatPosition(int row, int col) {
        return gameGrid[row][col] == EMPTY_SYMBOL;
    }

    public boolean checkMountainatPosition(int row, int col) {
        return (new Position(row, col)).equals(getMountainTop());
    }

    @Override
    public String toString() {
        return gameGrid.toString();
    }

    @Override
    public Collection<PetesPike> getSuccessors() {
        List<PetesPike> successors = new ArrayList<>();
        for(Move validMove: getAllPossibleMoves()){
            PetesPike newSuccessor = new PetesPike(this);
            newSuccessor.makeMove(validMove);
            successors.add(newSuccessor);
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        return !(getAllPossibleMoves() == null);
    }

    @Override
    public boolean isGoal() {
        return gameState.equals(GameState.WON);
    }

}
