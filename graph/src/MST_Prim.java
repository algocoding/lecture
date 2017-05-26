
import java.util.*;

public class MST_Prim {
	static int[][] G = new int[100][100];	
	static int[] D = new int[100];						
	static int[] P = new int[100];
	static boolean[] visited = new boolean[100];
	static int V, E, T;
	
	// 우선 순위 큐에 저장되는 정보
	private static class Vertex implements Comparable<Vertex>{
		int id;
		int key;
		Vertex(int a, int b)
		{
			id = a; key = b; 
		}
		public int compareTo(Vertex arg) {
			if(key == arg.key)
				return id - arg.id;
			else return key - arg.key;
		}
	}
	public static int mst_prim(int s)
	{
		for(int i = 1; i <= V; i++)
		{
			D[i] = 0xfffff;
			P[i] = i;
		}
		D[s] = 0;
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();	
		
		Q.add(new Vertex(s, D[s]));
		
		int ret = 0;		
		while(!Q.isEmpty())
		{
			Vertex v = Q.poll();
			if(visited[v.id]) continue;
			
			ret += v.key;
			visited[v.id] = true;
			
			for(int i = 1; i <= V; i++)
			{
				if(G[v.id][i] != 0 && visited[i] == false && G[v.id][i] < D[i])
				{
					D[i] = G[v.id][i];
					P[i] = v.id;
					Q.add(new Vertex(i, D[i]));
				}
			}
		}
		return ret;
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
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		int from, to, weight;
		for(int i = 0; i < E; i++)
		{
			from = sc.nextInt();
			to = sc.nextInt();
			weight = sc.nextInt();				
			G[from][to] = G[to][from] = weight;
		}
			
		mst_prim(1);
		printResult();
		sc.close();		
	}
}
