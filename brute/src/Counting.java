public class Counting {
	
	static int[] A = new int[]{5, 1, 3, 3, 3, 2, 1, 5, 1};
	static int[] B = new int[A.length];
	static int[] cnt = new int[6]; 
	static void CountingSort()
	{
		for(int i = 0; i < A.length; i++) // �󵵼� ���
			cnt[A[i]]++;
		
		for(int i = 1; i <= 5; i++)		// ���� �󵵼� ��� 
			cnt[i] += cnt[i - 1];
		
		for(int i = A.length - 1; i >= 0; i--)	// A[] -> B[]�� �ű��
		{
			cnt[A[i]]--;
			B[cnt[A[i]]] = A[i];
		}
		
		for(int val: B) System.out.print(val + " ");
	}
	public static void main(String[] args) {
		CountingSort();
	}	
}
