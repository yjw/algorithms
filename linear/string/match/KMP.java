public class KMP {
    private String pat;
    private int[][] dfa;
    
    public KMP (String pat) {
        this.pat = pat;
        int M = pat.length;
        int R = 256;
        dfa = new int[M][R];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }
    
    public int search(String txt) {
        int i, j N = txt.length(); M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M)
            return i - M;
        else 
            return N;
    }
}

/**
 字符串匹配问题是字符串特有的问题，是整个字符串问题的核心：
 因为其它的问题都可以转化为数组问题。
 */

/**
 怎么样理解KMP算法，
 
 */