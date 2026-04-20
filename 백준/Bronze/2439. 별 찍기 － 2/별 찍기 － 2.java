import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력. 정수 N
		int N = sc.nextInt();
		
		// n만큼 i의 값을 반복
		for(int i = 1; i <= N; i++) {
			// 1. 공백의 갯수 N-i번 출력
			for(int j = 0; j < N-i; j++) {
				System.out.print(" ");
			}
			// 2. 별의 갯수 i번 출력
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			// 3. 개행
			System.out.println();
		}
	}
}
