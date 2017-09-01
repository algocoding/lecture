/*

struct IndexedTree {
   vector<int> tree;
   int size;
   IndexedTree(int n, int *arr) :
          tree(4 * n, 987654321) {   //�˳��ϰ� 4*n ������ �迭 ����, �ʱⰪ ����
       size = 1;
       while (size < n) //2�� ����� ���� ���̷��� ��� ���� ����
          size *= 2;
       for (int i = 0; i < n; i++)
          tree[size + i] = arr[i];   //�� ����
       init(1);  //���� �� ���.
   }
   /* �Ķ��̺� �Լ� */
   int init(int pos) {
       if (pos >= size) //�ܸ� ����� ���
          return tree[pos];
       return tree[pos] = min(init(pos * 2), init(pos * 2 + 1));
   }
   int query(int left, int right, int node, int nodeLeft, int nodeRight) {
       left = max(left, nodeLeft);
       right = min(right, nodeRight);
       if (left > right)
          return 987654321;   //�ʱⰪ
       if (left == nodeLeft && right == nodeRight)
          return tree[node];
       int mid = (nodeLeft + nodeRight) / 2;
       return min(query(left, right, node * 2, nodeLeft, mid),
              query(left, right, node * 2 + 1, mid + 1, nodeRight));
   }
 
   void update(int pos) {
       if (pos < 1)
          return;   //��Ʈ������
       tree[pos] = min(tree[pos * 2], tree[pos * 2 + 1]);   //����
       update(pos / 2);   //�θ� ��� ���� ��� �ö�
   }
 
   /* ���� ���� ȣ���� �Լ� */
   int query(int left, int right) {  //left~right ������ ��ǥ��
       return query(left, right, 1, 0, size - 1);
   }
   void update(int index, int newValue) {   //index�� ��� ���� ����
       tree[size + index] = newValue; //�ش� ��� ������Ʈ
       update((size + index) / 2); //�θ� ��� ��� ������Ʈ
   }
};

*/

/*
a~b�� �ִ�,�ּ� ��ȯ: a (���ʳ� ���)�� �ִ� ��尡 �����ʳ���϶� �� �θ��尡 ������ ��ǥ�ϴ� ���� ���� �� ���ٴ����� �̿��Ͽ� ����� ��ġ�� �������϶��� �� �����ʿ� �� ��ġ�ϴ� ���ʳ��  (�� �� ���� ���� �ٸ� �θ��带 ������.) ��, ���ʳ���϶��� �θ���� ��ġ�� �Űܰ��鼭 ���ϰ��� �����Ѵ�. �ݴ�� b(�����ʳ� ���) ���� ���ʳ���϶� �� ����� ���ʿ� �ִ� �����ʳ��, ������ ����϶� �� �θ���� ��ġ�� �Űܰ��鼭 ���ϰ��� �����Ѵ�. �� ��ġ�� �����ǰų� ��ĥ�� ������ �����Ѵ�.
*/

const int INF = 2e9;
struct Tree{
    int first;
    vector<int> tree;
    Tree(int n)
    {
        for(first=1;first<n;first<<=1);
        tree = vector<int>( n<<2, INF);
    }

    void update(int pos, int val)
    {
        pos += first;
        tree[pos] = val;
        while(pos>>1){
            tree[pos>>1] = min(tree[pos>>1],tree[pos]);
            pos>>=1;
        }
    }

    int query(int l, int r)
    {
        l += first;
        r += first;
        int ret = INF;
        while(l<=r){
            ret = min(ret, min(tree[l],tree[r]));
            l = (l+1)>>1;
            r = (r-1)>>1;
        }
        return ret;
    }

};