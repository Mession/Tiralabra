
package tiralabra;

public class Heap {
    private int[] heap;
    private int heapsize;
    
    public int[] buildHeap(int[] array) {
        heapsize = array.length;
        heap = array;
        for (int i = array.length/2; i >= 0; i--) {
            heapify(i);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = heapDelMin();
        }
        return array;
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
    
    public int heapDelMin() {
        int min = heap[0];
        heap[0] = heap[heapsize-1];
        heapsize--;
        heapify(0);
        return min;
    }
}
