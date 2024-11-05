package toys;

public abstract class Toy {
        private final String productCode;
        private final String name;
        private final double MSRP;
    
        public Toy(String productCode, String name, double MSRP) {
            this.productCode = productCode;
            this.name = name;
            this.MSRP = MSRP;
        }
    
        public abstract void play();
    
        @Override
        public String toString() {
            return "Product Code: " + productCode + "\nName: " + name + "\nMSRP: " + MSRP;
        }
    }