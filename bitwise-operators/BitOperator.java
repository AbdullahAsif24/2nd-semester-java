

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


       // ------------------- how to make a specific bit 1, 0 hai to 1 ho aur 1 hai to 1 rahe -------------
       int b3 = 0b10101010;
       int changePos1 = 2;

       int result = b3 | (1 << changePos1);
    //    System.out.println(Integer.toBinaryString(result));



    
       

       // ------------------- how to make a specific bit 0, 0 hai to 0 rahe aur 1 hai to 0 ho -------------  


                    int b4 = 0b10101010;     // binary: 10101010
    // 11111111111111111111111111110111      // mask
        int changePos2 = 3;      // we want to clear bit at position 3

        int result2 = b4 & ~(1 << changePos2); // clear that bit

        // System.out.println("Original:        " + Integer.toBinaryString(b4));
        // System.out.println("After clearing:  " + Integer.toBinaryString(result2));
        // System.out.println("1s in result:    " + Integer.bitCount(result2));





        // ------------------- how to toggle a specific bit  -------------
        int b5 = 0b10101010; 
        int changePos3 = 2;   
        
        int checkBit = (b5 >> changePos3) & 1;
        String finalResult ;
        if (Integer.parseInt(Integer.toBinaryString(checkBit)) == 0b1) {
            finalResult = Integer.toBinaryString(b5 & ~(1 << changePos3));
        }else{
            finalResult = Integer.toBinaryString(b5 | (1 << changePos3));
        }

        System.out.println(finalResult);
    }
}
