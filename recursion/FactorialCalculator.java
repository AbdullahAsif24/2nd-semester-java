import java.math.BigInteger;

// Recursive factorial method.
public class FactorialCalculator {

    public static BigInteger factorial(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) <= 0) // test for base case
            return BigInteger.ONE; // base cases: 0! = 1 and 1! = 1
        else // recursion step
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }

    // output factorials for values 0-21
    public static void main(String[] args) {
        // calculate the factorials of 0 through 21
        for (int counter = 0; counter <= 50; counter++)
            System.out.printf("%d! = %d%n", counter, factorial(BigInteger.valueOf(counter)));
    }
} // end class FactorialCalculator