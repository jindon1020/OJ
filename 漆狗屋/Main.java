package code.zjd.forPractice.problems.漆狗屋;

import java.util.Scanner;

/**
 * @author zjd123
 * @date 2019/11/13 - 10:21
 */
public class Main {

    static int getMax(int A[], int n){
        int max = -1;
        for (int i = 0; i < n; i++) {
            if(A[i] > max)
                max = A[i];
        }
        return max;
    }

    static int getSum(int A[], int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        return sum;
    }

    static int getRequiredNum(int A[], int n, int MaxPer){
        int num_bucket = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if(sum > MaxPer){
                sum = A[i];
                num_bucket++;
            }
        }
        return num_bucket;
    }

    static int binarySearch(int A[], int n, int k){
        int low = getMax(A, n);
        int high =getSum(A, n);
        while (low < high){
            int mid = (low + high)/2;
            int result = getRequiredNum(A, n, mid);
            if(result > k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine().trim());
        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int k = Integer.valueOf(s1[0]);
            int n = Integer.valueOf(s1[1]);
            String s2 = sc.nextLine();
            String[] s3 = s2.split(" ");
            int[] arr = new int[s3.length];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.valueOf(s3[j]);
            }
            int minCost = binarySearch(arr, n, k);
            System.out.println(minCost);
        }
    }


}
