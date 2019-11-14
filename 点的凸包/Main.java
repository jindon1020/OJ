package code.zjd.forPractice.problems.点的凸包;

import java.util.*;

/**
 * @author zjd123
 * @date 2019/11/13 - 15:04
 * 如何判断两条线AB,CD是否相交？
 *
 * 1.三种状态 A->B->C构成顺时针 A->B->C构成逆时针 A,B.C共线
 * 2.相交需要满足  A->B->C 与 A->B->D 状态不同
 */
public class Main {

    //判断q是否在pr上
    static boolean onSegment(Point p, Point q, Point r){
        if(q.x <= Math.max(p.x, r.x) &&
           q.x >= Math.min(p.x, r.x) &&
           q.y >= Math.min(p.y, r.y) &&
           q.y <= Math.max(p.y, r.y))
            return true;
        return false;
    }
    //0 共线 1 顺时针相交 2 逆时针相交
    static int orientation(Point p, Point q, Point r){
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if(val == 0) return 0;
        return val > 0 ? 1: 2;
    }

    static void convexHull(Point[] points, int n){
        if(n < 3) return;
        Vector<Point> hull = new Vector<Point>();

        //find the leftmost point
        int l = 0;
        for (int i = 1; i < n; i++) {
            if(points[i].x < points[l].x)
                l = i;
        }

        // Start from leftmost point, keep moving
        // counterclockwise until reach the start point
        // again. This loop runs O(h) times where h is
        // number of points in result or output.
        int p = l, q;
        do{
            //add current point to result
            hull.add(points[p]);
            //根据 p->x->q 是逆时针选择x
            //循环选择输入的点
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                if(orientation(points[p], points[i], points[q]) == 2)
                    q = i;
            }
            p = q;
        }while (p != l);

        int[] keys = new int[hull.size()];
        for (int i = 0; i < hull.size(); i++) {
            Point point = hull.get(i);
            keys[i] = point.x;
        }
        Arrays.sort(keys);
        for (int i = 0; i < keys.length; i++) {
            int x = keys[i];
            for (int j = 0; j < hull.size(); j++) {
                Point point = hull.get(j);
                if(x == point.x){
                    if(i == keys.length-1){
                        System.out.print(point.x + " " + point.y);
                        break;
                    }
                    System.out.print(point.x + " " + point.y + ", ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            int size = Integer.valueOf(sc.nextLine());
            Point[] points = new Point[size];
            int index = 0;
            String s = sc.nextLine();
            String[] split = s.split(" ");
            for (int j = 0; j < split.length; j+=2) {
                Point p = new Point(Integer.valueOf(split[j]),Integer.valueOf(split[j+1]));
                points[index++] = p;
            }
            convexHull(points,size);
        }
    }

}



class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}