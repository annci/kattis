import java.util.Arrays;
import java.util.Scanner;

public class DiceGame {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		String gIn = scanner.nextLine();
		String eIn = scanner.nextLine();
		
		int gSum = Arrays
				.stream(gIn.split(" "))
				.mapToInt(Integer::parseInt)
				.sum();
		
		int eSum = Arrays
				.stream(eIn.split(" "))
				.mapToInt(Integer::parseInt)
				.sum();
		
		if (gSum > eSum) {
			System.out.println("Gunnar");
		}
		else if (eSum > gSum) {
			System.out.println("Emma");
		}
		else {
			System.out.println("Tie");
		}
	}

}
