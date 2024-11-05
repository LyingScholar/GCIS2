package petespike.model;

public class Move {
    private Position position;
    private Direction direction;
    
    public Move(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return direction + " from " + position;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Move){
            Move other = (Move)obj;
            return direction.equals(other.direction)&&
                (position == other.position);
        }else{
            return false;
        }
    }
}
