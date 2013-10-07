
package tiralabra;

public class QuickSort {
    
    // todo: poista häntärekursio, vaihda jakoalkio kolmen mediaaniksi tjsp
    public int[] quicksort(int[] array, int left, int right) {
        if (left < right) {
            int p = partition(array, left, right);
            quicksort(array, left, p);
            quicksort(array, p+1, right);
        }
        return array;
    }
    
    public int[] quicksortIterative(int[] array, int left, int right) {
        while (left < right) {
            int p = partition(array, left, right);
            if (p - left < right - p) {
                quicksortIterative(array, left, right);
                left = p+1;
            } else {
                quicksortIterative(array, p+1, right);
                left = p;
            }
        }
        return array;
    }
    
    public int partition(int[] array, int left, int right) {
        int p = array[left];
        int i = left-1;
        int j = right+1;
        while (i < j) {
            i++;
            while (i < right && array[i] < p) {
                i++;
            }
            j--;
            while (j > left && array[j] > p) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            } else {
                return j;
            }
            //return j;
        }
        return j;
    }
}
