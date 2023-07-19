package selfeducation.patterns.state;

public class TV {

    private RemoteControlState state;

    public RemoteControlState getState() {
        return state;
    }

    public void setState(RemoteControlState state) {
        this.state = state;
    }

    public TV(RemoteControlState state) {
        this.state = state;
    }

    public void pressButton(){
        state.changeState(this);
    }
}
