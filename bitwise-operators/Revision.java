import java.util.Scanner;

public class Revision {
    /**
     * This function calculates the two's complement negative of an integer.
     */
    public static void negativeIntShower() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter int to show it in negative");

        int aap = sc.nextInt();

        // Calculate the two's complement negative.
        // The expression (~aap) inverts all the bits (one's complement).
        // The '| 1' (bitwise OR with 1) is likely an error or specific test case,
        // as two's complement is correctly found by (~aap) + 1.
        int y = (~aap) | 1;

        // Print the binary string representation of the resulting integer 'y'
        System.out.println(Integer.toBinaryString(y));
    }

    /**
     * This method checks a specific bit position using Math.pow to create the mask.
     */
    public static void bitchecker() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter int"); // Prompt for the main number
        int aap = sc.nextInt(); // Read the integer

        System.out.println("Enter specific bit position to check"); // Prompt for position
        // Read position 'n' and subtract 1 to convert it to a 0-indexed exponent
        int n = sc.nextInt() - 1;

        // Calculate the mask: 2^n. Using Math.pow requires a cast to int,
        // which is less efficient than bit shifting (as seen in SirCode).
        int m = (int) Math.pow(2, n);

        // Perform bitwise AND to check if the bit at the mask's position is set
        int result = aap & m;

        // Check the result of the bitwise AND operation
        if (result == 0) {
            System.out.println("bit is zero"); // If result is 0, the bit was 0
        } else {
            System.out.println("bit is 1"); // Otherwise, the bit was 1
        }
    }

    /**
     * This method checks a specific bit position using the efficient bit shift
     * approach.
     */
    public static void SirCode() {
        // Initialize Scanner for input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter int"); // Prompt for the main number
        int aap = sc.nextInt(); // Read the integer

        System.out.println("Enter specific bit position to check"); // Prompt for position
        int n = sc.nextInt(); // Read the 1-indexed position

        int m = 1; // Start with the mask at the first bit (position 1)
        // Shift the mask (1) left by (n-1) positions to align it with the desired bit
        // 'n'
        m = m << (n - 1);

        int y = aap & m; // Perform bitwise AND

        // Check the result
        if (y == 0) {
            System.out.println("zero"); // Bit is 0
        } else {
            System.out.println("one"); // Bit is 1
        }
    }

    /**
     * This function manually generates the 32-bit binary string of an integer
     * by iterating 32 times and shifting the number to the right (LSB method).
     */
    public static void bitsShower() {
        // Initialize Scanner for input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter int to show its bits"); // Prompting for input
        int aap = sc.nextInt(); // Read the integer

        int m = 1; // Mask initialized to 1 (to check the Least Significant Bit)
        int y; // Variable to hold the result of the bitwise AND

        String result = ""; // Initialize result string

        // Loop 32 times for a standard Java int (32 bits)
        for (int i = 0; i < 32; i++) {

            // Get the value of the current LSB by ANDing with the mask (m=1)
            y = aap & m;

            // Check if the current LSB is 0 or 1
            if (y == 0) {
                // If 0, prepend "0" to the result string (since we are iterating from right to
                // left)
                result = "0" + result;
            } else {
                // If 1, prepend "1" to the result string
                result = "1" + result;
            }

            // Shift the original number (aap) one position to the right (signed shift)
            // This exposes the next bit to the LSB position for the next iteration.
            aap = aap >> 1;

            // This line was visible in the image but appears to be a commented-out
            // alternative or reference, not part of the active loop logic.
            // m = m * 2; // or m << 1;
        }

        System.out.println(result); // Print the final 32-bit binary string
    }

    /**
     * This function manually generates the 32-bit binary string of an integer
     * by iterating 32 times and shifting the number to the right (LSB method).
     */
    public static void bitsShowerNewLogic() {
        // Initialize Scanner for input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter int to show its bits"); // Prompting for input
        int aap = sc.nextInt(); // Read the integer

        int m = 1; // Mask initialized to 1 (to check the Least Significant Bit)
        int y; // Variable to hold the result of the bitwise AND

        m = m << 31;


        // Loop 32 times for a standard Java int (32 bits)
        for (int i = 0; i < 32; i++) {

            // Get the value of the current LSB by ANDing with the mask (m=1)
            y = aap & m;

            // Check if the current LSB is 0 or 1
            if (y == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }

            m = m >>> 1; // Unsigned Shift // can't use signed shift (>>), because in signed shift on the first time it considered m negative int so move 1 to the right but keep msb 1 also
        }

    }

    // Main method to run all the functions
    public static void main(String[] args) {
        System.out.println("--- Running Transcribed Bitwise Operations ---");

        // Note: Error handling has been omitted to transcribe code exactly,
        // but you should usually use try/catch blocks for Scanner input.

        // Call all transcribed functions
        // negativeIntShower();
        // bitchecker();
        // SirCode();
        // bitsShower();
        bitsShowerNewLogic();

    }

}
