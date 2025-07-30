

public class BitOperator {
    public static void main(String[] args) {
        // ---------Check specific bit ------------

        byte b1 = (byte) 0b10101010;  // Example byte
        int bitPosition = 3; // we can take this input from user

        int bit = (b1 >> bitPosition) & 1;
        // System.out.println(Integer.toBinaryString(bit));

        // ---------- Check n consecutive bits -------------

        int b2 = 0b10101010;
        int position = 3;
        int n = 3;

        int mask = (1 << n) - 1;
        int consecutiveBits = (b2 >> position) & mask;
        // System.out.println(Integer.toBinaryString(consecutiveBits));


        
    }
}
