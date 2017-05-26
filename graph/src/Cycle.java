import java.util.Scanner;

public class Cycle {
	static int G[][] = new int[100][100];
	static int indeg[] = new int[100];
	static int discovered[] = new int[100];
	static int finished[] = new int[100];
	static int V, E;
	static boolean isCycle;
	
	static void dfs(int v)
	{
		discovered[v] = 1;
		for (int i = 1; i <= V; i++)
		{
			if (G[v][i] == 1)
			{
				if (discovered[i] == 0)
					dfs(i);
				else if (finished[i] == 0)
					isCycle = true;
			}
		}
		finished[v] = 1;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			
			int from, to;
			for (int i = 0; i < E; i++)
			{
				from = sc.nextInt();
				to = sc.nextInt();

				G[from][to] = 1;
				indeg[to]++;
			}
			isCycle = false;
			for (int i = 1; i <= V; i++)
			{
				if (indeg[i] == 0)
					dfs(i);
			}

			if (isCycle) System.out.println("Cycle");
			else
				System.out.println("no Cycle");
			for (int i = 1; i <= V; i++)
			{
				discovered[i] = finished[i] = indeg[i] = 0;
				for (int j = 1; j <= V; j++)
					G[i][j] = 0;
			}
		}
		sc.close();
	}
}
