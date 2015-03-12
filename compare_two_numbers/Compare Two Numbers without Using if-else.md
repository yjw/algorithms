# Compare Two Numbers without Using if-else


Write a method to find the maximum of two numbers. You should not use if-else or any other comparison operator.

## Thoughts

If the signs are different, we can easily tell which number is larger. But how can we pick up the one without using **if-else**? So the only interesting way is to compute *a - b* and test the sign of this difference. Then using multiplication to add these two together.

We can implement the code as follows:

```java
/*Flip a 1 to a 0 and a 0 to a 1*/
public int flip(int bit) {
    return 1^bit;
}
```

```java
/*returns 1 if it is positive, and a 0 if it is negative*/
public int sign (int a) {
    return flip((a>>31) & 0x01);
}
```

```java
public int getMaxNaive(int a, int b) {
    int k = sign(a - b);
    int q = flip(k);
    return a * k + b * q;
}
```

This code almost works but it fails, unfortunately, when *a - b* overflows. But when does *a - b* overflow? *a* and *b* must be with different signs. 

So the algorithm would be like:
```
if a and b have different signs
	if a > 0, then b < 0, and k = 1
	if a < 0, then b > 0, and k = 0
	
```
The code below implements this, using multiplication instead of if-statements.

```java
public int getMax(int a, int b) {
	int c = a - b;
	int sa = sign(a);
	int sb = sign(b);
	int sc = sign(c);

	/*Two cases:
		1. Different signs:
			1.1 a's is minus
	*/ 
	int different_sign = sa ^ sb;
	int use_sign_of_c = flip(sa ^ sb);
	int k = different_sign * sa + use_sign_of_c * sc;
	int q = flip(k);

	return a * k + b * q;
}
```