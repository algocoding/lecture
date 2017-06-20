/*
입력>
-----------------------------------------
8 10
1 2 
1 3 
2 4 
2 5 
3 6 
4 7 
5 6 
5 7 
6 8 
7 8
-----------------------------------------
*/
import java.util.*;

public class DFSDemo {
	static int[][] G = new int[100][100];
	static boolean[] visited = new boolean[100];
	static int V, E;
	public static void DFS(int v)
	{
		visited[v] = true;
		System.out.print(v + " ");
		for(int i = 1; i <= V; i++)
		{
			if(G[v][i] == 1 && visited[i] == false)
				DFS(i);
		}
	}
	public static void DFS_iterative(int v)
	{
		boolean[] visited = new boolean[100];
		Stack<Integer> S = new Stack<Integer>();
		
		visited[v] = true;
		System.out.print(v + " ");
		S.push(v);	
		
		while(!S.isEmpty())
		{
			int i;
			for(i = 1; i <= V; i++)
			{
				if(G[v][i] == 1 && visited[i] == false)
				{
					v = i;
					visited[i] = true;
					System.out.print(v + " ");
					S.push(v);
					break;
				}
			}
			if(i > V) v = S.pop();
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		V = sc.nextInt();
		E = sc.nextInt();
		
		int from, to;
		for(int i = 0; i < E; i++)
		{
			from = sc.nextInt();
			to = sc.nextInt();
			
			G[from][to] = 1;
			G[to][from] = 1;
		}
		//DFS(1);
		DFS_iterative(1);
		sc.close();		
	}
}
