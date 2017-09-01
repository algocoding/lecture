package Day02;

//��ȣ ��Ÿ ����(disjoint-set)
public class DisjointSetDemo {
	static int[] p = null;
	static int[] r = null;
	
	public static void make_set(int N)
	{
		p = new int[N + 1];
		r = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
		{
			p[i] = i;
			r[i] = 0;
		}
	}
	public static int find_set(int x)
	{
		if( x != p[x]) p[x] = find_set(p[x]);
		
		return p[x]; 
	}
	public static void union(int x, int y)
	{
		int a = find_set(y); 
		int b = find_set(x);
		if(a == b) return;
		
		if(r[a] > r[b]) 
			p[b] = a;
		else {
			p[a] = b;
			if(r[a] == r[b]) r[b]++;
		}
	}
	public static void main(String[] args) {
		p = new int[11];
		make_set(10);
		print_set(10);
		
		union(1, 3); 
		union(2, 10); 
		union(7, 5); 
		union(3, 7); 
		union(2, 8);
		
		System.out.printf("\nunion ����>\n\n");
		
		print_set(10);
		
		System.out.println("3�� ���� ��ǥ�� -->" + find_set(3));
		System.out.println("8�� ���� ��ǥ�� -->" + find_set(8));
		
	}
	public static void print_set(int N)
	{
		System.out.printf("p[] �迭>\n���� ");
		for(int i = 1; i <= N; i++)
			System.out.printf("%2d ", i);
		System.out.printf("\n---------------------------------------\n�θ� ");
		for(int i = 1; i <= N; i++)
			System.out.printf("%2d ", p[i]);
		System.out.println();
	}
}
