#include<stdio.h>
#include <string.h>

int max(int a, int b) {
    return (a > b)? a : b;
}

int lcs( char *X, char *Y, int m, int n ) {
    int L[n+1][n+1];
    int i, j;
    
    for (i = 0; i <= m; i++) {
        for (j = 0; j <= n; j++) {
            if (i == 0 || j == 0) {
                L[i][j] = 0;
            }
            
            else if (X[i-1] == Y[j-1])
                L[i][j] = L[i-1][j-1] + 1;
 
            else
                L[i][j] = max(L[i-1][j], L[i][j-1]);
        }
    }
    return L[m][n];
}
 
// LCS based function to find minimum number of insersions
int findMinInsertionsLCS(char str[], int n)
{
   // Creata another string to store reverse of 'str'
   char rev[n+1];
   strcpy(rev, str);
   strrev(rev);
 
   // The output is length of string minus length of lcs of
   // str and it reverse
   return (n - lcs(str, rev, n, n));
}
