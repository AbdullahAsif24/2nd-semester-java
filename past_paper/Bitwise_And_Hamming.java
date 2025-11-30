import java.util.ArrayList;
import java.util.Scanner;

public class Bitwise_And_Hamming {
    public static void main(String[] args) {
        ArrayList<String> l = convertToBits("ABC");
        for (String string : l) {
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

    public static String passTaker(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter pass of 8 characters");
        String pass = sc.nextLine();
        
        while (pass.length() != 8) {
            System.out.println("Enter again pass of 8 characters");
            pass = sc.nextLine();            
        }

        return pass;
    }

    public static ArrayList<String> passToBinary(String pass){
        ArrayList<String> hammingcodes = convertToBits(pass);
        return hammingcodes;
    }

}
