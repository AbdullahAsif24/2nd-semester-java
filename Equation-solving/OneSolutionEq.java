import java.util.Scanner;

public class OneSolutionEq {
    // Function to find root of
    static double f(double x) {
        return x*x - 5*x + 6; // (x-2)(x-3)
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Range Start: ");
            double a = sc.nextDouble();
            System.out.print("Enter Range End: ");
            double b = sc.nextDouble();

            double fa = f(a);
            double fb = f(b);

            // Check that a root is bracketed
            if (fa == 0.0) {
                System.out.println("Root at a: " + a);
                return;
            }
            if (fb == 0.0) {
                System.out.println("Root at b: " + b);
                return;
            }
            if (fa * fb > 0) {
                System.out.println("No sign change on [a,b]; a single root is not guaranteed.");
                return;
            }

            double eps = 1e-9;        // tolerance for x
            int maxIters = 100;       // safety cap
            double c = a, fc = fa;

            for (int it = 0; it < maxIters && (b - a) > eps; it++) {
                c = (a + b) / 2.0;
                fc = f(c);

                if (fc == 0.0) break; // hit root exactly (rare with doubles)

                // Keep the sub-interval that contains the sign change
                if (fa * fc < 0) {
                    b = c;
                    fb = fc;
                } else {
                    a = c;
                    fa = fc;
                }
            }

            System.out.printf("Approx root: %.12f%n", c);
            System.out.printf("f(root): %.12e%n", f(c));
            System.out.printf("Final interval: [%.12f, %.12f]%n", a, b);
        }
    }
}


