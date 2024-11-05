package petespike.view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import petespike.model.GameState;
import petespike.model.Move;
import petespike.model.PetesPike;
import petespike.model.Position;


//move counter doesnt update yet
//Pete's Pike Main and Pete's pike Game are pretty much independent
//think of adding buttons for different game files
//DO NOT TRY TO IMPLEMENT SOLVE
//hint not implemeted correctly
//add images of goats
//mountain as a bac kground?

public class PetesPikeGame extends Application implements PetesPikeObserver{
    private GridPane gameBoard;
    private Label statusLabel;
    private Label moveCountLabel;
    private Button newGameButton;
    private Button hintButton;
    private PetesPike petesPike;

    private boolean MoveChecker = true;
    private Position Clicked;
    private List<Position> Highlights = new ArrayList<>();

    Image image = new Image("file:src/main/pix/mountain.jpg",300,300,true,false);
    private static List<String> goatImages =new ArrayList<>();
    static{
        goatImages.add("file:src/main/pix/goat0.png");
        goatImages.add("file:src/main/pix/goat1.png");
        goatImages.add("file:src/main/pix/goat2.png");
        goatImages.add("file:src/main/pix/goat3.png");
        goatImages.add("file:src/main/pix/goat4.png");
        goatImages.add("file:src/main/pix/goat5.png");
        goatImages.add("file:src/main/pix/goat6.png");
        goatImages.add("file:src/main/pix/goat7.png");
        goatImages.add("file:src/main/pix/goat8.png");
        goatImages.add("file:src/main/pix/goat9.png");
        // goatImages.add("file:src/main/pix/goat0.png");

    }

    @Override
    public void start(Stage primaryStage) {
        // petesPike = new PetesPike("data/petes_pike_5_5_4_0.txt");
        petesPike = new PetesPike("data/petes_pike_9_9_9_0.txt");
        setupGameWindow(primaryStage);
        updateMoveCount();
        updateGameBoard();
        updateStatus("New game started");
        
    }

    private void setupGameWindow(Stage stage) {
        

        statusLabel = new Label("Welcome to Pete's Pike!");
        statusLabel.setAlignment(Pos.CENTER);
        statusLabel.setFont(Font.font("Consolas", FontWeight.BOLD, 28));
        statusLabel.setPadding(new Insets(5));

        statusLabel.setBackground(new Background(new BackgroundFill(Color.web("222831"
        ),new CornerRadii(5),new Insets(1))));
        statusLabel.setTextFill(Color.web("00FFF5"));
        statusLabel.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        
        

        moveCountLabel = new Label("Moves: 0");
        moveCountLabel.setAlignment(Pos.CENTER);
        moveCountLabel.setFont(Font.font("Consolas", FontWeight.BOLD, 22));
        moveCountLabel.setBackground(new Background(new BackgroundFill(Color.web("393E46")
        ,new CornerRadii(5),new Insets(1))));

        moveCountLabel.setPadding(new Insets(10));
        moveCountLabel.setTextFill(Color.web("00FFF5"));
        moveCountLabel.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        


        gameBoard = new GridPane();
        gameBoard.setHgap(5);
        gameBoard.setVgap(5);
        gameBoard.setPrefSize(300, 300);
        gameBoard.setAlignment(Pos.CENTER);
        gameBoard.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        GridPane.setHgrow(gameBoard, Priority.ALWAYS);
        GridPane.setVgrow(gameBoard, Priority.ALWAYS);

        //somewhere on the internet, this was found
        //looks cool though
        for (int i = 0; i < petesPike.getRows(); i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / petesPike.getRows());
            row.setVgrow(Priority.ALWAYS); // Allow the row to grow
            gameBoard.getRowConstraints().add(row);
        }
        for (int i = 0; i < petesPike.getCols(); i++) {
            ColumnConstraints COL = new ColumnConstraints();
            COL.setPercentWidth(100.0 / petesPike.getCols());
            COL.setHgrow(Priority.ALWAYS); // Allow the row to grow
            gameBoard.getColumnConstraints().add(COL);
        }

        newGameButton = new Button("Restart Game");
        newGameButton.setMaxHeight(Double.MAX_VALUE);
        newGameButton.setMaxWidth(Double.MAX_VALUE);
        newGameButton.setAlignment(Pos.CENTER);
        newGameButton.setPadding(new Insets(10));
        newGameButton.setFont(Font.font("Consolas", FontWeight.BOLD, 22));
        newGameButton.setBackground(new Background(new BackgroundFill(Color.web("393E46")
        ,new CornerRadii(5),new Insets(1))));
        newGameButton.setTextFill(Color.web("00FFF5"));
        newGameButton.setOnAction(event -> {
            startNewGame(petesPike.getFilename());
            updateMoveCount();
            updateGameBoard();
        });

