import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Convex Hull:");
		
		System.out.println();
		
		
		int ch,n;
		Scanner scan = new Scanner(System.in);
//		System.out.println("Which Algorithm would you like to run?");
		//System.out.println("1. Grahams Algorithm :");
//		System.out.println("1. Jarvis Algorithm :");
//		System.out.println("2. Quick Hull Algorithm :");
		//ch = scan.nextInt();
		
		System.out.println();
		
		System.out.println("How many points would you like to generate?");
		
		n = scan.nextInt();
		
		PointCoordinate[] ranPoints = new PointCoordinate[n];
		int min=0,max=30000;
		
		for(int k=0;k<n;k++) {
			int x = (int)Math.floor(Math.random()*(max-min+1)+min);
			int y = (int)Math.floor(Math.random()*(max-min+1)+min);
			ranPoints[k] = new PointCoordinate(x,y);
		}
		
		
		//switch(ch) {

		//case 1:
			PointJ jp[] = new PointJ[n];
			for(int k=0;k<n;k++) {
				jp[k] = new PointJ();
				jp[k].x = ranPoints[k].x;
				jp[k].y = ranPoints[k].y;
			}
			long startTimeJarvis = System.currentTimeMillis( );
			
			System.out.println("Jarvis March Algorithm : ");
			Jarvis.convexHull(jp);
			long endTimeJarvis = System.currentTimeMillis( );
			int totalTimeJarvis = (int) (endTimeJarvis - startTimeJarvis);
			
			System.out.println("Running Time for Jarvis March Algorithm:"+ (double)totalTimeJarvis/1000 );
			System.out.println("----------------------");
			
//			break;
//		case 2:
			System.out.println("Quick Hull Algorithm : ");
			long startTimeQuickHull = System.currentTimeMillis( );
			List<List<Integer> > a = new ArrayList<List<Integer> >();
			for(int k=0;k<n;k++) {
				a.add(Arrays.asList(ranPoints[k].x, ranPoints[k].y));
			}
			QuickHull.printHull(a, n);
			long endTimeQuickHull = System.currentTimeMillis( );
			int totalTimeQuickHull = (int) (endTimeQuickHull - startTimeQuickHull);

			System.out.println("Running Time for Quick Hull Algorithm:"+ (double)totalTimeQuickHull/1000 );
			System.out.println("----------------------");
//			break;
//		}
	}	
		
}
