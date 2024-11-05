package products;

import toys.Doll;
import toys.Toy;

public class Factory {
        public Toy manufactureProduct(){
            Doll doll = new Doll("4567890", 14.99, "Blonde", "Blue");
        return doll;
    }
}
