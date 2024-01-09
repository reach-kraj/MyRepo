package threadconcept;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinDoubleAction {
	public static void main(String[] args) {
	    ForkJoinPool forkJoinPool = new ForkJoinPool();
	    int[] array = {1, 5, 10, 15, 20, 25, 50};
	    DoubleNumber doubleNumberTask = new DoubleNumber(array, 0, array.length);

	    forkJoinPool.invoke(doubleNumberTask);
	    System.out.println(DoubleNumber.result);
	  }
	}

	class DoubleNumber extends RecursiveAction {

	  final int PROCESS_THRESHOLD = 2;
	  int[] array;
	  int startIndex, endIndex;
	  static int result;

	  DoubleNumber(int[] array, int startIndex, int endIndex) {
	    this.array = array;
	    this.startIndex = startIndex;
	    this.endIndex = endIndex;
	  }

	  @Override
	  protected void compute() {
	    if (endIndex - startIndex <= PROCESS_THRESHOLD) {
	      for (int i = startIndex; i < endIndex; i++) {
	        result += array[i];
	      }
	    } else {
	      int mid = (startIndex + endIndex) / 2;
	      DoubleNumber leftArray = new DoubleNumber(array, startIndex, mid);
	      DoubleNumber rightArray = new DoubleNumber(array, mid, endIndex);

	      leftArray.fork();
	      rightArray.fork();

	      leftArray.join();
	      rightArray.join();
	    }
	  }
}
