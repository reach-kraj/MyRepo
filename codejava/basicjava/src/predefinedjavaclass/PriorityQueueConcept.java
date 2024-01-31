package predefinedjavaclass;

import java.util.PriorityQueue;

public class PriorityQueueConcept {
	public static void main(String args[])
    {
        PriorityQueue<String> pq = new PriorityQueue<>();
 
        pq.add("PriorityQueue");
        pq.add("z");
        pq.add("K");
        pq.add("P");
        pq.add("P");
        pq.add("Test");
        pq.add("Test");
 
        System.out.println("Initial PriorityQueue " + pq);
        //sort the element
        // using remove the method
        pq.remove("For");
 
        System.out.println("After Remove For- " + pq);
 
        System.out.println("Poll Method - " + pq.poll());
        //poll() method used to retrieve and remove the head of the deque 
 
        System.out.println("Final PriorityQueue - " + pq);
    }
}
