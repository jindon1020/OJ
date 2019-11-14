package code.zjd.forPractice.problems.无限递归字符查询;

/**
 * @author zjd123
 * @date 2019/11/11 - 20:30
 */

import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        String[] unit = {"1","2","3","4","5","$","5","4","3","2","1"};

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            BigInteger query = sc.nextBigInteger();
            int len = unit.length;
            while (query.compareTo(new BigInteger(Integer.toString(len)))>0) {
                int[] domainInfo = domainInfo(query);
                int domainStart = ((domainInfo[0] - domainInfo[1]) / 2 ) +  domainInfo[1];

                if (query.compareTo(new BigInteger(Integer.toString(domainStart)))<=0) {
                    query = new BigInteger("6"); //$
                    break;
                }

                query = query.subtract(new BigInteger(Integer.toString(domainStart)));
            }
            int position = Integer.valueOf(query.toString());
            System.out.println(position > 0 ? unit[position - 1] : "");
            t--;
        }
    }

    public static int[] domainInfo(BigInteger query) {
        int domainSize = 5;
        int ith = 0;

        while(true) {
            if (query.compareTo(new BigInteger(Integer.toString(domainSize)))>=0) {
                return new int[]{domainSize, ith};
            }
            ith++;
            domainSize = (domainSize * 2) + ith;
        }
    }
}