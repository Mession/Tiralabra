
package tiralabra;

import java.util.Random;

public class InsertionSort {
    private int[] array;
    
    public InsertionSort() {
        array = new int[100];
    }
    
    public InsertionSort(int size) {
        array = new int[size];
    }
    
    public InsertionSort(int[] array) {
        this.array = array;
    }
    
    public int[] getArray() {
        return array;
    }
    
    public void setArray(int[] array) {
        this.array = array;
    }
    
    public void put(int index, int value) {
        array[index] = value;
    }
    
    public int getFromArray(int index) {
        return array[index];
    }
    
    public int getSize() {
        return array.length;
    }
    
    public boolean hasValue(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    
    public void insertionSort() {
        insertionSort(this.array);
    }
    
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int valueAtIndex = array[i];
            int index = i;
            
            while (index > 0 && valueAtIndex < array[index - 1]) {
                array[index] = array[index - 1];
                index--;
            }
            
            array[index] = valueAtIndex;
        }
    }
    
    public void printArray() {
        printArray(this.array);
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
    
}
