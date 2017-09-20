// ���� ���� (��ȯ + ���������)
public class Perm5 {
	static int[] arr = {10, 20, 30, 40};	
	static int N = arr.length;	
	static int R = 3;
	static int[] order = new int[R]; // ��ҵ� ����
	static int cnt;
	public static void swap(int i, int j)
	{
		int t = arr[i]; arr[i] = arr[j]; 
		arr[j] = t;		
	}
	// ��ȯ�� ���� ����
	public static void perm(int n, int r)
	{
		if(r == 0)
		{
			System.out.printf("%2d> ", ++cnt);
			for(int i = 0; i < R; i++)
				System.out.print(order[i] + " ");
			System.out.println();
			return;
		}
		for(int i = n - 1; i >= 0; i--)
		{
			swap(n - 1, i);
			order[r - 1] = arr[n - 1];
			perm(n - 1, r - 1);
			swap(n - 1, i);
		}
	}
	public static void main(String[] args) {	
		perm(N, R);
	}
}
