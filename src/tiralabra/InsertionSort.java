
package tiralabra;

public class InsertionSort {
    // Lisäysjärjestäminen
    
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
