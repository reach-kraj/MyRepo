package advancejava;

import java.util.*;
/*
Iterator hasNext method returns true if the given Iteration has more elements.
Return type is boolean. returns true if the iteration contains more elements, else return false.

Iterator Next method will return the next element in the iteration.
*/
public class IteratorExample
{
public static void main(String[] args) 
{
   LinkedList<Integer> l=new LinkedList<Integer>();
   l.add(10);
   l.add(20);
   l.add(30);
   l.add(40);
   l.add(50);
   l.add(100);
   System.out.println("The Elements in the LinkedList are : "+l);
   
   Iterator<Integer> i =l.iterator();
   System.out.println("The Elements in the LinkedList using Iterator are :");
   while(i.hasNext())
   {
	   System.out.println(i.next());
   }
}
}

