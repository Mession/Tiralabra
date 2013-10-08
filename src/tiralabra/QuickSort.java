
package tiralabra;

import java.util.Stack;

public class QuickSort {
    
    public int[] quicksort(int[] array, int left, int right) {
        if (left < right) {
            int p = partition(array, left, right);
            quicksort(array, left, p);
            quicksort(array, p+1, right);
        }
        return array;
    }
    
    public int[] iterative(int[] array, int left, int right) {
        while (left < right) {
            int p = partition(array, left, right);
            iterative(array, left, p);
            left = p+1;
        }
        return array;
    }
    
    public int[] iterative2(int[] array, int left, int right) {
        while (left < right) {
            int p = partition(array, left, right);
            if ((p - left) < (right - p)) {
                iterative2(array, left, p);
                left = p+1;
            } else {
                iterative2(array, p+1, right);
                right = p;
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
        }
        return j;
    }
}
