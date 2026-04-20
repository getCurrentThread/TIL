import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력. 정수 N
		int N = sc.nextInt();
		
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < i; j++) { // i번 반복...
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
