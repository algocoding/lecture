// 세그먼트 트리 

public class SegmentTree {

	static int N = 8;	// N: 자료수
	static int[] arr = new int[]{ 3, 9, 4, 2, 7, 8, 10, 1 };
	static int[] st;
	static int[] lt;
	
	public static int buildTree(int id, int l, int r)
	{
		if(l == r)
		{
			return st[id] = arr[l];
		}
		int m = (l + r) / 2;
		
		return st[id] = buildTree(id * 2, l, m) + buildTree(id * 2 + 1, m + 1, r);
	}
	public static void lazy_propagation(int id, int l, int r)
	{
		if(lt[id] != 0)
		{
			st[id] += (r - l + 1) *lt[id];
			if(l != r)
			{
				lt[id*2] += lt[id];
				lt[id*2 + 1] += lt[id];
			}
			lt[id] = 0;
		}
	}
	public static int query(int id, int l, int r, int i, int j)
	{
		lazy_propagation(id, l, r);
		
		if(r < i || j < l) return 0;
		
		if(i <= l && r <= j)  return st[id];
		
		int m = (l + r) / 2;
		return query(id * 2, l, m, i, j) + query(id * 2 + 1, m + 1, r, i, j);
	}
	public static void update(int id, int l, int r, int p, int v)
	{
		if(r < p || p < l) return;
		
		st[id] += v;
		if(l != r)
		{
				int m = (l + r) / 2;		
				update(id * 2, l, m, p, v);
				update(id * 2 + 1, m + 1, r, p, v);
		}
	}
	public static void updateRange(int id, int l, int r, int i, int j, int v)
	{
		lazy_propagation(id, l, r);
		
		if(r < i || j < l) return;
		
		if(i <= l && r <= j){
			st[id] += (r - l + 1) * v;
			if(l != r)
			{
				lt[id*2] += v;
				lt[id*2 + 1] += v;
			}
			return;
		}		
		int m = (l + r) / 2;		
		updateRange(id * 2, l, m, i, j, v);
		updateRange(id * 2 + 1, m + 1, r, i, j, v);
		
		st[id] = st[id*2] + st[id*2+1];
	}
	public static void main(String[] args) 
	{
		int h = 0;	// 높이
		for (int n = N - 1; n != 0; h++)
			n >>= 1;
		
		st = new int[1 << (h + 1)];
		lt = new int[1 << (h + 1)];
		
		buildTree(1, 0, N - 1);
		
		System.out.printf("구간 갱신 (%d, %d) + %d\n", 0, 5, 1);		
		updateRange(1, 0, N - 1, 0, 5, 1);
		
		System.out.printf("구간합(%d, %d) = %d\n", 1, 3, query(1, 0, N - 1, 1, 3));
		
		System.out.printf("구간 갱신 (%d, %d) + %d\n", 3, 7, -2); 
		updateRange(1, 0, N - 1, 3, 7, -2);

		//-----------------------------------------------------------------------------------
		// st[], lt[] 출력
		System.out.printf("번호|");
		for (int i = 1; i < (1 << (h + 1)); i++)
			System.out.printf("%3d|", i);
		System.out.printf("\n-------------------------------------------------------------\n");
		System.out.printf("st |");
		for (int i = 1; i < (1 << (h + 1)); i++)
			System.out.printf("%3d|", st[i]);		
		System.out.printf("\n-------------------------------------------------------------\n");
		System.out.printf("lt |");
		for (int i = 1; i < (1 << (h + 1)); i++)
			System.out.printf("%3d|", lt[i]);
		//-----------------------------------------------------------------------------------					
	}
	public static void print_arr(){
		
	}
}
