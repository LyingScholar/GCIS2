package petespike.view;

import java.util.Scanner;

import backtracker.Backtracker;
import petespike.model.Direction;
import petespike.model.GameState;
import petespike.model.Move;
import petespike.model.PetesPike;
import petespike.model.PetesPikeException;
import petespike.model.Position;

public class PetesPikeMain {

    //have to rename this file to CLI now I guess

    private PetesPike petesPike;
    private Scanner scanner;

    public PetesPikeMain(String fileName){
        petesPike = new PetesPike(fileName);
        //initialzing is part of this only
        petesPike.displayGame();
        scanner = new Scanner(System.in);
        displayCommands();
    }

    public void displayCommands() {
        System.out.println("Commands:");
        System.out.println("help - show this help menu");
        System.out.println("board - display the current board");
        System.out.println("reset - reset current puzzle to the start");
        System.out.println("new <puzzle_filename> - start a new puzzle");
        System.out.println("move <row> <col> <direction> - move the piece at <row>, <col>");
        System.out.println("\t where <direction> one of u(p), d(own), l(eft), r(ight)");
        System.out.println("hint - get a valid move, if one exists");
        System.out.println("solve - solve the current puzzle");
        System.out.println("quit - quit the game");

    }

    public void startGame(){
        while (true) {//infinte playing pretty much
            System.out.print("Command: ");
            String command = scanner.nextLine();
            processCommand(command);
            if (petesPike.getGameState() == GameState.WON) {
                //until no more moves or win
                System.out.println("Well played. You won.");
                break;
            }
            if(petesPike.getGameState() == GameState.NO_MOVES){
                System.out.println("Better luck next time");
                break;
            }
        }
        System.out.println("Game Over");
    }

    private Direction directionFromText(String direction){
        //incomplete
        char dir = direction.toUpperCase().charAt(0);
        try{
        switch(String.valueOf(dir)){
            case "U":
            return Direction.UP;
            case "D":
            return Direction.DOWN;
            case "L":
                return Direction.LEFT;
            case "R":
                return Direction.RIGHT;
            default:
                throw new PetesPikeException(direction + "is not a valid direction");
        }}catch(PetesPikeException e){
            System.out.println(e);
            return null;
        }
    }

    private void processCommand(String command){
        String[] parts = command.split(" ");
        System.out.println(parts[0]);
        switch (parts[0]) {
            case "help":
                displayCommands();
                break;
            case "board":
                petesPike.displayGame();
                break;
            case "reset":
                petesPike = new PetesPike(petesPike.getFilename());
                petesPike.displayGame();
                //this is a  recursion, might be a memory issue later
                break;


            case "new":
                if (parts.length > 1) {
                    // seems cleaner than a try statement, could replace if needed
                    petesPike = new PetesPike(parts[1]);
                    //filename gets changed with initialization so reset also works correctly
                    petesPike.displayGame();
                } else {
                    System.out.println("Please provide a puzzle filename.");

                }
                break;

                
            case "move":
                if (parts.length == 4) {
                    try {
                        int row = Integer.parseInt(parts[1]);
                        int col = Integer.parseInt(parts[2]);
                        Move move = new Move(new Position(row, col),directionFromText(parts[3]));
                            if(!petesPike.checkPositionOnBoard(row,col)){
                                System.out.println("Position out of bounds.");
                                break;
                            }
                            if(petesPike.checkSymbolatPosition(row,col)){
                                System.out.println("Nothing to move at given position.");
                                break;
                            }
                            if(!petesPike.isValidMoveOnBoard(move)){
                                System.out.println("Off board move");
                            }
                        petesPike.makeMove(move);
                        petesPike.displayGame();
                    }catch(NumberFormatException s){
                        System.out.println("Invalid move command format. Use: move <row> <col> <direction>"
                        +"\n  (where direction is U,D,L or R)");
                        break;
                    }
                }else {
                    System.out.println("Invalid move command format. Use: move <row> <col> <direction>");
                }
            break;
        case "hint":
                if(petesPike.hint()==null){
                    System.out.println("No more moves possible. Resetting game...\n\n");
                    processCommand("reset");
                    break;
                }else{
                    System.out.println(petesPike.hint());
                }

        break;
        case "solve":
            Backtracker<PetesPike> solver = new Backtracker<PetesPike>(true);
            PetesPike solution = solver.solve(petesPike);
        if (solution != null) {
            System.out.println("Solved configuration:");
            System.out.println(solution);
        } else {
            System.out.println("No solution found.");
        }
            break;
        case "quit":
            System.out.println("Goodbye!");
            break;

        default:
            System.out.println("Unknown command. Type 'help' for a list of commands.");
            break;
        }

    }
    

    public static void main(String[] args){
        PetesPikeMain game = new PetesPikeMain("data/petes_pike_5_5_4_0.txt");
        // PetesPikeMain game = new PetesPikeMain("data/petes_pike_5_5_2_0.txt");
        // PetesPikeMain game = new PetesPikeMain("data/petes_pike_9_9_9_0.txt");
        game.startGame();
    }
}