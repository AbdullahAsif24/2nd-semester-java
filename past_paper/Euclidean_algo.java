/*
The Euclidean Algorithm for finding the Greatest Common Divisor (GCD) is as follows:
$a = bq + r$ (where $a \ge b$). Replace $a$ with $b$ and $b$ with $r$. Repeat until $r=0$.
GCD is the final $b$.
Write a Java method named findGCD that takes two integers, $a$ and $b$, as parameters
and returns their Greatest Common Divisor using the Euclidean Algorithm.
*/

public class Euclidean_algo {
    public static void main(String[] args) {
        System.out.println(findGCD(100, 50));
    }

    public static int findGCD(int a, int b) {
        if (a >= b) {
            int q = a / b;
            int r = a % b;

            while (r != 0) {
                q = a / b;
                r = a % b;

                a = b;

                b = r;
            }

        }
        return b;
    }
}
