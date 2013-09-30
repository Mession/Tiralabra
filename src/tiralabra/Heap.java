
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
    
    public void buildHeap(int[] array) {
        heapsize = array.length;
        for (int i = array.length/2; i > 0; i--) {
            heapify(i);
        }
    }
    
    public void printHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
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
        int largest;
        if (r <= heapsize) {
            if (heap[l] > heap[r]) {
                largest = l;
            } else {
                largest = r;
            }
            if (heap[i] < heap[largest]) {
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;
                heapify(largest);
            }
        } else if (l == heapsize && heap[i] < heap[l]) {
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
        heap[0] = heap[heapsize];
        heapsize--;
        heapify(0);
        return min;
    }
}
