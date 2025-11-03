import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        try {

            File file1 = new File("C:\\Users\\Lab User\\Desktop\\abd-java\\27-10-25\\data.txt");

            Scanner sc1 = new Scanner(file1);

            HashMap<String, Integer> dayArr = new HashMap<>();

            String line = sc1.nextLine();

            String[] menu = line.split("\t");

            System.out.println("Choose option from which you want to calculate sale");

            for (int i = 0; i < menu.length - 2; i++) {
                System.out.println(i + 1 + " " + menu[i]);
            }

            Scanner sc = new Scanner(System.in);
            int userinp = sc.nextInt();

            while (!(userinp > 0 && userinp <= 4)) {
                System.out.println("choose correct option");

                userinp = sc.nextInt();

            }

            int inDate = 0;

            if (userinp == 1) {
                System.out.println("choose option ");
                System.out.println("1. DayOfMonth ");
                System.out.println("2. Month ");
                System.out.println("3. Year ");

                inDate = sc.nextInt();
                while (!((inDate > 0) && (inDate <= 3))) {
                    System.out.println("choose correct option");

                    inDate = sc.nextInt();

                }

            }

            while (sc1.hasNext()) {
                line = sc1.nextLine();

                String[] arr = line.split("\t");

                String choosed;

                if (userinp == 1) {
                    choosed = arr[userinp - 1].split("-")[inDate-1];

                } else {
                    choosed = arr[userinp - 1];
                }

                if (!dayArr.containsKey(choosed)) {
                    dayArr.put(choosed, 0);
                }   

                int sumOfL = Integer.parseInt(arr[4]) * Integer.parseInt(arr[5]);

                dayArr.put(choosed, (dayArr.get(choosed) + sumOfL));

            }

            System.out.println("Result : \n");

            for (String pr : dayArr.keySet()) {
                System.out.println(pr + " : " + dayArr.get(pr));
            }

        } catch (Exception e) {

        }
    }
}
