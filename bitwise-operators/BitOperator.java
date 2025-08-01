



public class BitOperator {

    public static void getBit (){
        // -------------------get bit-------------
        // 1. bit mask: 1<<i
        // 2. operation: And
        int n = 5;
        int pos = 2;
        int bitMask = 1<<pos;
        if ((bitMask & n) == 0) {
            System.out.println("Bit was zero");
        } else{
            System.out.println("Bit was one");
        }
    }



    public static void setBit(){
        // -------------------set bit-------------
        // 1. bit mask: 1<<i
        // 2. operation: OR

        int n = 5; // 0101
        int pos = 2;
        int bitMask = 1<<pos;

        int newNumber = bitMask | n;
        System.out.println(newNumber);
    }


    public static void clearBit (){
        // ----------cleat Bit-----------
        // Bit Mask = 1<<i
        // operation = AND with NOT

        int n = 5;
         int pos = 2;
         int bitMask = 1<<pos;
         int notBitMask = ~bitMask;

         int newNumber  = notBitMask & n;
         System.out.println(newNumber);
    }

    public static void updateBit (){
        // -------------update Bit ------------------

        int input = 1;

        int n = 5;
        int pos = 2;
        int bitMask = 1<<pos;

        if (input == 0) {
            // -----for 0--------
            // Bit Mask = 1<<i
            // operation = AND with NOT
            int notBitMask = ~bitMask;
            
            int newNumber  = notBitMask & n;
            System.out.println(newNumber);


        }else if (input == 1) {
            // -----for 1--------
            // Bit Mask = 1<<i
            // operation = OR
            
            int newNumber = bitMask | n;
            System.out.println(newNumber);
        }

    }


    public static boolean isPowerOf2 (int n){
        // ---------check number is a power of 2 or not -----------
        if (n>0) {
            // in power of 2 numbers ==> one bit is set to 1
            return (n & (n-1)) == 0;    // check 8 (1000) and 7 (0111) == 0 or not 
        }else {
            return false;
        }
    }

    public static int  count1s (int n){
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;

    }

    public static String decimalToBinary (int n){
        String result = "";

        while (n>0) {
            result = (n % 2) + result;
            n = n/2;
        }

        return result;
    }

    public static int binaryToDecimal(String s){
        String[] sArr = s.split("");
        int decimal = 0;

        for (int i = 0; i < sArr.length; i++) {
            if (Integer.parseInt(sArr[i]) == 1) {
                decimal +=  Math.pow(2, sArr.length - 1- i);
                
            }
        }

        return decimal;
    }

    public static void main(String[] args) {
        System.err.println("");

        System.out.println(binaryToDecimal("1000"));




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
