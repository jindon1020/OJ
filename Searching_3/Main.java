package code.zjd.forPractice.problems.Searching_3;

import java.util.*;

/**
 * @author zjd123
 * @date 2019/11/13 - 20:46
 */
public class Main {

    static void getMark(Long[] marks, Long[] ranks){
        Map<Long, Long> map = new HashMap<>();
        Long index = 0l;
        for (int i = 0; i < marks.length; i+=2) {
            Long l = marks[i];
            Long r = marks[i+1];
            for (Long j = l; j <= r; j++) {
                map.put(index++, j);
            }
        }
        for (int i = 0; i < ranks.length; i++) {
            Long rank = ranks[i];
            if(i == ranks.length - 1){
                System.out.println(map.get(rank-1));
                return;
            }
            System.out.print(map.get(rank-1) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            String s1 = sc.nextLine();
            String[] split1 = s1.split(" ");
            int groups = Integer.valueOf(split1[0]);
            int queries = Integer.valueOf(split1[1]);
            Long[] marks = new Long[groups*2];
            Long[] ranks = new Long[queries];
            String s2 = sc.nextLine();
            String[] split2 = s2.split(" ");
            for (int j = 0; j < marks.length; j++) {
                marks[j] = Long.valueOf(split2[j]);
            }
            String s3 = sc.nextLine();
            String[] split3 = s3.split(" ");
            for (int j = 0; j < ranks.length; j++) {
                ranks[j] = Long.valueOf(split3[j]);
            }
            getMark(marks, ranks);
        }
    }
}
