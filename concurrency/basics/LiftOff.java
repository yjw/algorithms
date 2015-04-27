public class LiftOff implements Runnable {
    protected int countdown = 10;
    private static int taskcount = 0;
    private int id = taskcount++;
    public void run () {Thread.yield();
        while (countdown-- > 0) {
            System.out.println("id is " + id + " count is " + countdown);
            Thread.yield();
        }
        System.out.println("Lift off " + id);
    }
}
