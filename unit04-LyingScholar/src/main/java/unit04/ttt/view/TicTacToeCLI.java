package unit04.ttt.view;

import java.util.Arrays;
import java.util.Scanner;

import unit04.ttt.model.TicTacToe;
import unit04.ttt.model.TicTacToeException;

/**
 * Provides a simple command-line-interface (CLI) for playing a game of 
 * Tic-Tac-Toe.
 */
public class TicTacToeCLI {
    /**
     * The help command.
     */
    public static final String HELP = "help";

    /**
     * The quit command.
     */
    public static final String QUIT = "quit";

    /**
     * The move command.
     */
    public static final String MOVE = "move";

    /**
     * The reset command.
     */
    public static final String RESET = "reset";

    /**
     * Plays a game of Tic-Tac-Toe using a command line interface.
     * 
     * @param ttt The TicTacToe used to run the game.
     */
    public static void playTicTacToe(TicTacToe ttt) {
        boolean sentinel = true;
        Scanner scanner = new Scanner(System.in);
        while(sentinel) {
            System.out.println(ttt);
            System.out.print(">> ");
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");
            if(tokens.length > 0) {
                switch(tokens[0]) {
                    case HELP:
                        help();
                        break;
                    case QUIT:
                        sentinel = quit(scanner);
                        break;
                    case MOVE:
                        move(ttt, tokens);
                        break;
                    case RESET:
                        reset(ttt);
                        break;
                }
            }
            System.out.println("Game status: " + ttt.getStatus());
        }
        System.out.println("Good bye!");
        scanner.close();
    }

    /**
     * Prints a help message.
     */
    private static void help() {
        System.out.println("Enter one of the following commands: ");
        System.out.println("  help - displays this message");
        System.out.println("  quit - quits the game");
        System.out.println("  move <row> <col> - attempts to make a move at "
            + "the specified (row, col) on the board");
        System.out.println("  reset - starts a new game");
    }

    /**
     * Prompts the user to ensure that they want to quit.
     * 
     * @param scanner The scanner used to read user input.
     * 
     * @return True if the game should continue, false if it should quit.
     */
    private static boolean quit(Scanner scanner) {
        System.out.print("Are you sure (y/n): ");
        String response = scanner.nextLine();
        return !response.toLowerCase().equals("y");
    }

    /**
     * Attempts to make a move on the Tic-Tac-Toe board.
     * 
     * @param ttt The TicTacToe used to control the game.
     * 
     * @param tokens The user's input for the move.
     */
    public static void move(TicTacToe ttt, String[] tokens) {
        System.out.println(Arrays.toString(tokens));
        if(tokens.length == 3) {
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            try {
                ttt.move(row, col);
            } catch (TicTacToeException e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("Usage: move <row> <col>");
        }
    }

    /**
     * Resets the Tic-Tac-Toe game.
     * 
     * @param ttt The TicTacToe that is to be reset.
     */
    public static void reset(TicTacToe ttt) {
        ttt.reset();
    }

    /**
     * Plays a game of Tic-Tac-Toe using a command line interface.
     * 
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        playTicTacToe(ttt);
    }   
}
