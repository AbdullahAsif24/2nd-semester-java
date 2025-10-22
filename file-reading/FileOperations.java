import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class FileOperations {
    public static void main(String[] args) {
        // Arraylist : add(), get(), set(), and remove()
        // HashMap: put() to add key/value pairs, get() to retrieve a value by key, and
        // remove() to delete an entry
        // HashSet : add(), contains(), and remove()


        calculateProductWiseSum();

        System.out.println("---------------");

        calculateMonthWiseSum();
    }

    public static void calculateProductWiseSum() {
        try {

            File file1 = new File("E:\\UBIT\\2nd semester\\OOP_java\\Pracitce\\file-reading\\Sample.txt");

            Scanner sc1 = new Scanner(file1);

            HashMap<String, Integer> Products = new HashMap<>();

            String line = sc1.nextLine();
            while (sc1.hasNext()) {
                line = sc1.nextLine();

                String[] arr = line.split("\t");

                if (!Products.containsKey(arr[1])) {
                    Products.put(arr[1], 0);
                }

                int sumOfL = Integer.parseInt(arr[2]) * Integer.parseInt(arr[3]);

                Products.put(arr[1], (Products.get(arr[1]) + sumOfL));

            }

            for (String pr : Products.keySet()) {
                System.out.println(pr + " : " + Products.get(pr));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    public static void calculateMonthWiseSum() {
        try {

            File file1 = new File("E:\\UBIT\\2nd semester\\OOP_java\\Pracitce\\file-reading\\Sample.txt");

            Scanner sc1 = new Scanner(file1);

            HashMap<String, Integer> Months = new HashMap<>();

            String line = sc1.nextLine();
            while (sc1.hasNext()) {
                line = sc1.nextLine();

                String[] arr = line.split("\t");

                String month = arr[4].split("/")[0];

                if (!Months.containsKey(month)) {
                    Months.put(month, 0);
                }

                int sumOfL = Integer.parseInt(arr[2]) * Integer.parseInt(arr[3]);

                Months.put(month, (Months.get(month) + sumOfL));

            }

            for (String m : Months.keySet()) {
                System.out.println(m + " : " + Months.get(m));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}