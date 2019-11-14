package code.zjd.forPractice.problems.有9个因数的数;

import java.util.Scanner;

/**
 * @author zjd123
 * @date 2019/11/13 - 14:09
 */
public class Main {

   /* //计算每个数的因数个数
    static int numberOfDivisors(int num){
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if(num % i == 0)
                count += 1;
        }
        return count;
    }

    static int countNumber(int n){
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(numberOfDivisors(i) == 9)
                count += 1;
        }
       return count;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.valueOf(sc.nextLine());
            int number = countNumber(num);
            System.out.println(number);
        }
    }

    static int countNumber(int n){
        int c = 0;
        int limit = (int) Math.sqrt(n);

        // Sieve array
        int prime[] = new int[limit + 1];

        // initially prime[i] = i
        for (int i = 1; i <= limit; i++) {
            prime[i] = i;
        }

        // use seive concept to store the
        // first prime factor of every number
        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
                // mark all factors of i
                for (int j = i * i; j <= limit; j += i) {
                    if (prime[j] == j) {
                        prime[j] = i;
                    }
                }
            }
        }

        // check for all numbers if they can be
        // expressed in form p*q
        for (int i = 2; i <= limit; i++) {
            // p prime factor
            int p = prime[i];

            // q prime factor
            int q = prime[i / prime[i]];

            // if both prime factors are different
            // if p*q<=n and q!=
            if (p * q == i && q != 1 && p != q) {
                c += 1;
            } else if (prime[i] == i) {

                // Check if it can be expressed as p^8
                if (Math.pow(i, 8) <= n) {

                    c += 1;
                }
            }
        }
        return c;
    }

}
