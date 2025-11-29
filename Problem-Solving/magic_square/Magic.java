
public class Magic {
    public static void main(String[] args) {
        int[][] grid = {
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        };

        System.out.println(ourFunc(grid));

    }

    public static int ourFunc(int[][] grid) {
        // int numOfSubs = (grid.length - 3 + 1) * (grid[0].length - 3 + 1);

        // if (numOfSubs < 1) {
        // return 0;
        // }

        int m = grid.length;
        int n = grid[0].length;

        // If grid is smaller than 3×3, return 0
        if (m < 3 || n < 3) {
            return 0;
        }

        int total = 0;

        // Correct generalized loop
        for (int r = 0; r <= m - 3; r++) {
            for (int c = 0; c <= n - 3; c++) {

                int[] abcArr = new int[9];

                int counter = 0;
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        abcArr[counter] = grid[i][j];
                        counter++;
                    }   
                }

                total += magicChecker(abcArr);
            }
        }

        return total;

    }

    public static int magicChecker(int[] abcArr) {
        if (abcArr[4] != 5) {
            return 0;
        }

        // ✅ Check numbers are 1–9 and distinct
        boolean[] seen = new boolean[10];
        for (int x : abcArr) {
            if (x < 1 || x > 9 || seen[x]) {
                return 0;
            }
            seen[x] = true;
        }

        // for rows
        if ((abcArr[0] + abcArr[1] + abcArr[2]) != 15) {
            return 0;
        }
        if ((abcArr[3] + abcArr[4] + abcArr[5]) != 15) {
            return 0;
        }
        if ((abcArr[6] + abcArr[7] + abcArr[8]) != 15) {
            return 0;
        }

        // for columns
        if ((abcArr[0] + abcArr[3] + abcArr[6]) != 15) {
            return 0;
        }
        if ((abcArr[1] + abcArr[4] + abcArr[7]) != 15) {
            return 0;
        }
        if ((abcArr[2] + abcArr[5] + abcArr[8]) != 15) {
            return 0;
        }

        if ((abcArr[0] + abcArr[4] + abcArr[8]) != 15) {
            return 0;
        }
        if ((abcArr[2] + abcArr[4] + abcArr[6]) != 15) {
            return 0;
        }

        return 1;
    }
}