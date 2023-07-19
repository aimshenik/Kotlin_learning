package selfeducation.patterns.state;

public class OffState extends RemoteControlState{
    public void changeState(TV context) {
        System.out.println("I am Off .Going to be On now");
        context.setState(new OnState());
    }
}
