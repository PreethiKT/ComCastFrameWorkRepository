package Practice.test;

import org.testng.annotations.Test;

public class Check1 {
	 @Test
	 public void test01() {
		 System.out.println("Check 1 test 01 "+Thread.currentThread().getId());
	 }
	 
	 @Test
	 public void test02() {
		 System.out.println("Check 1 test 02 "+Thread.currentThread().getId());
	 }
	
}
