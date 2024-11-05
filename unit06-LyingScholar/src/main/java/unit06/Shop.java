package unit06;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Shop {
     private Set<Sushi> displayCase;

    public Shop() {
        this.displayCase = new HashSet<>();
        generateSushiDisplay();
    }



    private void generateSushiDisplay() {
        while (this.displayCase.size() < 25) {
            int newSushiNumber = this.displayCase.size() + 1;
            this.displayCase.add(new Sushi(newSushiNumber));
        }
    }


    public Order createOrder(Set<Integer> selectedItemNumbers) {

        Order order = new Order();

        Iterator<Sushi> displayCaseAsViewedByCustomer = displayCase.iterator();
            //sorry for the long name, I was getting confused otherwise
            //its not used later, trust me
        while (displayCaseAsViewedByCustomer.hasNext()) {
            Sushi sushi = displayCaseAsViewedByCustomer.next();

            if (selectedItemNumbers.contains(sushi.getNumber())) {
                order.addSushi(sushi);
                displayCaseAsViewedByCustomer.remove();
            }
        }

        return order;
    }

    private static Set<Integer> pickUniqueNumbersHashSet(int min, int max, int lowerBound, int upperBound) {
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        int count = min + random.nextInt(max - min + 1);
        while (uniqueNumbers.size() < count) {
            int number = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            uniqueNumbers.add(number);
        }
        return uniqueNumbers;
    }

    
    public static void main(String[] args) {
        Shop shinjisSpectacularSushiShop = new Shop();

        //select items
        Set<Integer> customersSelectedSushis =  pickUniqueNumbersHashSet(3, 8, 1, 25);;
        

        //make ordr
        Order customerOrder = shinjisSpectacularSushiShop.createOrder(customersSelectedSushis);

        // pay for order
        System.out.println("The total cost is $" + customerOrder.getTotalCost());

        // took the food home
        Stack<Sushi> bag = new Stack<>();
        Sushi sushi;
        while (!customerOrder.itemsList.isEmpty()) {
            bag.push(customerOrder.getNextSushi()); 
        }

        // yummy time
        while (!bag.isEmpty()) {
            sushi = bag.pop(); //we don't know .poll right?
            System.out.println("Eating: " + sushi);
        }
    }
}
