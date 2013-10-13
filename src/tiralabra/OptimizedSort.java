
package tiralabra;

// Optimoitu järjestäminen käyttäen pika- ja lisäysjärjestämisen hybridiä
// Aikavaativuus pahimmassa tapauksessa O(n^2), mutta keskimäärin O(n log n)
// Parhaassa tapauksessa aikavaativuus voi nyt olla O(n), jos taulukon koko on 150 alkiota tai alle, ja ne ovat jo valmiiksi järjestyksessä
// Tilavaativuus on korkeintaan O(log n)

public class OptimizedSort {
    // Quicksort jos taulukon koko on vähintään 150 alkiota, muuten Insertion sort
    
    public int[] sort(int[] array) {
        return quicksort(array, 0, array.length-1);
    }
    
    public int[] quicksort(int[] array, int left, int right) {
        
        if (right - left < 150) {
            return insertionSort(array, left, right);
        }
        
        while (left < right) {
            int p = partition(array, left, right);
            
            if ((p - left) < (right - p)) {
                quicksort(array, left, p);
                left = p+1;
            } else {
                quicksort(array, p+1, right);
                right = p;
            }
        }
        return array;
    }
    
    // Palauttaa kolmen mediaanin, eli mediaanin luvuista array[right], array[left], ja array[(left+right)/2]
    public int pickPivot(int[] array, int left, int right) {
        int mid = (left+right)/2;
        int[] temp = {array[left], array[mid], array[right]};
        insertionSort(temp, 0, 2);
        return temp[1];
    }
    
    public int partition(int[] array, int left, int right) {
        int p = pickPivot(array, left, right);
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
    
    public int[] insertionSort(int[] array, int left, int right) {
        for (int i = left; i <= right; i++) {
            int valueAtIndex = array[i];
            int index = i;
            
            while (index > 0 && valueAtIndex < array[index - 1]) {
                array[index] = array[index - 1];
                index--;
            }
            
            array[index] = valueAtIndex;
        }
        return array;
    }
}
