package selfeducation.patterns.state;

public class OnState extends RemoteControlState{
    public void changeState(TV context) {
        System.out.println("I am already On .Going to be Off now");
        context.setState(new OffState());
    }
}
