/*
 * A ~ G ������ ������ 1 ~ 7�� ǥ��
�Է�> 7(������), 11(������)
-----------------------------------------
7 11 
1 2 3
1 3 17
1 4 6
2 4 5
2 7 12
3 5 10
3 6 8 
4 5 9
5 6 4
5 7 2
6 7 14 
-----------------------------------------
*/
package Day02;

import java.util.*;

public class MSTPrimArray {

	static int[][] G;			// ���� ���
	static boolean[] visited;	// Ʈ���� ���Ե� ������ ǥ��
	static int[] D;				// ������ ����ġ ����
	static int[] P; 			// �ּ� ���� Ʈ�� ����(���� ���� ����)	
	static int V, E;			// ������, ������
	
	
	public static int mst_prim(int s)	//  s: ������
	{									// MST ����ġ�� ��ȯ 
		for(int i = 1; i <= V; i++)
		{
			D[i] = 0xfffff;
			P[i] = i;
		}
		D[s] = 0;	// ������ D[] �ʱ�ȭ
				
		int cnt = V, cost = 0;
		while(cnt-- > 0)
		{
			// Ʈ�� ������ �����߿��� D[]�� �ּ��� ���� ã��
			int v = 0, min = 0xfffffff;
			for(int i = 1; i <= V; i++)
			{
				if(visited[i] == false && min > D[i])
				{
					v = i; 
					min = D[i]; 
				}
			}
			visited[v] = true;		// ���� v�� Ʈ���� ���Ե�.			
			cost += D[v];				
			
			for(int i = 1; i <= V; i++)
			{
				if(G[v][i] != 0 && visited[i] == false && G[v][i] < D[i])
				{
					D[i] = G[v][i];
					P[i] = v;					
				}
			}
		}
		return cost;
	}	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		// �ʿ��� ���� ���� ���� 
		G = new int[V + 1][V + 1];
		visited = new boolean[V + 1];
		D = new int[V + 1];
		P = new int[V + 1];
		
		int u, v, w;		// ����(u,v), ����ġ w
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();				
			G[u][v] = G[v][u] = w;
		}
		
		System.out.println("MST ����ġ ��> " + mst_prim(1));
		printResult();
		sc.close();		
	}
	public static void printResult()
	{
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", i);
		System.out.printf("\n-------------------------------\n");
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", P[i]);
		System.out.println();
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", D[i]);		
		 
	}

}
