package unit06;

public class Sushi implements Comparable<Sushi>{
    int number;
    double weight;
    double price;

    public Sushi(int number, double weight, double price){
            this.number = number;
            this.weight = weight;
            this.price = price;
        }

    public Sushi(int number){
            this.number = number;
            this.weight = 20.0 + Math.random() * 80.0;
            this.price = 10.0 + Math.random() * 30.0;
        }
    
        public int getNumber(){
            return number;
        }
    
        public double getWeight(){
            return weight;
        }
    
        public double getPrice(){
            return price;
        }

        public boolean checkWeight(){
            if(weight <20 ||weight > 100){
                return false;
            }
            return true;
        }
        
        public boolean checkPrice(){
            if(price <20 ||price > 100){
                return false;
            }
            return true;
        }
        @Override
        public String toString() {
            return "Sushi number: " + number + "\nWeight: "
            + weight +" grams\nPrice: $" + price;
        }

        @Override
        public int compareTo(Sushi other) {
        return Double.compare(this.weight, other.weight);

        //or as taught in class:
        // int alpha = (int)(this.weight-other.weight);
        // return alpha;
        
    }
}
