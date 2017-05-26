
public class PermutationDemo {
	static char[] str;
	static char[] order;	
	static int cnt = 0;
	
	public static void swap(int i, int j)
	{
		char t = str[i]; str[i] = str[j]; 
		str[j] = t;		
	}
	public static void perm_iter(int n, int r)
	{
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(i == j) continue;
				for(int k = 0; k < n; k++)
				{
					if(i == k || j == k) continue;
					System.out.printf("%3d> %c%c%c\n", ++cnt, str[i], str[j], str[k]);
				}
			}	
		}
	}
	// 교환을 통한 생성, n개에서 r개를 뽑아서 나열하기
	public static void perm_swap(int k, int n, int r)
	{
		if(k == r)
		{
			System.out.printf("%3d> ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(str[i]);
			System.out.print('\n');
			return;
		}
		for(int i = k; i < n; i++)
		{
			swap(k, i);
			perm_swap(k + 1, n, r);
			swap(k, i);
		}
	}
	
	// bit 정보를 이용해서 생성하기
	public static void perm(int k, int n, int r, int visit)
	{
		if(k == r)
		{
			System.out.printf("%3d> ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(order[i]);
			System.out.print('\n');
			return;
		}
		for(int i = 0; i < n; i++)
		{
			if( (visit & (1 << i)) != 0) continue;
			order[k] = str[i];
			perm(k + 1, n, r, visit | (1 << i));
			
		}
	}
	// 중복 순열
	public static void perm_re(int k, int n, int r)
	{
		if(k == r)
		{
			System.out.printf("%3d> ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(order[i]);
			System.out.print('\n');
			return;
		}
		for(int i = 0; i < n; i++)
		{
			order[k] = str[i];
			perm_re(k + 1, n, r);
		
		}
	}
	public static void main(String[] args) {
		String tmp = new String("ABCDE");
		str = tmp.toCharArray();
		order = new char[tmp.length()];
		
		
		perm_swap(0, tmp.length(), 3);		
	}

}
