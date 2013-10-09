
package tiralabra;

public class Heap {
    private int[] heap;
    private int heapsize;
    
    public int[] heapSort(int[] array) {
        buildHeap(array);
        for (int i = array.length-1; i > 0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            heapsize--;
            //heapify(0);
            heapifyIterative(0);
        }
        return array;
    }
    
    public void buildHeap(int[] array) {
        heapsize = array.length;
        heap = array;
        for (int i = array.length/2; i >= 0; i--) {
            //heapify(i);
            heapifyIterative(i);
        }
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
    
    public void heapifyIterative(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest;
        while (l <= heapsize-1) {
            largest = i;
            if (heap[l] > heap[i]) {
                largest = l;
            }
            if (r <= heapsize-1 && heap[r] > heap[largest]) {
                largest = r;
            }
            if (largest != i) {
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;
                i = largest;
                l = leftChild(i);
                r = rightChild(i);
            } else {
                i = heapsize;
                l = leftChild(i);
                r = rightChild(i);
            }
        }
    }
       
    public void heapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest;
        if (r <= heapsize-1) {
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
        } else if (l == heapsize-1 && heap[i] < heap[l]) {
            int temp = heap[i];
            heap[i] = heap[l];
            heap[l] = temp;
        }
    }
    
    public int heapDelMax() {
        int max = heap[0];
        heap[0] = heap[heapsize-1];
        heapsize--;
        //heapify(0);
        heapifyIterative(0);
        return max;
    }
}
