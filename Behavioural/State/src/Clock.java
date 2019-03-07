public class Clock {
    private ModeState state;
    private int hours;
    private int minute;
    private Boolean luminosity = false;

    public Clock(int hours, int minute) {
        this.hours = hours;
        this.minute = minute;
        this.state = new DisplayTimeState();
    }

    //getters/setters
    public int getHours() {
        return hours;
    }

    public int getMinute() {
        return minute;
    }

    public Boolean getLuminosity() {
        return luminosity;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setLuminosity(Boolean luminosity) {
        this.luminosity = luminosity;
    }

    public void setState(ModeState state) {
        this.state = state;
    }

    public ModeState getState() {
        return state;
    }

    void nextMode() {
        state.next(this);
    }

    void doFunctionality() {
        state.doAction(this);
    }
}


interface ModeState {
    void doAction(Clock clock);
    void next(Clock clock);
}

class DisplayTimeState implements ModeState {

    @Override
    public void doAction(Clock clock) {
        clock.setLuminosity(!clock.getLuminosity());
        System.out.println("Luminosity: " + clock.getLuminosity());
        String h = clock.getHours() < 10? "0"+(clock.getHours()): Integer.toString(clock.getHours());
        String m = clock.getMinute() < 10? "0"+(clock.getMinute()): Integer.toString(clock.getMinute());
        System.out.println("H: " + h + ":" + m);
    }

    @Override
    public void next(Clock clock) {
        clock.setState(new HoursState());
    }
}

class HoursState implements ModeState{

    @Override
    public void doAction(Clock clock) {
        int increasedHour = clock.getHours();
        if(increasedHour < 24) {
            clock.setHours(++increasedHour);
        } else {
            increasedHour = 0;
        }
        System.out.println("Increased hour by one. H: " + clock.getHours());
    }

    @Override
    public void next(Clock clock) {
        clock.setState(new MinuteState());
    }
}

class MinuteState implements ModeState {

    @Override
    public void doAction(Clock clock) {
        int increasedMinute= clock.getMinute();
        clock.setMinute(++increasedMinute);
        System.out.println("Increased minute by one. M: " + clock.getMinute());
    }

    @Override
    public void next(Clock clock) {
        clock.setState(new DisplayTimeState());
    }

}
