package unit13.assignments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import unit13.backtracker.Backtracker;
import unit13.backtracker.Configuration;

public class HangManConfiguration implements Configuration<HangManConfiguration> {
    private String secretPhrase;
    private char[] guessedLetters = new char[26];

    public HangManConfiguration(String secretPhrase) {
        this.secretPhrase = secretPhrase.toLowerCase();
        // this.guessedLetters = new char[26];
    }

    @Override
    public Collection<HangManConfiguration> getSuccessors() {
        List<HangManConfiguration> successors = new ArrayList<>();
        for (char charaxter = 'a'; charaxter <= 'z'; charaxter++) {
            if (!contains(guessedLetters, charaxter)) {
                HangManConfiguration successor = new HangManConfiguration(secretPhrase);
                successor.guessedLetters = guessedLetters.clone();
                successor.guessedLetters[charaxter - 'a'] = charaxter;
                successors.add(successor);
            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {

        return true;
    }

    @Override
    public boolean isGoal() {
        return secretPhrase.chars().allMatch(c -> c == ' ' || contains(guessedLetters, (char) c));
    }

    @Override
    public String toString() {

        return String.valueOf(guessedLetters) + ", " +
                    secretPhrase.replaceAll("[a-z]", "_").replaceAll(" ", " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a secret phrase: ");
        String secretPhrase = scanner.nextLine().toLowerCase();

        HangManConfiguration initialConfig = new HangManConfiguration(secretPhrase);
        Backtracker<HangManConfiguration> backtracker = new Backtracker<>(true);
        HangManConfiguration solution = backtracker.solve(initialConfig);

        if (solution != null) {
            System.out.println(solution);
        } else {
            System.out.println("No sol");
        }
        scanner.close();
    }

    private static boolean contains(char[] array, char key) {
        for (char c : array) {
            if (c == key) {
                return true;
            }
        }
        return false;
    }
}