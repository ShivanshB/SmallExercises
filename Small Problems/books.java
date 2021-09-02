import java.util.*;

public class books {

	public static void main(String[] args) {
		int runs = 10000;
		double counter = 0.0;
		int n = 100;
		int[] books = new int[n];
		boolean flag;

		for (int i = 0; i < runs; i++) {

			setArray(books);

			mymethods.shuffle(books);
			flag = checkArray(books);
			if (flag) {
				counter = counter +1;
			}

		}	


		System.out.println(counter/runs);
		System.out.println(counter);

	}
	
	public static void setArray(int[] books) {
		for(int i = 0; i < books.length; i++) {
			books[i] = i;


		}
	}

	public static boolean checkArray(int[] books) {
		boolean test = true;
		for(int i = 0; i < books.length; i++) {
			if (books[i] == i) {
				test = false;
			}
		}
		return test;
	}

	public static void printArray(int[] array) {
		for(int i: array) {
			System.out.print(i + ", ");

		}
		System.out.println(" ");
	}	

}
