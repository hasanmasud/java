package online.smartcompute.tutorial.test.junit4.demo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Demo2 {
	
	private int p1;
	private int p2;
	private int expected;
	
	/**
	 * 
	 * @param p1 p1
	 * @param p2 p2
	 * @param expected mean
	 */
	public Demo2(int p1, int p2, int expected) {
		this.p1 = p1;
		this.p2 = p2;
		this.expected = expected;
	}
	
	// creates the test data
    @Parameters(name = "{index}: mean(({0}+{1})/2)={2}")
    public static Collection<Object[]> data() {
    Object[][] data = new Object[][] {
                       { 4, 6, 5 }, 
                       { 2, 2, 2 }, 
                       { 8, 2, 5 }, 
                       { 1, 5, 3 } 
              };
       return Arrays.asList(data);
     }
    
    @Test
    public void test_mean() {    
        assertEquals(expected,MyUtils.mean(p1, p2),0.0001);
    }

}


class MyUtils {
	public static double mean(int a, int b) {
		double sum = 0;
		sum = a + b;
		return sum / 2;
	}
}