import java.util.*;


public class ShortestPathBFSArrayList {
	static ArrayList<Node>[] G;
	static int[] D;
	static int[] P;
	
	static int V, E;
	private static class Node{
		int v, w;
		Node(int a, int b){ v= a; w = b;}
	}
	
	// D[], P[] 배열 출력 하기
	public static void printResult()
	{
		for(int i = 1; i <= V; i++)
		{
			System.out.printf("%d ", D[i]);
		}
		System.out.printf("\n");
		for(int i = 1; i <= V; i++)
		{
			System.out.printf("%d ", P[i]);
		}
		System.out.printf("\n");
	}
	
	// BFS + 인접 리스트
	public static void BFS(int v)
	{
		for(int i = 1; i <= V; i++)
			D[i] = 0xffffff;
		D[v] = 0; P[v] = v;
		
		Queue<Integer> Q = new LinkedList<Integer>();		
		Q.add(v);		
		while(!Q.isEmpty())
		{
			v = Q.remove();
			
			for(Node node: G[v])
			{
				if(D[node.v] > D[v] + node.w)
				{
					D[node.v] = D[v] + node.w;
					P[node.v] = v;
					Q.add(node.v);					
				}	
			}
		}
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		G = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++)
			G[i] = new ArrayList<Node>();
		
		D = new int[V + 1];
		P = new int[V + 1];
		
		int u, v, w;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();				
			w = sc.nextInt();
			
			G[u].add(new Node(v, w));
			G[v].add(new Node(u, w));
		}			
		sc.close();
		
		System.out.println("최단 경로 / BFS - 인접리스트");
		System.out.println("----------------");
		BFS(1); printResult();
		System.out.println("----------------");
		
	}
}
