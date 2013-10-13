
package tiralabra;

// Maksimikeko ja sen avulla järjestäminen
// Aikavaativuus on O(n log n) niin pahimmassa, parhaassa kuin keskimääräisessä tapauksessa
// Tilavaativuus on O(1), eli algoritmi toimii vakiotilassa
public class Heap {
    private int heapsize;
    
    // Järjestäminen käyttäen kekoa
    public int[] heapSort(int[] array) {
        buildHeap(array);
        for (int i = array.length-1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapsize--;
            heapifyIterative(0, array);
        }
        return array;
    }
    
    // Apumetodi, jotta jokaista järjestämisalgoritmia voitaisiin kutsua vain .sort
    public int[] sort(int[] array) {
        return heapSort(array);
    }
    
    // Muuttaa parametrina annetun taulukon kekomuotoon
    public void buildHeap(int[] array) {
        heapsize = array.length;
        for (int i = array.length/2; i >= 0; i--) {
            heapifyIterative(i, array);
        }
    }
    
    // Palauttaa indeksissä i olevan alkion vanhemman indeksin
    public int parent(int i) {
        return i/2;
    }
    
    // Palauttaa indeksissä i olevan alkion vasemman lapsen
    public int leftChild(int i) {
        return 2*i;
    }
    
    // Palauttaa indeksissä i olevan alkion oikean lapsen
    public int rightChild(int i) {
        return 2*i+1;
    }
    
    // Iteratiivinen heapify operaatio, jolla taulukon kekomuotoisuus säilytetään kekoa muutettaessa
    // Iteratiivisuus on tarpeen, jotta kekojärjestämisen tilavaativuus on O(1)
    public void heapifyIterative(int i, int[] array) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest;
        while (l <= heapsize-1) {
            largest = i;
            if (array[l] > array[i]) {
                largest = l;
            }
            if (r <= heapsize-1 && array[r] > array[largest]) {
                largest = r;
            }
            if (largest != i) {
                int temp = array[i];
                array[i] = array[largest];
                array[largest] = temp;
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
    
    // Rekursiivinen heapify operaatio, jota käytettäessä optimaalinen tilavaativuus ei toteudu rekursiopinon takia
    public void heapify(int i, int[] array) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest;
        if (r <= heapsize-1) {
            if (array[l] > array[r]) {
                largest = l;
            } else {
                largest = r;
            }
            if (array[i] < array[largest]) {
                int temp = array[i];
                array[i] = array[largest];
                array[largest] = temp;
                heapify(largest, array);
            }
        } else if (l == heapsize-1 && array[i] < array[l]) {
            int temp = array[i];
            array[i] = array[l];
            array[l] = temp;
        }
    }
    
    // Poistaa ja palauttaa keon suurimman alkion
    public int heapDelMax(int[] array) {
        int max = array[0];
        array[0] = array[heapsize-1];
        heapsize--;
        heapifyIterative(0, array);
        return max;
    }
}
