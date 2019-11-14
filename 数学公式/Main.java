package code.zjd.forPractice.problems.数学公式;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author zjd123
 * @date 2019/11/13 - 11:12
 */
public class Main {

    static void pow(int a, int b, int c){
//        BigInteger A = new BigInteger(Integer.toString(a));
//        BigInteger T = new BigInteger("1");
//        for (int i = 0; i < b; i++) {
//            T = T.multiply(A);
//        }
//        BigInteger C = new BigInteger(Integer.toString(c));
//        BigInteger res = T.mod(C);
//        System.out.println(res.toString());
        int res = 1;
        a = a % c;
        while (b > 0){
            if((b & 1) == 1)
                res = (res * a) % c;
            b = b >> 1;
            a = (a * a) % c;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int a = Integer.valueOf(split[0]);
            int b = Integer.valueOf(split[1]);
            int c = Integer.valueOf(split[2]);
            pow(a, b, c);
        }
    }

}
