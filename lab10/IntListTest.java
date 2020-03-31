package lab10;

public class IntListTest {

	   public static void main(String[] args) {
	      
	      IntListSorted list1 = new IntListSorted();
	      
//	      list1.add(5);
//	      list1.add(4);
//	      list1.add(3);
	      list1.add(0);
	      list1.add(1);
	      list1.add(3);
	      list1.add(10);
	      System.out.println(list1);
	      System.out.println("Size: " + list1.size());
	      System.out.println("Min: " + list1.getMinimum());
	      System.out.println("Max: " + list1.getMaximum());
	      System.out.println("Median: " + list1.getMedian());
	   }
	}
