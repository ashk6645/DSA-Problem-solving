class KthLargest {
    int [] a;
    int size = 0;
    int k = 0;
    private int left(int i) {
        return i*2;
    }
    private int right(int i) {
        return i*2+1;
    }
    private int parent(int i) {
        return i/2;
    }
    private void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private void siftdown(int i) {
        siftdown(i, a.length);
    } 
    private void siftdown(int i, int n) {
        while (2*i < n) {
            int j = i;
            if (a[2*i] < a[j]) {
                j = 2*i;
            }
            if (2*i+1<n && a[2*i+1] < a[j]) {
                j = 2*i+1;
            }
            if (i==j) {
                break;
            }
            swap(i, j);
            i=j;
        }
    }
    private void siftup(int i) {
        while (i/2>=1) {
            if (a[i/2] <= a[i]) {
                break;
            }
            swap(i/2, i);
            i = i/2;
        }
    }
    public KthLargest(int k, int[] nums) {
        this.k = k;
        a = new int[k+1];
        heapifyAndInsert(nums);
    }
    private void heapifyAndInsert(int[] nums) {
        size = Math.min(nums.length, k);
        for (int i = 0; i < size; i++) {
            a[i+1] = nums[i];
        }
        int currK = Math.min(nums.length, k);
        for (int i = currK/2; i>=1; i--) {
            siftdown(i, currK+1);
        }
        for (int i = size; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    public int add(int val) {
        if (size == k) {
            if (val > a[1]) { 
                a[1] = val; 
                siftdown(1);
            }
        } else {
            size++;
            a[size] = val;
            siftup(size);
        }
        return a[1];
    }
}