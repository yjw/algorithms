public class MSD {
    private static final int BITS_PER_BYTE =   8;
    private static final int BITS_PER_INT  =  32;
    private static final int R             = 256;
    private static final int CUTOFF        =  15;
    
    public void sort(String[] a) {
        int N = a.length;
        String[] aux = new String[N];
        sort(a, 0, N - 1, 0, aux);
    }
    
    private int charAt(String s, int d) {
        if (d == s.length()) {
            return -1;
        }
        return s.charAt(d);
    }

    private void sort(String[] a, int lo, int hi, int d, String[] aux) {
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }
        
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c + 2]++;
        }

        // transform counts to indicies
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }

        // copy back
        for (int i = lo; i <= hi; i++) 
            a[i] = aux[i - lo];


        // recursively sort for each character
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
    }


    // insertion sort a[lo..hi], starting at dth character
    private void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }

    // exchange a[i] and a[j]
    private void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
}
