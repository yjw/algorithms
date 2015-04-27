/*
The idiom to use lock

  Lock l = ...;
     l.lock();
     try {
         // access the resource protected by this lock
     } finally {
         l.unlock();
     }

*/

public class Hydrogen {
    Hydrogen() {
        lock.lock();
        wH++;
        while (aH == 0) {
            if (wH >= 2 && wO >= 1) {
                wH -= 2; aH += 2;
                wO-=1; aO+=1;
                waitingH.signal();
                waitingO.signal();
            }
            else {
                waitingH.wait();
            }
        }
        aH--;
        lock.release();
    }
}
