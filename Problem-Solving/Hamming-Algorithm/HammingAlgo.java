public class HammingAlgo {
    public static void main(String[] args) {
        int[] inp = { 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0 };
        // int tot = totalParityBit(inp);

        // int[] msgBit = { 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0 };
        // int error = bitsChecker(msgBit);
        // System.out.println(error);

        int[] placed = paritybitPlacer(inp);
        for (int i : placed) {
            System.out.println(i);
        }


    }

    public static int totalParityBit(int[] inp) {
        int lengthOfInp = inp.length;

        int r = 0;

        while (Math.pow(2, r) < lengthOfInp + r + 1) {
            r++;
        }

        return r;
    }

    public static int[] paritybitPlacer(int[] inp) {
        int lengthOfInp = inp.length;
        int totalparityBit = totalParityBit(inp);

        int[] placedArr = new int[totalparityBit + lengthOfInp];

        int p = 0;

        for (int i = 1; i < placedArr.length ; i*=2) {
            
            for (int j = i; j < inp.length; j++) {
                if ((i & j) != 0) {
                    p += inp[j - 1];
                }
            }

            if ((p % 2) != 0 ) {
                
                placedArr[i-1] = 1;
            }else {
                
                placedArr[i-1] = 0;
            }
            
        }

        int z = 0;

        for (int i = 0; i < placedArr.length && z<inp.length; i++ ) {
            if (!(i != 0) && ((i & (i - 1)) == 0)) {
                placedArr[i] = inp[z]; 
            }

            z++;
        }


        return placedArr;
    }

    public static int bitsChecker(int[] msgBits) {
        int lengthOfMsg = msgBits.length;

        int parityBits = (int)(Math.ceil(Math.log(lengthOfMsg) / Math.log(2))); // approximate parity count

        int errorPos = 0;

        for (int i = 0; i <= parityBits; i++) {

            int parityPos = (int) Math.pow(2, i); // 1,2,4,8,...
            int sum = 0;

            for (int j = 1; j < lengthOfMsg; j++) {
                if ((j & parityPos) != 0) {
                    sum += msgBits[j - 1];
                }
            }

            if (sum % 2 != 0) {
                errorPos += parityPos;
            }
        }

        return errorPos;
    }

    // Function to check the Hamming code using group-skip method
    /*
     * public static int checkHamming(int[] msgBits) {
     * 
     * int n = msgBits.length;
     * int errorPos = 0;
     * 
     * // For each parity bit position (1, 2, 4, 8, ...)
     * for (int p = 1; p <= n; p *= 2) {
     * int sum = 0;
     * int i = p; // start from the parity position
     * 
     * while (i <= n) {
     * // Take 'p' bits
     * for (int j = i; j < i + p && j <= n; j++) {
     * sum += msgBits[j - 1]; // array is 0-based
     * }
     * // Skip 'p' bits
     * i += 2 * p;
     * }
     * 
     * // Check parity (even parity example)
     * if (sum % 2 != 0) {
     * errorPos += p; // add this parity's position
     * }
     * }
     * 
     * return errorPos; // 0 means no error
     * }
     */

}