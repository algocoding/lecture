package Day02;

import java.util.*;

public class Day2_2BFS {
	static int N;								// �� ũ��
	static int[][] G = new int[100][100];		// �� ����
	static int[][] D = new int[100][100];		// �Ÿ�	
	static int[] dx = new int[]{0, 0, 1, -1};
	static int[] dy = new int[]{1, -1, 0, 0};
	
	// �켱 ���� ť�� ����Ǵ� ����
	private static class Vertex {
		int x, y; 		// (x, y)��ǥ
		Vertex(int _x, int _y){
			x = _x; y = _y; 
		}				
	}
	static Queue<Vertex> Q = new LinkedList<Vertex>();
	static void edgeRelaxation(int x, int y)	// ���� ��ȭ
	{
		for(int i = 0; i < 4; i++)
		{
			int tx = x + dx[i]; 
			int ty = y + dy[i];
			if(tx < 0 || tx == N || ty < 0 || ty == N) continue;
			if(D[tx][ty] > D[x][y] + G[tx][ty])
			{
				D[tx][ty] = D[x][y] + G[tx][ty];
				Q.add(new Vertex(tx, ty));
			}
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
				}
			}
			D[0][0] = 0;			
			Q.add(new Vertex(0, 0));			
			
			while(!Q.isEmpty())
			{
				Vertex cur = Q.poll();
				
				//if(cur.x == N - 1 && cur.y == N - 1) break;
				
				edgeRelaxation(cur.x, cur.y);
			}			
			System.out.println(D[N-1][N-1]);
		}
		System.out.println("�ִ� ��� - BFS>");
		sc.close();
	}
}
