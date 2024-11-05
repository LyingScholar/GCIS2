package unit11.trafficlights;

import java.util.Random;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

        private static final Direction[] VALUES = Direction.values();
        private static final int SIZE = VALUES.length;
        private static final Random RNG = new Random();

        public static Direction getRandomDirection() {
            return VALUES[RNG.nextInt(SIZE)];
        }

        public static Direction oppositeDirection(Direction dir1) {
            switch(dir1){
                case NORTH:
                    return SOUTH;
                case SOUTH:
                    return NORTH;
                case EAST:  
                    return WEST;
                default:
                    return EAST;
                }
        }
}
