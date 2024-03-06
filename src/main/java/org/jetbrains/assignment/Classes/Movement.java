public class Movement {
    private String direction;

    public Movement(String direction, int steps) {
        this.direction = direction;
        this.steps = steps;
    }

    private int steps;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }





}
