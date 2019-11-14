package code.zjd.forPractice.problems.整数查询;

import java.util.Scanner;

/**
 * @author zjd123
 * @date 2019/11/13 - 10:47
 */
public class Main {

    static void getPerfectCount(int[] data, int[] query){

        for (int i = 0; i < query.length; i++) {
            int count = 0;
            int curQuery = query[i];
            for (int j = 0; j < data.length; j++) {
                if(data[j] % curQuery == 0)
                    count++;
            }
            if(i == query.length-1){
                System.out.println(count);
                return;
            }
            System.out.print(count + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            String s1 = sc.nextLine();
            String[] split0 = s1.split(" ");
            int dataLen = Integer.valueOf(split0[0]);
            int queryLen = Integer.valueOf(split0[1]);
            String s2 = sc.nextLine();
            String[] split = s2.split(" ");
            int[] data = new int[dataLen];
            for (int j = 0; j < dataLen; j++) {
                data[j] = Integer.valueOf(split[j]);
            }
            String s3 = sc.nextLine();
            String[] split1 = s3.split(" ");
            int[] query = new int[queryLen];
            for (int j = 0; j < queryLen; j++) {
                query[j] = Integer.valueOf(split1[j]);
            }
            getPerfectCount(data, query);
        }
    }

}
