/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author User
 */
public class InsertionSortTest {
    InsertionSort is;
    OptimizedSort os;
    Heap hp;
    Quicksort qs;
    ArrayOperations ao;
    
    public InsertionSortTest() {
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
        os = new OptimizedSort();
        qs = new Quicksort();
        hp = new Heap();
        ao = new ArrayOperations();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void jarjestaa() {
        int[] testi = {3, 5, 2, 4, 1};
        int[] tulos = {1, 2, 3, 4, 5};
        is.sort(testi);
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
        is.sort(test1);
        long duration1 = System.currentTimeMillis() - startTime;
        startTime = System.currentTimeMillis();
        is.sort(test2);
        long duration2 = System.currentTimeMillis() - startTime;
        assertTrue(duration2 > duration1);
    }
    
    @Test
    public void aikaVaativuus2() {
        int[] testi = ao.initialiseOrderedArray(100000);
        long startTime = System.currentTimeMillis();
        is.sort(testi);
        long duration1 = System.currentTimeMillis() - startTime;
        testi = ao.initialiseOrderedArray(100000);
        startTime = System.currentTimeMillis();
        os.sort(testi);
        long duration2 = System.currentTimeMillis() - startTime;
        assertTrue(duration2 > duration1);
    }
}