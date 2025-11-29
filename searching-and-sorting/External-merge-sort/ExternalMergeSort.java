/*
 * External Merge Sort:
 * --------------------
 * We use External Merge Sort when data is stored in files and 
 * the data size is too large to fit in memory.
 *
 * Algorithm Steps:
 *
 * Given file F = [31, 92, 55, 15, 44, 46, 38, 90, 79, 35]
 *
 * 1) Split Phase:
 *    - Split F into two files:
 *         F1 = [31, 92, 15, 44, 46, 79]
 *         F2 = [55, 38, 90, 35]
 *
 *    - Now check elements sequentially and write them 
 *      into runs (sorted subsequences).
 *    - Example:
 *         31 < 92 → store in same run file
 *         92 > 55 → switch to another run file
 *         55 > 15 → switch again
 *         ...
 *    - This process produces sorted runs stored across files.
 *
 * 2) Merge Phase:
 *    - Merge runs from F1 and F2.
 *    - Example:
 *         F1 = [31, 92, 15, 44, 46, 79]
 *         F2 = [55, 38, 90, 35]
 *
 *    - Compare first values from each file:
 *         Write the smaller value to output file
 *         Move pointer forward in that file
 *         Repeat until all values are merged
 *
 *    - Do this in a loop until all files are merged into one sorted file.
 *
 * Final Step:
 *    - After sufficient passes of splitting and merging,
 *      we get the fully sorted file.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ExternalMergeSort {
    private static String given = "E:\\UBIT\\2nd semester\\OOP-Java\\searching-and-sorting\\External-merge-sort\\GivenFile.txt";
    private static String f1 = "E:\\UBIT\\2nd semester\\OOP-Java\\searching-and-sorting\\External-merge-sort\\tempfile1.txt";
    private static String f2 = "E:\\UBIT\\2nd semester\\OOP-Java\\searching-and-sorting\\External-merge-sort\\tempfile2.txt";

    public static void main(String[] args) throws Exception {

        int runs;
        do {
            runs = splitFunc(); // split into runs and return count
            mergeFunc(); // merge the runs
        } while (runs > 1);

    }

    public static int splitFunc() throws Exception {
        
        int runCount = 1;

        // given file read
        BufferedReader br = new BufferedReader(new FileReader(given));

        // file write
        
        BufferedWriter bWriter1 = new BufferedWriter(new FileWriter(f1));
        BufferedWriter bWriter2 = new BufferedWriter(new FileWriter(f2));

        int n1;
        int n2;
        String l1, l2;
        BufferedWriter currWrFile = bWriter1;

        if ((l1 = br.readLine()) != null) {

            n1 = Integer.parseInt(l1);
            currWrFile.write(String.valueOf(n1));
            currWrFile.newLine();

            while ((l2 = br.readLine()) != null) {
                n2 = Integer.parseInt(l2);

                if (n1 > n2) {
                    currWrFile = currWrFile == bWriter1 ? bWriter2 : bWriter1;
                    runCount++;
                }

                currWrFile.write(String.valueOf(n2));
                currWrFile.newLine();

                n1 = n2;

            }
        }
        
        br.close();
        bWriter1.close();   
        bWriter2.close();

        return runCount;
    }

    public static void mergeFunc() throws Exception {


        Scanner br1 = new Scanner(new File(f1));
        Scanner br2 = new Scanner(new File(f2));

        BufferedWriter brWr = new BufferedWriter(new FileWriter(given));

        Integer n1 = br1.hasNextInt() ? br1.nextInt() : null;
        Integer n2 = br2.hasNextInt() ? br2.nextInt() : null;

        while (n1 != null && n2 != null) {
            if (n1 <= n2) {
                brWr.write(n1.toString());
                brWr.newLine();
                n1 = br1.hasNextInt() ? br1.nextInt() : null; // advance br1
            } else {
                brWr.write(n2.toString());
                brWr.newLine();
                n2 = br2.hasNextInt() ? br2.nextInt() : null; // advance br2
            }
        }

        // Write remaining numbers from br1
        while (n1 != null) {
            brWr.write(n1.toString());
            brWr.newLine();
            n1 = br1.hasNextInt() ? br1.nextInt() : null;
        }

        // Write remaining numbers from br2
        while (n2 != null) {
            brWr.write(n2.toString());
            brWr.newLine();
            n2 = br2.hasNextInt() ? br2.nextInt() : null;
        }

        brWr.close();
        br1.close();
        br2.close();

    }
}