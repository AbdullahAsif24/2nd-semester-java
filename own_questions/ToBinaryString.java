import java.util.Scanner;

public class ToBinaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number: ");

        int x = sc.nextInt();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            result.append((x >> i) & 1);
            
        }

        System.out.println(result.reverse().toString());
    }
}