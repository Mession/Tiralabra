
package tiralabra;

import java.util.Scanner;

public class Tiralabra {

    public static void main(String[] args) {
        //alustetaan luokat ja muuttujat
        InsertionSort is = new InsertionSort();
        Heap hp = new Heap();
        QuickSort qs = new QuickSort();
        ArrayOperations ao = new ArrayOperations();
        Scanner s = new Scanner(System.in);
        long startTime;
        long duration;
        
        // Insertion sort eli Lisäysjärjestäminen, aika keskimäärin O(n^2), pahin O(n^2), paras O(n), tila O(1)
        // Paras pienillä tai melkein järjestyksessä olevilla taulukoilla
        // Heapsort eli Kekojärjestäminen, aika keskimäärin O(n log n), pahin O(n log n), paras O(n log n), O(1)
        // Hyvä, jos tarvitaan järjestämisalgoritmi, joka toimii vakiotilassa
        // Quicksort eli Pikajärjestäminen, aika keskimäärin O(n log n), pahin O(n^2), paras O(n log n), tila O(log n)
        // Paras keskimäärin, koska pienet vakiokertoimet ja pahin tapaus harvinainen (jos hyvä jakoalkio)
        
        /* EKA DEMO: TOIMIIKO JÄRJESTÄMISET
        
        //Aluksi demot jokaisella, että järjestävät testitaulukon
        int[] testi = new int[]{3, 5, 2, 1, 4};
        
        //Insertion sort
        testi = new int[]{3, 5, 2, 1, 4};
        System.out.println("Insertion sort\nEnnen järjestämistä:");
        ao.printArray(testi);
        startTime = System.currentTimeMillis();
        is.sort(testi);
        duration = System.currentTimeMillis() - startTime;
        System.out.println("\nInsertion sortin jälkeen:");
        ao.printArray(testi);
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //IS end
        
        //Heap sort
        testi = new int[]{3, 5, 2, 1, 4};
        System.out.println("Heap sort\nEnnen järjestämistä:");
        ao.printArray(testi);
        startTime = System.currentTimeMillis();
        hp.heapSort(testi);
        duration = System.currentTimeMillis() - startTime;
        System.out.println("\nHeap sortin jälkeen:");
        ao.printArray(testi);
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //Heap end
        
        //Quicksort
        testi = new int[]{3, 5, 2, 1, 4};
        System.out.println("Quicksort\nEnnen järjestämistä:");
        ao.printArray(testi);
        startTime = System.currentTimeMillis();
        qs.iterative2(testi, 0, testi.length-1);
        duration = System.currentTimeMillis() - startTime;
        System.out.println("\nQuicksortin jälkeen:");
        ao.printArray(testi);
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //QS end
        
        */
        
        /* TOKA DEMO: RANDOM 100 000 ALKION TAULUKKO
        
        int[] random = ao.initialiseRandomArray(100000, 10000);
        
        //Insertion sort
        random = ao.initialiseRandomArray(100000, 10000);
        System.out.println("Insertion sort");
        startTime = System.currentTimeMillis();
        is.sort(random);
        duration = System.currentTimeMillis() - startTime;
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //IS end
        
        //Heap sort
        random = ao.initialiseRandomArray(100000, 10000);
        System.out.println("Heap sort");
        startTime = System.currentTimeMillis();
        hp.heapSort(random);
        duration = System.currentTimeMillis() - startTime;
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //Heap end
        
        //Quicksort
        random = ao.initialiseRandomArray(100000, 10000);
        System.out.println("Quicksort");
        startTime = System.currentTimeMillis();
        qs.iterative2(random, 0, random.length-1);
        duration = System.currentTimeMillis() - startTime;
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //QS end
        
        */
        
        /* KOLMAS DEMO: VALMIIKSI JÄRJESTYKSESSÄ, ELI INSERTIONILLE PARAS TAPAUS, QUICKSORTILLE PAHIN (KOSKA PIVOT NYT array[left]
        
        int[] ordered = ao.initialiseOrderedArray(100000);
        
        //Insertion sort
        ordered = ao.initialiseOrderedArray(100000);
        System.out.println("Insertion sort");
        startTime = System.currentTimeMillis();
        is.sort(ordered);
        duration = System.currentTimeMillis() - startTime;
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //IS end
        
        //Heap sort
        ordered = ao.initialiseOrderedArray(100000);
        System.out.println("Heap sort");
        startTime = System.currentTimeMillis();
        hp.heapSort(ordered);
        duration = System.currentTimeMillis() - startTime;
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //Heap end
        
        //Quicksort
        ordered = ao.initialiseOrderedArray(100000);
        System.out.println("Quicksort");
        startTime = System.currentTimeMillis();
        qs.iterative2(ordered, 0, ordered.length-1);
        duration = System.currentTimeMillis() - startTime;
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //QS end
        
        */
        
        /* NELJÄS DEMO: KÄÄNTEISESSÄ JÄRJESTYKSESSÄ OLEVA TAULUKKO, PAHIN TAPAUS INSERTION SORTILLE, MYÖS QUICKSORTILLE
        // KOSKA QUICKSORTILLE OLISI PARAS, JOS JAKOALKIO OLISI TAULUKON ALKIOIDEN MEDIAANI
        
        int[] reverse = ao.reverseOrderArray(100000);
        
        //Insertion sort
        reverse = ao.reverseOrderArray(100000);
        System.out.println("Insertion sort");
        startTime = System.currentTimeMillis();
        is.sort(reverse);
        duration = System.currentTimeMillis() - startTime;
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //IS end
        
        //Heap sort
        reverse = ao.reverseOrderArray(100000);
        System.out.println("Heap sort");
        startTime = System.currentTimeMillis();
        hp.heapSort(reverse);
        duration = System.currentTimeMillis() - startTime;
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //Heap end
        
        //Quicksort
        reverse = ao.reverseOrderArray(100000);
        System.out.println("Quicksort");
        startTime = System.currentTimeMillis();
        qs.iterative2(reverse, 0, reverse.length-1);
        duration = System.currentTimeMillis() - startTime;
        if (duration < 10000) {
            System.out.println("Taulukon järjestäminen kesti " + duration + " millisekuntia\n\n");
        } else {
            System.out.println("Taulukon järjestäminen kesti " + duration/1000 + " sekuntia\n\n");
        }
        s.next();
        //QS end
        */
    }
}
