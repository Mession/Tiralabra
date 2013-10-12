
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
    
    @Test
    public void jarjestaa() {
        int[] testi = {3, 5, 2, 4, 1};
        int[] tulos = {1, 2, 3, 4, 5};
        hp.heapSort(testi);
        for (int i = 0; i < 5; i++) {
            assertEquals(tulos[i], testi[i]);
        }
    }
    
    @Test
    public void aikaVaativuus1() {
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
    
    @Test
    public void aikaVaativuus2() {
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
}