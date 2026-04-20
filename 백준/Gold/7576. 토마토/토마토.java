import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Pos {
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	// BFS 탐색을 위해 필요한 변수(상태)들을 선언
	static int N, M; // 상자의 가로, 세로 길이
	static int[][] box; // 상자의 각 격자의 값을 담을 이차원 배열 (상자)
	
	// 상하좌우 델타 배열
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력 
		M = sc.nextInt();
		N = sc.nextInt();
		
		box = new int[N][M];
		
		// 이차원 배열의 상자들의 값을 입력 처리
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		// 로직
		Queue<int[]> queue = new LinkedList<>(); // 큐(대기열)
//		Queue<Pos> queue = new LinkedList<>();
		// 1. 처음 익은 토마토(시작점)을 큐(대기열)에 넣어주기...!
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				// 익은 토마토(1) 찾아서 해당 좌표 (i,j) 큐에 넣기...!
				if(box[i][j] == 1) {
					queue.offer(new int[] {i, j});
//					queue.offer(new Pos(i, j));
				}
			}
		}
		
		// 2. BFS 탐색 시작
		while(!queue.isEmpty()) {
			// 대기열에서 익은 토마토 하나의 좌표값 꺼내기
			int[] current = queue.poll();
			
			// 상하좌우에 있는 
			for(int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				// 토마토가 범위 안에 있으면서, 익지 않은 토마토(0) 이라면 익게 만든다!
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || box[nr][nc] != 0) continue;

				// 익게 만드는 과정 (1 X! -> 익게 만들게 된 이전 토마토의 값 + 1 덮어씌우기)
				box[nr][nc] = box[current[0]][current[1]] + 1;
				queue.offer(new int[] {nr, nc}); // 대기열에 새로 익은 토마토를 넣
				
			}
		}
		
		// 3. 결과 확인 : 배열의 값을 최종 확인 (최댓값 확인 and 0이 있는가...?)
		// 최댓값 저장 임시변수
		int mx = 0;
		outer:
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) { // 아직 익지 않은 토마토가 있음...!
					mx = 0; // 출력하게될 값이므로...!
					break outer;
				}
				mx = Math.max(mx, box[i][j]);
			}
		}
		
		
		// 출력
		System.out.println(mx - 1);
	}
}
