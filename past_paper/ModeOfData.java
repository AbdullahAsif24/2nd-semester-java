/* Write a Java function to find the mode of a sequence of integers.
The mode is the value that appears the highest number of times.
sequence of items is [1,5,2,4,8,2,1,4,2,6,1,3,2,2,8] then mode of this data is 2. */

import java.util.HashMap;

public class ModeOfData {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 2, 7,7,7 };

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            }
            else {
                m.put(arr[i], 1);
            }
        }

        int largest = arr[0];

        for (int i : m.keySet()) {
            if (largest < m.get(i)) {
                largest = i;
            }
        }

        System.out.println(largest);

    }

}
