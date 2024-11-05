package unit09.filters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/**
 * Displays data in a table format allowing the user to sort the table by the
 * data in any column by clicking on the column header.
 */
public class Filters extends Application {

    private List<String[]> data;
    private List<List<Label>> labels;
    private boolean ascending = true;
    

    // public static int compareByFirstName(String[] a, String[] b){
    //     Double.valueOf(a[sorter].strip()).compareTo(Double.valueOf(b[sorter].strip()))
    // }
    // public static int parse(String[] a,int sorter){
    //     ;
    // }
    // public String banana(){
    //     System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    //     System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    //     System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    //     System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    //     System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    //     return "000";
    // }

    @Override
    public void start (Stage stage) throws Exception {
        // The filename will be passed through as a command line parameter
        List<String> args = getParameters ().getRaw ();
        FileReader file = new FileReader (args.get (0));

        BufferedReader fin = new BufferedReader (file);
        // int row = 0;
        // int col = 0;


        
        // data = new ArrayList<> ();
        // lables = new ArrayList<> ();

        // Use the header to create the first row as buttons.
        String[] header = fin.readLine ().strip ().split (","); 
        data = fin.lines().map(line -> line.strip().split(","))
                        .collect(Collectors.toList());
        


        // If the data is too big, add scroll bars
        ScrollPane scroller = new ScrollPane ();
        scroller.setMaxSize (1000, 600);
        
        GridPane pane = new GridPane ();
        pane.setPadding(new Insets(20));
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN,CornerRadii.EMPTY,Insets.EMPTY)));
        pane.setHgap(0);
        pane.setVgap(0);
        // pane.setGridLinesVisible(true);
        labels = new ArrayList<>();


        
        IntStream.range(0, header.length).forEach(columnValue ->  {
            Button button = new Button (header[columnValue]);
            button.setFont(Font.font("Consolas", FontWeight.BOLD, 22));
            button.setMinWidth(60);
            button.setMaxWidth(Double.MAX_VALUE);
            button.setTextFill(Color.WHITE);
            button.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN,new CornerRadii(5),new Insets(1))));
            if(columnValue == 0){
                button.setOnAction(e -> {
                    if(ascending == true){
                        data.sort((a,b) -> (a[0]).toLowerCase().compareTo((b[0]).toLowerCase()));
                        ascending = false;
                    }else{
                        data.sort((a,b) -> (b[0]).toLowerCase().compareTo((a[0]).toLowerCase()));
                        ascending = true;
                    }
                    update();
                });//i had to try [], then () and eventually {} worked.
                //is there a better way?

            } else{
                if(columnValue == 1) {
                    button.setOnAction(e -> {
                        if(ascending == true){
                            data.sort((a,b) -> (a[1]).toLowerCase().compareTo((b[1]).toLowerCase()));
                            ascending = false;
                        }else{
                            data.sort((a,b) -> (b[1]).toLowerCase().compareTo((a[1]).toLowerCase()));
                            ascending = true;
                        }
                        update();
                    });


                }else{
                final int sorter = columnValue;
                button.setOnAction(e -> {
                    if(ascending == true){
                        data.sort((a,b) -> 
                        {try {
                            return Double.valueOf(a[sorter].strip()).compareTo(Double.valueOf(b[sorter].strip()));
                        } catch (NumberFormatException appendixBurstingBrutally) {
                            return a[sorter].compareTo(b[sorter]);
                        }
                });//sort ends here

                ascending = false;
            }else{
                data.sort((a,b) -> 
                        {try {
                            return Double.valueOf(b[sorter].strip()).compareTo(Double.valueOf(a[sorter].strip()));
                        } catch (NumberFormatException appendixBurstingBrutally) {
                            return b[sorter].compareTo(a[sorter]);
                        }
                });

                ascending = true;
            }
                update();
                }//event ends here
                );//set on action ends here
            }
        }
            pane.add (button, columnValue, 0);
        });

        // // Use the rest of the data to fill in the labels.
        // String line = fin.readLine (); 
        // while (line != null) {
        //     String[] record = line.strip ().split (",");
        //     // Store all the data in a list so it can be easily sorted
        //     // later on (List.sort)
        //     data.add (record);
        //     col = 0;
        //     lables.add (new ArrayList<>());
        //     for (String value : record) {
        //         Label label = new Label (value);
        //         // Keep track of all the labels so they can be adjusted without
        //         // haveing to find them in the Grid which can be a pain.
        //         lables.get (row - 1).add (label);
        //         pane.add (label, col, row);
        //         col++;    
        //     }
        //     row++;
        //     line = fin.readLine (); 
        // }
        fin.close ();

        IntStream.range(0, data.size()).forEach(row -> {
            List<Label> labelRow = Arrays.stream(data.get(row))
                    .map(text ->{

                        Label label = new Label(text);
                        label.setMinSize(100, 20);
                        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
                        label.setAlignment(Pos.CENTER_RIGHT);
                        label.setPadding(new Insets(5));
                        label.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
                        // label.setBackground(new Background(new BackgroundFill(Color.DARKBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
                        label.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 18));
                        if(row % 2 == 0){
                            label.setTextFill(Color.DARKBLUE);
                        }else{
                            label.setTextFill(Color.DARKCYAN);
                        }
                        
                        return label;

                    })
                    .collect(Collectors.toList());
            labels.add(labelRow);
            IntStream.range(0, labelRow.size()).forEach(col -> {
                if(col==1||col==0){
                    labelRow.get(col).setTextFill(Color.DARKMAGENTA);
                    labelRow.get(col).setAlignment(Pos.CENTER_LEFT);;
                    labelRow.get(col).setFont(Font.font("Times New Roman", FontWeight.BOLD, 19));
                    pane.add(labelRow.get(col), col, row + 1);
                }else{
                pane.add(labelRow.get(col), col, row + 1);
            }});
        });

        scroller.setContent (pane);
        scroller.setPrefSize(100000, 100000);
        Scene scene = new Scene (scroller);
        stage.setScene (scene);
        // stage.sizeToScene();
        stage.setTitle("Try double clicking the headers");
        stage.setMaximized(true);
        stage.show ();
    }

    // private void sortColumn(final int col) {
    //     data.sort((a, b) -> {

    //             if (a[col].isEmpty()){
    //                 return b[col].isEmpty() ? 0 : 1;
    //             }
    //             if (b[col].isEmpty()){
    //                 return -1;
    //             }
    //             return Double.compare(
    //                 Double.parseDouble(a[col]),
    //                 Double.parseDouble(b[col]));
            
    //             });//sort ends


    //         update();
    //         }//sortcolumn ends
    /**
     * Helper funciton used to update all the labels based on the 
     * data. It should be called whenever the data changes.
     */
    private void update () {
        // int row = 0;
        // for (List<Label> label_row : labels) {
        //     int col = 0;
        //     for (Label label : label_row) {
        //         label.setText (data.get (row) [col]);
        //         col++;
        //     }
        //     row++;
        // }
        IntStream.range(0, labels.size()).forEach(row -> {
            List<Label> labelRow = labels.get(row);
            IntStream.range(0, labelRow.size())
                    .forEach(col -> labelRow.get(col).setText(data.get(row)[col]));
        });
    }

    public static void main (String[] args) {
        // Example of hard coding the args, useful for debugging but
        // should be removed to test using command line arguments.
        String[] args1 = new String[] {"data/grades_010.csv"};
        String[] args2 = new String[] {"data/grades_363.csv"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 010 or 363 to see the table:");
        int a = scanner.nextInt();
        if(a ==10){
            launch (args1);
        }else if(a ==363){
            launch (args2);
        }else{
            System.out.println("Womp womp");
        }
        scanner.close();
    }
    
}
