import java.util.Scanner;
import java.util.Arrays;
 

class PointJ
{
    int x, y;
}
 

public class Jarvis
{    
    private static  boolean CCW(PointJ p, PointJ q, PointJ r)
    {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
 
         if (val >= 0)
             return false;
         return true;
    }
    public static void convexHull(PointJ[] points)
    {
        int n = points.length;
               
        if (n < 3) 
            return;     
        int[] next = new int[n];
        Arrays.fill(next, -1);
 
        
        int leftMost = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[leftMost].x)
                leftMost = i;
        int p = leftMost, q;
        
        do
        {
            
            q = (p + 1) % n;
            for (int i = 0; i < n; i++)
              if (CCW(points[p], points[i], points[q]))
                 q = i;
 
            next[p] = q;  
            p = q; 
        } while (p != leftMost);
 
        
        display(points, next);
    }
    public static void display(PointJ[] points, int[] next)
    {
        System.out.println("\nConvex Hull points : ");
        for (int i = 0; i < next.length; i++)
            if (next[i] != -1)
               System.out.println("("+ points[i].x +", "+ points[i].y +")");
    }
    
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Jarvis Algorithm Test\n");
        
        Jarvis j = new Jarvis();        
 
        System.out.println("Enter number of points n :");
        int n = scan.nextInt();
        PointJ[] points = new PointJ[n];
        System.out.println("Enter "+ n +" x, y cordinates");
        for (int i = 0; i < n; i++)
        {
            points[i] = new PointJ();
            points[i].x = scan.nextInt();
            points[i].y = scan.nextInt();
        }        
        j.convexHull(points);        
    }
}