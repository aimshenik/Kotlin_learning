package selfeducation.patterns.state;

public class Main {
    public static void main(String[] args) {
        System.out.println("***State Pattern Demo***\n");
        //Initially TV is Off
        OffState initialState = new OffState();
        TV tv = new TV(initialState);
        //First time press
        tv.pressButton();
        //Second time press
        tv.pressButton();

    }
}
