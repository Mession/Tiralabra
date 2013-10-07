
package tiralabra;

public class Tiralabra {

    //todo: demoa varten valmiiksi
    public static void main(String[] args) {
        //final long startTime = System.nanoTime();
        int[] testi = new int[]{3, 4, 2, 1, 5};
        //InsertionSort sort = new InsertionSort(testi);
        
        InsertionSort is = new InsertionSort();
//        sort.setArray(sort.initialiseRandomArray(500000, 100000));
        Heap hp = new Heap();
        int[] testi2 = is.initialiseRandomArray(100000, 1000);
        QuickSort qs = new QuickSort();
        //is.printArray(testi2);
        long startTime = System.currentTimeMillis();
        qs.quicksort(testi2, 0, testi2.length-1);
        //hp.buildHeap(testi2);
        //is.sort(testi2);
        //hp.buildHeap(sort.getArray());
        //sort.printArray();
        //sort.insertionSort();
        //System.out.println("");
        //sort.printArray();
        long duration = System.currentTimeMillis() - startTime;
        //is.printArray(testi2);
        //hp.printHeap();

        if (duration < 1000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia");
        }
    }
}
