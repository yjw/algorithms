public class PrimeSieve {
    public void prime (int N) { 
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i*i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }
        
        int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes++;
            }
        }
        System.out.println("The number of primes <= " + N + " is " + primes);
    }
}
