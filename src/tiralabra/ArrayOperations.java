
package tiralabra;

import java.util.Random;

public class ArrayOperations {
    
    
    
    public void put(int index, int value, int[] array) {
        array[index] = value;
    }
    
    public int getFromArray(int index, int[] array) {
        return array[index];
    }
    
    public boolean hasValue(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    
    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    public int[] initialiseRandomArray(int arraySize, int maxInt) {
        if (maxInt <= 0) {
            return new int[arraySize];
        }
        Random r = new Random();
        int[] rarray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            rarray[i] = r.nextInt(maxInt+1);
        }
        return rarray;
    }
    
    public int[] initialiseOrderedArray(int size) {
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }
    
    public int[] reverseOrderArray(int size) {
        int [] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i - 1;
        }
        return array;
    }
}
