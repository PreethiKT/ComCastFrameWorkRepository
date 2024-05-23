package Practice.test;

import org.testng.annotations.Test;

public class check2 {
   
	 @Test
	 public void test01() {
		 System.out.println("Check 2 test 01 "+Thread.currentThread().getId());
	 }
	 
	 @Test
	 public void test02() {
		 System.out.println("Check 2 test 02 "+Thread.currentThread().getId());
	 }
}
