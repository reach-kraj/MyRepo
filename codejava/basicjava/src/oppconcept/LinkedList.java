package oppconcept;

public class LinkedList extends Node {

	Node head;

	public void add(int data) {
		Node container = new Node();//Tight Linking - Composition
		container.setData(data);
		if (head == null) {
			head = container;
		} else {
			Node tempNode = head;//Weak Linking - Aggregation
			while (tempNode.getNext()!= null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(container);
		}
	}

	public void show() {
		Node container = head;
		if(container==null) {
			System.out.println("list is empty");
		}else {
			while (container.getNext() != null) {
				System.out.println(container.getData());
				container = container.getNext();
			}
			System.out.println(container.getData());
		}
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.add(10);
		list1.add(12);
		list1.add(17);
		list1.add(25);
		
		list1.show();
	}
}
