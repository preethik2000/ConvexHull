import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class QuickHull {
	static HashSet<List<Integer> > hull
		= new HashSet<List<Integer> >();
	
	public static int findSide(List<Integer> p1, List<Integer> p2,
							List<Integer> p)
	{
		int val = (p.get(1) - p1.get(1)) * (p2.get(0) - p1.get(0))
				- (p2.get(1) - p1.get(1)) * (p.get(0) - p1.get(0));

		if (val > 0) {
			return 1;
		}
		if (val < 0) {
			return -1;
		}
		return 0;
	}

	
	public static int lineDist(List<Integer> p1, List<Integer> p2,
							List<Integer> p)
	{
		return Math.abs((p.get(1) - p1.get(1)) * (p2.get(0) - p1.get(0))
						- (p2.get(1) - p1.get(1)) * (p.get(0) - p1.get(0)));
	}

	
	public static void quickHull(List<List<Integer> > a, int n,
								List<Integer> p1, List<Integer> p2,
								int side)
	{
		int ind = -1;
		int max_dist = 0;

		
		for (int i = 0; i < n; i++) {
			int temp = lineDist(p1, p2, a.get(i));
			if (findSide(p1, p2, a.get(i)) == side
				&& temp > max_dist) {
				ind = i;
				max_dist = temp;
			}
		}

		
		if (ind == -1) {
			hull.add(p1);
			hull.add(p2);
			return;
		}

		
		quickHull(a, n, a.get(ind), p1,
				-findSide(a.get(ind), p1, p2));
		quickHull(a, n, a.get(ind), p2,
				-findSide(a.get(ind), p2, p1));
	}

	public static void printHull(List<List<Integer> > a, int n)
	{
		
		if (n < 3) {
			System.out.println("Convex hull not possible\n");
			return;
		}

		
		int min_x = 0;
		int max_x = 0;
		for (int i = 1; i < n; i++) {
			if (a.get(i).get(0) < a.get(min_x).get(0)) {
				min_x = i;
			}
			if (a.get(i).get(0) > a.get(max_x).get(0)) {
				max_x = i;
			}
		}

		
		quickHull(a, n, a.get(min_x), a.get(max_x), 1);
		quickHull(a, n, a.get(min_x), a.get(max_x), -1);

		System.out.println("The points in Convex Hull are:\n");
		for(List<Integer> item : hull)
		{
			System.out.println("(" + item.get(0) + ", " + item.get(1) + ")");
		}
	}
	
	
	public static void main(String[] args)
	{
		
		List<List<Integer> > a = new ArrayList<List<Integer> >();
		{
			a.add(Arrays.asList(0,0));
			a.add(Arrays.asList(0,1));
			a.add(Arrays.asList(47,38));
			a.add(Arrays.asList(28,4));
			a.add(Arrays.asList(2,48));
			a.add(Arrays.asList(2,55));
			a.add(Arrays.asList(9,7));
			a.add(Arrays.asList(5,4));
			a.add(Arrays.asList(1,1));
			a.add(Arrays.asList(46,98));
		};

		int n = a.size();
		printHull(a, n);
	}
}
