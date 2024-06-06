package O2;

public enum CardinalDirection {
    NORTH(0,1,0),
    SOUTH(0,-1,180),
    EAST(1,0,90),
    WEST(-1,0,270);

    int x;
    int y;
    int degree;
    CardinalDirection(int x, int y,int degree){
        this.x = x;
        this.y = y;
        this.degree = degree;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {
        System.out.println(NORTH +" "+ NORTH.getX()+" "+NORTH.getY());
        System.out.println(SOUTH +" "+ SOUTH.getX()+" "+SOUTH.getY());
        System.out.println(EAST +" "+ EAST.getX()+" "+EAST.getY());
        System.out.println(WEST +" "+ WEST.getX()+" "+WEST.getY());

        CardinalDirection d = CardinalDirection.WEST;
        switch (d) {
            case SOUTH:
                System.out.println("South");
                break;
            case NORTH:
                System.out.println("North");
                break;
            case EAST:
                System.out.println("East");
                break;
            case WEST:
                System.out.println("West");
                break;
        }
        System.out.println(d.degree);
    }
}
