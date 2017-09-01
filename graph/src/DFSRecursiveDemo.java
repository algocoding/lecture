﻿/*
입력> 7(정점수), 8(간선수)
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

public class DFSRecursiveDemo {
	static int[][] G;			// 인접 행렬
	static boolean[] visited;	// 방문 정보
	static int V, E;			// 정점수, 간선수
	public static void DFS(int v)
	{
		visited[v] = true; 
		System.out.print(v + " ");
		
		for(int i = 1; i <= V; i++)		
		{								// 비방문 인접 정점 찾기
			if(G[v][i] == 1 && visited[i] == false)
				DFS(i);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		V = sc.nextInt();
		E = sc.nextInt();
		
		G = new int[V + 1][V + 1];
		visited = new boolean[V + 1];
		
		int u, v;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			
			G[u][v] = G[v][u] = 1;
		}
		DFS(1);
		sc.close();		
	}
}
