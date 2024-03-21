package dsaProblems;

public class TrianglePattern {

	public static void main(String[] args) {
		int x = 3;
		for(int i = x; i > 0; i--) {
			for(int j = 2*i-1; j > 0; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
