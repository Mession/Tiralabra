
package tiralabra;

// Lisäysjärjestäminen
// Aikavaativuus on keskimäärin ja pahimmassa tapauksessa O(n^2). Parhaassa tapauksessa se on O(n). 
// Tilavaativuus on aina O(1)
public class InsertionSort {
    
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
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
