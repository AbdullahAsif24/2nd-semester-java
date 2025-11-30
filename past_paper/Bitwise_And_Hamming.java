import java.util.ArrayList;
import java.util.Scanner;

public class Bitwise_And_Hamming {
    public static void main(String[] args) {
        ArrayList<String> last = remaking(passToBinary(passTaker()));

        for (String string : last) {
        System.out.println(string);
        }


    }

    /*
     * Part A: convertToBits Method (Java)
     * Implement the following Java method which accepts a text message and returns
     * a
     * List<String> containing the 8-bit binary representation of each character
     * (e.g., 'A' -> "01000001").
     */
    public static ArrayList<String> convertToBits(String text) {
        char[] chArr = text.toCharArray();

        ArrayList<String> finalList = new ArrayList<>();
        for (int i = 0; i < chArr.length; i++) {
            int a = (int) chArr[i];

            // Convert to 8-bit binary
            String binary = String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0');

            finalList.add(binary);
        }

        return finalList;
    }

    /*
     * Part B: Hamming Codes (Java Algorithm)
     * a) Write a Java program snippet that keeps taking an input password until it
     * is of exactly 8
     * characters.
     * b) Use the convertToBits function to convert the 8-character password to its
     * bit
     * representation and store it in a variable named hammingCodes (List<String>).
     * c) Describe the Java algorithm/logic to insert the positions for Hamming
     * parity bits (at 2^k positions, i.e., 1, 2, 4, 8, ...) into the bit string
     * for a single character.
     * d) Write a function named calculateHammingBit that accepts a list of bits
     * (the data word with
     * parity positions) and an integer parity position $P$ (e.g., 1, 2, or 4), and
     * returns the calculated
     * Hamming bit using the Even Parity scheme
     */

    public static String passTaker() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter pass of 8 characters");
        String pass = sc.nextLine();

        while (pass.length() != 8) {
            System.out.println("Enter again pass of 8 characters");
            pass = sc.nextLine();
        }

        return pass;
    }

    public static ArrayList<String> passToBinary(String pass) {
        ArrayList<String> hammingcodes = convertToBits(pass);
        return hammingcodes;
    }

    // make arraylist again of containig hamming bit
    public static ArrayList<String> remaking(ArrayList<String> pass) {
        for (int i = 0; i < pass.size(); i++) {
            StringBuilder str = new StringBuilder();
            int[] arr = calculateHammingBit(pass.get(i));
            for (int j = 0; j < arr.length; j++) {
                str.append(arr[j]);
            }
            pass.set(i, str.reverse().toString());
        }

        return pass;
    }

    // calculate and place hamming bit for 8 bit string pass ascii
    public static int[] calculateHammingBit(String bitsString) {
        // Convert char '0'/'1' to actual integer 0/1
        int[] dataBits = new int[bitsString.length()];
        for (int i = 0; i < bitsString.length(); i++) {
            dataBits[i] = bitsString.charAt(i) - '0';
        }

        // 8 data bits + 4 parity bits = 12 bits
        int[] placedArr = new int[12];

        int z = 0;

        // Fill parity placeholders (positions that are powers of 2)
        for (int pos = 1; pos <= 12; pos++) {
            if ((pos & (pos - 1)) == 0) {
                placedArr[pos - 1] = 0; // parity placeholder
            } else {
                placedArr[pos - 1] = dataBits[z];
                z++;
            }
        }

        // Calculate parity bits
        for (int p = 1; p <= 8; p *= 2) {
            int sum = 0;
            for (int j = p; j <= 12; j++) {
                if ((j & p) != 0) {
                    sum += placedArr[j - 1];
                }
            }
            placedArr[p - 1] = sum % 2; // EVEN parity
        }

        return placedArr;
    }

}
