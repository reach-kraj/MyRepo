package predefinedjavaclass;

import java.util.PriorityQueue;

public class PriorityQueueConcept {
	public static void main(String args[])
    {
        PriorityQueue<String> pq = new PriorityQueue<>();
 
        pq.add("A");
        pq.add("a");
        pq.add("B");
        pq.add("b");
        pq.add("1");
        pq.add("c");
        pq.add("D");
 
        System.out.println("Initial PriorityQueue " + pq);
        //sort the element
        // using remove the method
        pq.remove("c");
 
        System.out.println("After Remove c- " + pq);
 
        System.out.println("Poll Method - " + pq.poll());
        //poll() method used to retrieve and remove the head of the deque 
 
        System.out.println("Final PriorityQueue - " + pq);
    }
}
