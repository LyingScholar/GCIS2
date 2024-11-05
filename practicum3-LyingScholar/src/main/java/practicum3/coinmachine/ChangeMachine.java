package practicum3.coinmachine;

import java.util.ArrayList;
import java.util.List;

    //I'm not american, 
    //I have no idea what your currencies are, sorry if these are wrong
    //I just remember these from what we did in class

public class ChangeMachine {
    public static List<Coins> makeCoinChange(double price, double payment) {
        List<Coins> change = new ArrayList<>();

        //ignoring all the dollars here
        double changeAmount = (payment - price) - (int)(payment - price);

        for (Coins coin : Coins.values()) {
            int coinCount = (int) (changeAmount / coin.getValue());
            for (int i = 0; i < coinCount; i++) {
                change.add(coin);
                changeAmount -= coin.getValue();
            }
        }

        return change;
    }

    // helper method:
    public static double coinCounter(double amount, Coins coin, List<Coins> change) {
        double remainingAmount = amount;
            while (remainingAmount >= coin.getValue()) {
                change.add(coin);
                remainingAmount -= coin.getValue();
            }
        return remainingAmount;
    }

    public static void main(String[] args) {
        double price = 3.28;
        double payment = 5.00;
        List<Coins> changeList = makeCoinChange(price, payment);

        System.out.println("amount due: " + price);
        System.out.println("amount paid: " + payment);
        System.out.println("change due: " + changeList);
    }
}
