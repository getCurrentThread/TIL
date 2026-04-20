import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력 N
		int N = sc.nextInt();
		
		// N에 대한 구구단 출력 (1~9까지)
		// (반복) 임시변수 i를 1에서부터 9까지 반복하여 증가시켜준다
		for(int i = 1; i < 10; i++) {
			// i = 1, 2, 3, 4, 5, 6, 7, 8, 9
			// "N * i = N*i" 형식으로 출력
//			System.out.println(N + " * " + i + " = " + (N * i));
			System.out.printf("%d * %d = %d\n", N, i, N * i);
		}
	}
}
