package Day02;

import java.util.*;

// Dijkstra + �迭 ���
public class Day2_2 {
	static int N;								// �� ũ��
	static int[][] G = new int[100][100];		// �� ����
	static int[][] D = new int[100][100];		// �Ÿ�
	static boolean[][] visited = new boolean[100][100];	 // �湮 ����
	static int[] dx = new int[]{0, 0, 1, -1};
	static int[] dy = new int[]{1, -1, 0, 0};
	
	//	���� ��ȭ
	static void edgeRelaxation(int x, int y)
	{
		for(int i = 0; i < 4; i++)
		{
			int tx = x + dx[i]; 
			int ty = y + dy[i];
			if(tx < 0 || tx == N || ty < 0 || ty == N) continue;
			if(visited[tx][ty] == false && D[tx][ty] > D[x][y] + G[tx][ty])
				D[tx][ty] = D[x][y] + G[tx][ty];
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		// �Է¼�
		
		while(T-- > 0)
		{
			N = sc.nextInt();		// �� ũ��
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					G[i][j] = str.charAt(j) - '0';
					D[i][j] = 0xffffff;
					visited[i][j] = false;
				}
			}
			D[0][0] = 0; 
			visited[0][0] = true;
			edgeRelaxation(0, 0);	// �������� ���� ���� ��ȭ
			
			// ������ �� ��ŭ ���� ��ȭ
			int cnt = N * N - 1;
			while(cnt-- > 0)
			{
				// visited[][] == false && D[][] �� �ּ��� ��ǥ ã��
				int x = 0, y = 0, min = 0xffffff;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(visited[i][j] == false && D[i][j] < min){
							min = D[i][j]; x = i; y = j;
						}
					}
				}
				
				visited[x][y] = true; 	// (x,y)�� ���� �ִ� ��ΰ� Ȯ���ȴ�. 
				//if(x == N - 1 && y == N - 1) break;
				
				edgeRelaxation(x, y);
			}
			
			System.out.println(D[N-1][N-1]);
		}
		
		sc.close();
	}
}