        hintButton = new Button("Hint");
        hintButton.setAlignment(Pos.CENTER);
        hintButton.setMaxHeight(Double.MAX_VALUE);
        hintButton.setMaxWidth(Double.MAX_VALUE);
        hintButton.setFont(Font.font("Consolas", FontWeight.BOLD, 22));
        hintButton.setBackground(new Background(new BackgroundFill(Color.web("393E46")
        ,new CornerRadii(5),new Insets(1))));
        hintButton.setTextFill(Color.web("00FFF5"));
        hintButton.setPadding(new Insets(10));
        hintButton.setOnAction(event -> requestHint());
        



        VBox statusArea = new VBox();
        statusArea.getChildren().addAll(statusLabel, moveCountLabel);
        statusArea.setFillWidth(true);

        
        HBox actionButtons = new HBox();
        actionButtons.getChildren().addAll(newGameButton, hintButton);
        actionButtons.setAlignment(Pos.CENTER);
        actionButtons.setFillHeight(true);

        HBox.setHgrow(newGameButton, Priority.ALWAYS);
        HBox.setHgrow(hintButton, Priority.ALWAYS);


        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(statusArea);
        mainLayout.setCenter(gameBoard);
        gameBoard.prefWidthProperty().bind(mainLayout.widthProperty());
        gameBoard.prefHeightProperty().bind(mainLayout.heightProperty());
        mainLayout.setBottom(actionButtons);
        mainLayout.setBackground(new Background(new BackgroundFill(Color.web("1B1A55"),new CornerRadii(5),Insets.EMPTY)));
        
        
        
        BorderPane.setAlignment(gameBoard, Pos.CENTER);
        
        BorderPane.setMargin(gameBoard, new Insets(10));

