public class myCode {

    public static void main(String[] args) {
        //                  1  2     3           4                       5
        int[] msgBit = { 2, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };

        
        int z = 0;
        for (int i = 1; i < msgBit.length; i = (int)(Math.pow(2, z))) {

            if (i < msgBit.length) {

                int sum = 0;

                for (int k = i; k < msgBit.length; k += (2 * i)) {

                    int m = k;
                    while (m < (k + i) && m < msgBit.length) {

                        if (m < msgBit.length) {
                            sum += msgBit[m];
                        }

                        m++;
                    }

                }
                z++;

                System.out.println("h" + i + " = " + sum + "  " + (sum % 2));

            }
        }
    }
}
