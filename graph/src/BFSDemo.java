/*
�Է�> 7(������), 8(������)
-----------------------------------------
7 8
1 2 
1 3 
2 4 
2 5 
3 7 
4 6 
5 6 
6 7 
-----------------------------------------
*/
package Day02;
import java.util.*;
public class BFSDemo {

	static int[][] G;			// ���� ���
	static boolean[] visited;	// �湮 ����
	static int V, E;			// ������, ������
	static void BFS(int v)
	{
		visited = new boolean[V + 1];
		int[] Q = new int[V + 1];
		int front = -1, rear = -1;
		
		visited[v] = true; System.out.print(v + " ");
		Q[++rear] = v;
		
		while(front != rear)
		{
			v = Q[++front];
			for(int i = 1; i <= V; i++)
			{
				if(G[v][i] == 1 && visited[i] == false)
				{
					visited[i] = true;
					System.out.print(i + " ");
					Q[++rear] = i;
				}
			}
		}
	}	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		V = sc.nextInt();
		E = sc.nextInt();
		
		G = new int[V + 1][V + 1];		
		
		int u, v;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			
			G[u][v] = G[v][u] = 1;
		}
		BFS(1);
		sc.close();		
	}	
}
