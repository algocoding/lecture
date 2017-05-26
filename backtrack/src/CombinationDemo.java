
public class CombinationDemo {
	static char[] str;		// n개의 요소 저장
	static char[] picked;	// 선택된 r개의 요소들 저장
	static int cnt = 0;
	
	// n개에서 r개를 선택하기, k: 선택된 요소수, 
	public static void comb(int k, int n, int r, int start)
	{
		if(k == r)
		{
			System.out.printf("%3d> ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(picked[i]);
			System.out.print('\n');
			return;
		}
		for(int i = start; i < n; i++)
		{
			picked[k] = str[i];
			comb(k + 1, n, r, i + 1);
		
		}
	}
	// 조합의 재귀적 정의를 이용한 생성
	public static void comb_recur(int n, int r)
	{
		if(r == 0)
		{
			System.out.printf("%3d> ", ++cnt);
			for(int i = 0; i < 3; i++)
				System.out.print(picked[i]);
			System.out.print('\n');
			return;
		}
		if( n < r) return;
		picked[r - 1] = str[n - 1];
		comb_recur(n - 1, r - 1);
		comb_recur(n - 1, r);
	}
	// 중복 조합 생성
	public static void comb_re(int k, int n, int r, int start)
	{
		if(k == r)
		{
			System.out.printf("%3d> ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(picked[i]);
			System.out.print('\n');
			return;
		}
		for(int i = start; i < n; i++)
		{
			picked[k] = str[i];
			comb_re(k + 1, n, r, i);
		
		}
	}
	
	public static void main(String[] args) {
		String tmp = new String("ABCDE");
		str = tmp.toCharArray();
		picked = new char[tmp.length()];
		comb(0, 5, 3, 0);
		//comb_recur(5, 3);
		//comb_re(0, 5, 3, 0);
	}

}
