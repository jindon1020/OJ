package code.zjd.forPractice.problems.Searching_4;

/**
 * @author zjd123
 * @date 2019/11/14 - 11:35
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    static int n, x, index;

    static double a[];

    static double force(double m) {
        double distance = 0;
        for (int i = 0; i <= index; i++) {

            distance = distance - 1 / (m - a[i]);
        }

        for (int i = index + 1; i < x; i++) {

            distance = distance + 1 / (a[i] - m);
        }

        // System.out.println(distance);
        return (distance);
    }

    public static void main(String args[]) {
        {
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();
            while (n-- > 0) {
                x = sc.nextInt();
                a = new double[x];
                for (int i = 0; i < x; i++) {
                    a[i] = sc.nextInt();
                }
                index = 0;
                for (int i = 0; i < x - 1; i++) {
                    index = i;
                    double l = a[i];
                    double h = a[i + 1];
                    while (l < h) {

                        double mid = (l + h) / 2;
                        DecimalFormat df = new DecimalFormat(".###");
                        double force = Double.valueOf(df.format(force(mid)));
                        if (force > 0) {
                            h = mid - 0.0000000000001;
                        } else if (force < 0) {
                            l = mid + 0.0000000000001;
                        } else if (force == 0) {
                            DecimalFormat df1 = new DecimalFormat(".##");
                            System.out.print(String.format("%.2f", Double.valueOf(df1.format(mid))) + " ");
                            break;
                        }

                    }//while
                }
                System.out.println();

            }
        }
    }
}

