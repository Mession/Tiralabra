
package tiralabra;

public class Tiralabra {

    public static void main(String[] args) {
        //final long startTime = System.nanoTime();
        //int[] testi = new int[]{3, 4, 2, 1, 5};
        //InsertionSort sort = new InsertionSort(testi);
        
        InsertionSort sort = new InsertionSort();
        sort.setArray(sort.initialiseRandomArray(500000, 100000));
        long startTime = System.currentTimeMillis();
        
        //sort.printArray();
        sort.insertionSort();
        //System.out.println("");
        //sort.printArray();
        long duration = System.currentTimeMillis() - startTime;
        // väärät arvot alla vielä, ei oo sekunteja tai millisekunteja
        if (duration < 1000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia");
        }
    }
}
