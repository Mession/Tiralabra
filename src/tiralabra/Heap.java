
package tiralabra;

public class Heap {
    private int[] heap;
    private int heapsize;
    
    public Heap(int[] array) {
        this.heap = array;
        heapsize = array.length-1;
    }
    
    public Heap() {
        this.heap = new int[100];
        heapsize = 0;
    }
    
    public int[] getHeap() {
        return heap;
    }
    
    public int[] buildHeap(int[] array) {
        int[] temp = array.clone();
        heapsize = temp.length;
        heap = temp;
        for (int i = temp.length/2; i >= 0; i--) {
            heapify(i);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = heapDelMin();
        }
        return array;
    }
    
    public void printHeap() {
        while (heapsize > 0) {
            System.out.println(heapDelMin());
        }
    }
    
    public void insert(int k) {
        heapsize++;
        int i = heapsize;
        while (i > 1 && heap[parent(i)] < k) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = k;
    }
    
    public int parent(int i) {
        return i/2;
    }
    
    public int leftChild(int i) {
        return 2*i;
    }
    
    public int rightChild(int i) {
        return 2*i+1;
    }
    
    public void heapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest;
        if (r <= heapsize-1) {
            if (heap[l] < heap[r]) {
                smallest = l;
            } else {
                smallest = r;
            }
            if (heap[i] > heap[smallest]) {
                int temp = heap[i];
                heap[i] = heap[smallest];
                heap[smallest] = temp;
                heapify(smallest);
            }
        } else if (l == heapsize-1 && heap[i] > heap[l]) {
            int temp = heap[i];
            heap[i] = heap[l];
            heap[l] = temp;
        }
    }
    
    public int heapmin() {
        return heap[0];
    }
    
    public int heapDelMin() {
        int min = heap[0];
        heap[0] = heap[heapsize-1];
        heapsize--;
        heapify(0);
        return min;
    }
}
