import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StableSort {
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		while(true) {
			int n = scanner.nextInt();
			
			if (n == 0) {
				break;
			}
			
			String[] names = new String[n];
			for (int i = 0; i < n; i++) {
				names[i] = scanner.next();
			}
			
			Arrays.sort(names, Comparator.comparing(o -> o.substring(0, 2)));
			for (String name : names) {
				System.out.println(name);
			}
			System.out.println( );
		}
	}

}
