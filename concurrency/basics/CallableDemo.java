import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class CallableDemo {
    public static void main (String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> x : results) {
            try {
                System.out.println(x.get());
            }
            catch(Exception e) {
                System.out.println(e);
            }   
        }
        exec.shutdown();
        
    }
}
