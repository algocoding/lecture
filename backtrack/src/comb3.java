//�ߺ� ����
public class comb3 {
	static int[] arr = {10, 20, 30, 40, 50};	
	static int N = arr.length;	
	static int R = 3;
	static int[] order = new int[N];
	static int[] picked = new int[R];
	static int cnt;
	// n������ r���� �����ϱ�, k: ���õ� ��Ҽ�, 
	public static void comb(int k, int start)
	{
		if(k == R){
			System.out.printf("%2d> ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(picked[i] + " ");
			System.out.print('\n');
			return;
		}
		for(int i = start; i < N; i++)
		{
			picked[k] = arr[i];
			comb(k + 1, i); // ������ ������ ��Һ��� �ٽ� �����ϵ��� �Ѵ�.
		
		}
	}
	public static void main(String[] args) {
		comb(0, 0);

	}

}