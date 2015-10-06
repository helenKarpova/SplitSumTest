import java.util.Scanner;

public class StartNewTest {

	public static void main(String[] args) {

		int inputVal;
		int cntComponents;
		try (Scanner inp = new Scanner(System.in)) {
			System.out.print("¬ведите натуральное число: ");
			inputVal = inp.nextInt();

			System.out.print("¬ведите кол-во разбиений: ");
			cntComponents = inp.nextInt();
		}

		// TODO Auto-generated method stub

		SplitIntoComponents SplitComponents = null;

		try {
			SplitComponents = new SplitIntoComponents(inputVal, cntComponents);
		} catch (IllegalArgumentException ex) {
			System.out.print(ex.getMessage());
			return;
		}

		do {
			int[] result = SplitComponents.nextComponents();

			for (int i : result) {
				System.out.print(i + " ");
			}

			System.out.println();
		} while (SplitComponents.hasNext());
	}

}
