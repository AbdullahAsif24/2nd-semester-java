import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class dayOfWeekWise {
    public static void main(String[] args) {

        try {

            File file1 = new File("C:\\Users\\Lab User\\Desktop\\abd-java\\27-10-25\\data.txt");

            Scanner sc1 = new Scanner(file1);

            HashMap<String, Integer> dayArr = new HashMap<>();

            String line = sc1.nextLine();
            while (sc1.hasNext()) {
                line = sc1.nextLine();

                String[] arr = line.split("\t");

                String dateString = arr[0];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

                LocalDate date = LocalDate.parse(dateString, formatter);

                String dayOfWeek = date.getDayOfWeek().toString();


                if (!dayArr.containsKey(dayOfWeek)) {
                    dayArr.put(dayOfWeek, 0);
                }

                int sumOfL = Integer.parseInt(arr[4]) * Integer.parseInt(arr[5]);

                dayArr.put(dayOfWeek, (dayArr.get(dayOfWeek) + sumOfL));

            }

            for (String pr : dayArr.keySet()) {
                System.out.println(pr + " : " + dayArr.get(pr));
            }

        } catch (Exception e) {

        }
    }
}
