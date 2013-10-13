
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
import tiralabra.OptimizedSort;
import tiralabra.Quicksort;

public class QuickSortTest {
    InsertionSort is;
    Heap hp;
    Quicksort qs;
    ArrayOperations ao;
    
    public QuickSortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        is = new InsertionSort();
        qs = new Quicksort();
        hp = new Heap();
        ao = new ArrayOperations();
    }
    
    @After
    public void tearDown() {
    }
    
    // Testaa, järjestääkö yksinkertaisen taulukon oikein
    @Test
    public void jarjestaa() {
        int[] testi = {3, 5, 2, 4, 1};
        int[] tulos = {1, 2, 3, 4, 5};
        qs.sort(testi);
        for (int i = 0; i < 5; i++) {
            assertEquals(tulos[i], testi[i]);
        }
    }
    
    // Testaa, järjestääkö sekalaisen taulukon oikein
    @Test
    public void jarjestaaRandomin() {
        int[] testi = ao.initialiseRandomArray(100000, 100000);
        qs.sort(testi);
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
        qs.sort(test1);
        long duration1 = System.currentTimeMillis() - startTime;
        startTime = System.currentTimeMillis();
        qs.sort(test2);
        long duration2 = System.currentTimeMillis() - startTime;
        assertTrue(duration2 > duration1);
    }
    
    // Testaa, että pikajärjestäminen toimii nopeammin kuin lisäysjärjestäminen silloin, jos
    // taulukko on käänteisessä järjestyksessä
    @Test
    public void aikavaativuus2() {
        int[] testi = ao.reverseOrderArray(100000);
        long startTime = System.currentTimeMillis();
        qs.sort(testi);
        long duration1 = System.currentTimeMillis() - startTime;
        testi = ao.reverseOrderArray(100000);
        startTime = System.currentTimeMillis();
        is.sort(testi);
        long duration2 = System.currentTimeMillis() - startTime;
        assertTrue(duration2 > duration1);
    }
    
    // Testaa, että pikajärjestämisellä kestää järjestämisessä keskimäärin vähemmän aikaa
    // kuin kekojärjestämisellä
    @Test
    public void aikavaativuus3() {
        int n = 10;
        long qsAverage = 0;
        for (int i = 0; i < n; i++) {
            int[] testi = ao.initialiseRandomArray(100000, 100000);
            long startTime = System.currentTimeMillis();
            qs.sort(testi);
            long duration = System.currentTimeMillis() - startTime;
            qsAverage += duration;
        }
        qsAverage /= n;
        long hpAverage = 0;
        for (int i = 0; i < n; i++) {
            int[] testi = ao.initialiseRandomArray(100000, 100000);
            long startTime = System.currentTimeMillis();
            hp.sort(testi);
            long duration = System.currentTimeMillis() - startTime;
            hpAverage += duration;
        }
        hpAverage /= n;
        assertTrue(qsAverage < hpAverage);
    }
}