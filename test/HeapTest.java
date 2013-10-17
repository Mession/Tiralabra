
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.ArrayOperations;
import tiralabra.Heap;
import tiralabra.InsertionSort;

public class HeapTest {
    Heap hp;
    ArrayOperations ao;
    InsertionSort is;
    
    public HeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        hp = new Heap();
        ao = new ArrayOperations();
        is = new InsertionSort();
    }
    
    @After
    public void tearDown() {
    }
    
    // Testaa, järjestääkö yksinkertaisen taulukon oikein
    @Test
    public void jarjestaa() {
        int[] testi = {3, 5, 2, 4, 1};
        int[] tulos = {1, 2, 3, 4, 5};
        hp.heapSort(testi);
        for (int i = 0; i < 5; i++) {
            assertEquals(tulos[i], testi[i]);
        }
    }
    
    // Testaa, järjestääkö sekalaisen taulukon oikein
    @Test
    public void jarjestaaRandomin() {
        int[] testi = ao.initialiseRandomArray(100000, 100000);
        hp.heapSort(testi);
        assertTrue(ao.jarjestyksessa(testi));
    }
    
    // Testaa, että lyhyempi taulukko järjestetään nopeammin kuin pitkä
    @Test
    public void aikavaativuus1() {
        Random rand = new Random();
        int r1 = rand.nextInt(50000);
        int r2 = rand.nextInt(50000)+100000;
        int[] test1 = ao.initialiseRandomArray(r1, 10000);
        int[] test2 = ao.initialiseRandomArray(r2, 5000);
        long startTime = System.currentTimeMillis();
        hp.heapSort(test1);
        long duration1 = System.currentTimeMillis() - startTime;
        startTime = System.currentTimeMillis();
        hp.heapSort(test2);
        long duration2 = System.currentTimeMillis() - startTime;
        assertTrue(duration2 > duration1);
    }
    
    // Testaa, että kekojärjestäminen järjestää käänteisen taulukon (n-1, n-2, ..., 2, 1, 0) nopeammin kuin lisäysjärjestäminen
    // keskimääräinen O(n log n) vs pahin tapaus O(n^2)
    @Test
    public void aikavaativuus2() {
        int[] testi = ao.reverseOrderArray(100000);
        long startTime = System.currentTimeMillis();
        hp.heapSort(testi);
        long duration1 = System.currentTimeMillis() - startTime;
        testi = ao.reverseOrderArray(100000);
        startTime = System.currentTimeMillis();
        is.sort(testi);
        long duration2 = System.currentTimeMillis() - startTime;
        assertTrue(duration2 > duration1);
    }
    
    // Testaa, että kekojärjestämisellä kestää järjestämisessä keskimäärin vähemmän aikaa
    // kuin lisäysjärjestämisellä (keskimääräinen O(n log n) vs keskimääräinen O(n^2)
    @Test
    public void aikavaativuus3() {
        int n = 10;
        long hpAverage = 0;
        for (int i = 0; i < n; i++) {
            int[] testi = ao.initialiseRandomArray(100000, 100000);
            long startTime = System.currentTimeMillis();
            hp.sort(testi);
            long duration = System.currentTimeMillis() - startTime;
            hpAverage += duration;
        }
        hpAverage /= n;
        long isAverage = 0;
        for (int i = 0; i < n; i++) {
            int[] testi = ao.initialiseRandomArray(100000, 100000);
            long startTime = System.currentTimeMillis();
            is.sort(testi);
            long duration = System.currentTimeMillis() - startTime;
            isAverage += duration;
        }
        isAverage /= n;
        assertTrue(isAverage > hpAverage);
    }
}