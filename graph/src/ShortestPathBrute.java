﻿/* 입력>
------------------------
10 14
1 2 12 
1 3 15 
2 5 4 
2 6 10
3 4 21
3 7 7
4 8 25
5 6 3
5 9 13
6 7 10
7 8 19
7 10 9
8 10 5
9 10 15
------------------------
*/
package Day02;
import java.util.*;

public class ShortestPathBrute {
	static int[][] G = new int[100][100];				// 인접 행렬
	static int[] D = new int[100];						// 거리 저장
	static int[] P = new int[100];						// 최단 경로 트리	
	static int V, E;
		
	// D[]값이 변경되지 않을 때까지 반복
	public static void BruteForce(int s)
	{
		for(int i = 1; i <= V; i++)
			D[i] = 0xffffff;
		D[s] = 0; P[s] = s;
		
		boolean flag;
		do
		{
			flag = false;
			
			for(int v = 1; v <= V; v++)				
			for(int i = 1; i <= V; i++)
			{
				if(G[v][i] != 0 && D[i] > D[v] + G[v][i])
				{
					D[i] = D[v] + G[v][i];
					P[i] = v;
					flag = true;
				}	
			}
		}while(flag);
	}
	
	public static void main(String[] args) {		

		Scanner sc = new Scanner(System.in);		
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		int u, v, w;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();				
			G[u][v] = G[v][u] = w;
		}			
				
		System.out.println("최단 경로 - BruteForce>");		
		BruteForce(1); 
		printResult();		
		sc.close();
	}
	// D[], P[] 배열 출력 하기
	public static void printResult()
	{
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", i);
		
		System.out.println("\n------------------------------------------");
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", D[i]);
		System.out.println("\n------------------------------------------");		
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", P[i]);		
		System.out.printf("\n");
	}
	
}
