import sprint1.K;

public class Windows98Machine{

    private final Keyboard keyboard;
    private final Monitor monitor;

    public Windows98Machine(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

    public static void main(String[] args) {
        Windows98Machine win = new Windows98Machine(new StandardKeyboard(), new Monitor() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        win.keyboard.print(" dsa");
    }
}

