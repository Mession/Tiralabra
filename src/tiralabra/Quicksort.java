
package tiralabra;

// Pikajärjestäminen
// Aikavaativuus on keskimäärin ja parhaassa tapauksessa O(n log n). Pahimmassa tapauksessa aikavaativuus on O(n^2).
// Tilavaativuus on korkeintaan O(log n)
public class Quicksort {
    
    
    // Naiivi Quicksort, joka ei toteuta tilavaatimusta O(log n)
    public int[] quicksort(int[] array, int left, int right) {
        if (left < right) {
            int p = partition(array, left, right);
            quicksort(array, left, p);
            quicksort(array, p+1, right);
        }
        return array;
    }
    
    // Parempaan päin, nyt todennäköisemmin toteuttaa tilavaativuuden
    public int[] iterative(int[] array, int left, int right) {
        while (left < right) {
            int p = partition(array, left, right);
            iterative(array, left, p);
            left = p+1;
        }
        return array;
    }
    
    // Ja nyt toteuttaa tilavaativuuden, sillä pidempi taulukoista käydään iteratiivisesti läpi
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
    
    // Lopullinen metodi, jolle ei tarvitse erikseen antaa indeksejä
    public int[] sort(int[] array) {
        return iterative2(array, 0, array.length-1);
    }
    
    // Jaetaan taulukko kahteen osaan, toisessa on jakoalkiota (alla muuttuja p) pienemmät ja toisessa sitä suuremmat alkiot
    public int partition(int[] array, int left, int right) {
        // Tässä jakoalkio perinteinen array[left], parempiakin vaihtoehtoja on (kuten luokassa OptimizedSort)
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
