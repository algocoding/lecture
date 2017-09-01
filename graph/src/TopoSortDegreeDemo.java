/*
�Է�> 6(������), 8(������)
���� ��ȣ�� 0 ~ 5 ����
-----------------------------------------
6 8
0 1
0 2
1 3
1 4
2 3
2 4
3 5
4 5
-----------------------------------------
*/
package Day02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopoSortDegreeDemo {
	static int[][] G;			// ���� ���
	static boolean[] visited;	// �湮 ����
	static int[] indeg;			// ���� ����
	static int V, E;			// ������, ������
	
	public static void solve_degree()
	{
		Queue<Integer> Q = new LinkedList<Integer>();
		
		for(int i = 0; i < V; i++)		
			if(indeg[i] == 0) Q.add(i); // ���� ���� 0�� ���� ť�� ����
		
		while(!Q.isEmpty())
		{
			int v = Q.poll();
			
			System.out.print(v + " ");
			
			for(int i = 0; i < V; i++)	// ���� ������ ���� ���� ����
			{
				if(G[v][i] == 1 && indeg[i] != 0)
				{
					indeg[i]--;
					if(indeg[i] == 0) Q.add(i);	// ���� ������ 0�� �Ǹ� ť�� ����
				}
			}
		}
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
				
		V = sc.nextInt();
		E = sc.nextInt();
		G = new int[V][V];	// ���� ��ȣ 0 ~ (V-1)
		visited = new boolean[V];
		indeg = new int[V];
		
		
		int u, v;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
							
			G[u][v] = 1;
			indeg[v]++;
		}
		solve_degree();
		sc.close();
		
	}
}
