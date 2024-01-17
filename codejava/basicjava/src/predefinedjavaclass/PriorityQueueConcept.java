package predefinedjavaclass;

import java.util.PriorityQueue;

public class PriorityQueueConcept {
	public static void main(String args[])
    {
        PriorityQueue<String> pq = new PriorityQueue<>();
 
        pq.add("PriorityQueue");
        pq.add("For");
        pq.add("Test");
 
        System.out.println("Initial PriorityQueue " + pq);
 
          // using the method
        pq.remove("For");
 
        System.out.println("After Remove - " + pq);
 
        System.out.println("Poll Method - " + pq.poll());
 
        System.out.println("Final PriorityQueue - " + pq);
    }
}
