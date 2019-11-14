package code.zjd.forPractice.problems.对称字符串;

import java.util.Scanner;

/**
 * @author zjd123
 * @date 2019/11/11 - 19:35
 */
// A simple Java based program to find
// length of longest even length substring
// with same sum of digits in left and right

public class Main {

    static int findLength(String str) {
        int n = str.length();
        int maxlen = 0; // Initialize result

        // Choose starting point of every
        // substring
        for (int i = 0; i < n; i++) {
            // Choose ending point of even
            // length substring
            for (int j = i + 1; j < n; j += 2) {
                // Find length of current substr
                int length = j - i + 1;

                // Calculate left & right sums
                // for current substr
                int leftsum = 0, rightsum = 0;
                for (int k = 0; k < length/2; k++) {
                    leftsum += (str.charAt(i + k) - '0');
                    rightsum += (str.charAt(i + k + length/2) - '0');
                }

                // Update result if needed
                if (leftsum == rightsum && maxlen < length)
                    maxlen = length;
            }
        }
        return maxlen;
    }

    static int findMaxLen(String str){
        int len = str.length();
        if(len <= 1)
            return 0;
        if(len == 2 && str.charAt(0) == str.charAt(1))
            return 1;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j+=2) {
                int curLen = j - i +1;
                int left = 0;
                int right = 0;
                for (int k = 0; k < curLen/2; k++) {
                    left += str.charAt(i+k) - '0';
                    right += str.charAt(i+k+curLen/2) - '0';
                }
                if(left == right && curLen > maxLen)
                    maxLen = curLen;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            int maxLen = findMaxLen(str);
            System.out.println(maxLen);
        }
    }
}
