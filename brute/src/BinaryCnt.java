
public class BinaryCnt {
	static int[] arr = {10, 20, 30};
	static int N = arr.length;
		
	// ���̳�Ƽ ī�������� �κ� ���� �����ϱ�
	static void Subset(){		
		for(int i = 0; i < (1 << N) ; i++){
			
			for(int j = 0; j < N; j++){		// ��Ʈ ǥ�� ���
				if((i & (1 << j)) != 0) System.out.print(1);
				else System.out.print(0);							
			}
			System.out.print(" > ");
			for(int j = 0; j < N; j++){
				if((i & (1 << j)) != 0) 
					System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {		
		Subset();
	}
}