        Scene scene = new Scene(mainLayout);
        stage.setScene(scene);
        stage.setTitle("Pete's Pike Game");
        stage.setHeight(125*(petesPike.getRows()+1));
        stage.setWidth(140*petesPike.getCols());
        stage.setResizable(true);
        // stage.setFullScreen(true);
        stage.show();
    }

    
    public void updateGameBoard() {
        if(petesPike.getGameState() == GameState.WON){
            updateStatus("You won. Good job");
            gameBoard.getChildren().clear();
        }
        if(petesPike.getGameState() == GameState.NO_MOVES){
            updateStatus("No more moves");
            // gameBoard.getChildren().clear();
        }
        gameBoard.getChildren().clear();
        for (int row = 0; row < petesPike.getRows(); row++) {
            for (int col = 0; col < petesPike.getCols(); col++) {
                
                Position pos = new Position(row, col);
                Button button = new Button(String.valueOf(petesPike.getSymbolAt(pos)));
                button.setFont(Font.font("Stencil", FontWeight.BOLD, 40));
                button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

                if(pos.equals(Clicked)){
                    button.setTextFill(Color.web("222831"));
                    button.setBackground(new Background(new BackgroundFill(
                        Color.web("00FFF5"),new CornerRadii(5),
                        new Insets(1))));
                    
                }else{
                    
                        if(MoveChecker){
                            button.setTextFill(Color.web("00FFF5"));
                            button.setBackground(new Background(new BackgroundFill(
                                Color.web("393E46"),new CornerRadii(5),
                                new Insets(1))));
                        }else{
                            if(Highlights.contains(pos)){
                                button.setTextFill(Color.web("00FFF5"));
                                button.setBackground(new Background(new BackgroundFill(
                                    Color.web("393E46"),new CornerRadii(5),
                                    new Insets(1))));
                            }else{
                                button.setTextFill(Color.web("00ADB5"));
                                button.setBackground(new Background(new BackgroundFill(
                                    Color.web("222831"),new CornerRadii(5),
                                    new Insets(1))));
                                    
                            }
                        }
                }

                if(petesPike.checkMountainatPosition(row, col)){
                    if(petesPike.getSymbolAt(pos) == PetesPike.EMPTY_SYMBOL || petesPike.getSymbolAt(pos)==PetesPike.MOUNTAINTOP_SYMBOL){
                        button.setText("");
                    }
                    button.setBackground(new Background(new BackgroundImage(image,  
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,  
                    BackgroundSize.DEFAULT)));
                }

                if(PetesPike.GOAT_SYMBOLS.contains(petesPike.getSymbolAt(pos))){
                    ImageView picture =new ImageView(goatImages.get(Integer.valueOf(petesPike.getSymbolAt(pos)) - 48));
                    // picture.setScaleX(gameBoard.getWidth()/(100*gameBoard.getMinWidth()));
                    // picture.setScaleY(gameBoard.getHeight()/(100*gameBoard.getMinHeight()));
                    picture.setFitWidth(100);
                    picture.setPreserveRatio(true);
                    picture.setSmooth(true);
                    Button buttonGoat = new Button(String.valueOf(petesPike.getSymbolAt(pos)),picture);
                    buttonGoat.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

                    if(pos.equals(Clicked)){
                        buttonGoat.setBackground(new Background(new BackgroundFill(
                            Color.web("00FFF5"),new CornerRadii(5),
                            new Insets(1))));
                        
                    }else{
                        
                            if(MoveChecker){
                                buttonGoat.setBackground(new Background(new BackgroundFill(
                                    Color.web("393E46"),new CornerRadii(5),
                                    new Insets(1))));
                            }else{
                                if(Highlights.contains(pos)){
                                    buttonGoat.setBackground(new Background(new BackgroundFill(
                                        Color.web("393E46"),new CornerRadii(5),
                                        new Insets(1))));
                                }else{
                                    buttonGoat.setBackground(new Background(new BackgroundFill(
                                        Color.web("222831"),new CornerRadii(5),
                                        new Insets(1))));
                                        
                                }
                            }
                    }
                    gameBoard.add(buttonGoat, col, row);
                    buttonGoat.setOnAction(e -> 
                    {
                        updateGameBoard();
                        if (petesPike.getGameState() == GameState.IN_PROGRESS ||
                        petesPike.getGameState() == GameState.NEW){
                                if(MoveChecker){
                                    
                                    checkMoves(pos);
                                    updateMoveCount();
                                    updateGameBoard();
                                }else{
                                    makeMove(pos);
                                    updateMoveCount();
                                    updateGameBoard();
                                }
                        }
                        
                    }
                    );
                }else{

                    
                        button.setOnAction(e -> 
                            {
                                updateGameBoard();
                                if (petesPike.getGameState() == GameState.IN_PROGRESS ||
                                petesPike.getGameState() == GameState.NEW){
                                        if(MoveChecker){
                                            
                                            checkMoves(pos);
                                            updateMoveCount();
                                            updateGameBoard();
                                        }else{
                                            makeMove(pos);
                                            updateMoveCount();
                                            updateGameBoard();
                                        }
                                }
                                
                            }
                        );
                    gameBoard.add(button, col, row);
                }                
            }
        }

    }

    public void checkMoves(Position pos){
        if(petesPike.checkSymbolatPosition(pos.getRow(),pos.getCol()) || petesPike.checkMountainatPosition(pos.getRow(),pos.getCol())){
            updateStatus("Nothing there to move");
        }else if(petesPike.getPossibleMoves(pos).size() == 0){
            updateStatus("No possible moves from here");
        }else{
            updateStatus("Select a move");
            Clicked = pos;
            for (Move move : petesPike.getPossibleMoves(pos)){
                Highlights.add(petesPike.findPosAfterMove(move));
                MoveChecker = false;
            };
        }
    }

    public void makeMove(Position pos){
        if(!petesPike.checkSymbolatPosition(pos.getRow(),pos.getCol()) && !petesPike.checkMountainatPosition(pos.getRow(),pos.getCol())){
            updateStatus("Location already occupied.");
            Highlights.clear();
            Clicked = null;
            MoveChecker = true;
        }else if(pos == Clicked){
    
        }else if(!Highlights.contains(pos)){
            updateStatus("Can't go there");
            Highlights.clear();
            Clicked = null;
            MoveChecker = true;

        }else if(Highlights.contains(pos)){
            updateStatus("Good Move");
            moveCountLabel = new Label("Moves: "+ petesPike.getMoveCount());
            petesPike.makeMove(new Move(Clicked,petesPike.findDir(Clicked,pos)));
            Highlights.clear();
            Clicked = null;
            MoveChecker = true;
        }
    }

    private void startNewGame(String filename) {
        petesPike = new PetesPike(filename);
        petesPike.registerObserver(this);
        updateGameBoard();
        updateMoveCount();
    }

    private void requestHint() {
        if(petesPike.hint()==null){
            updateStatus("No more moves possible");

        }else{
            updateStatus("* " + petesPike.hint() + " *");
        }
    }

    private void updateMoveCount() {
        moveCountLabel.setText("Moves: " + petesPike.getMoveCount());
    }

    private void updateStatus(String message) {
        statusLabel.setText(message);
    }

    @Override
    public void pieceMoved() {
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}

