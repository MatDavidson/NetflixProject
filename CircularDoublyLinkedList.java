package Netflix;


//Node class for the CDLL. 
class Node<E>{
	
	private E element;
	private Node<E> next, prev;
	
	public Node() {
		this.element = null;
		this.next = null;
		this.prev = null;
	}
	
	public Node(E e) {
		this.element = e;
		this.next = null;
		this.prev = null;
	}
	
	public Node(E e, Node<E> n, Node<E> p) {
		this.element = e;
		this.next = n;
		this.prev = p;
	}
	
	public void setNext(Node<E> n) {
		this.next = n;
	}
	
	public Node<E> getNext(){
		return next;
	}
	
	public void setPrev(Node<E> n){
		this.prev = n;
	}
	
	public Node<E> getPrev(){
		return prev;
	}
	
	public E getElement(){
		return element;
	}
}


//CDLL class
public class CircularDoublyLinkedList<E> {

	private Node<E> head, tail;
	private int size;
	private String name = "";
	
	public CircularDoublyLinkedList(String name) {
		this.name = name;
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getSize() {
		return size;
	}
	public String getName() {
		return name;
	}
	
	//Adds a new node of Element e at the head of the list. 
	public void addFirst(E e) {
		Node<E> n = new Node<E>(e);
		
		if(head == null) {
			n.setNext(n);
			n.setPrev(n);		
			head = n;
			tail = n;
		}
		else {
			n.setPrev(tail);
			tail.setNext(n);
			head.setPrev(n);
			n.setNext(head);
			head = n;
		}
		size++;
	}
	
	//Adds Node n to the head of the list
	public void addFirst(Node<E> n) {
		if(head == null) {
			n.setNext(n);
			n.setPrev(n);		
			head = n;
			tail = n;
		}
		else {
			n.setPrev(tail);
			tail.setNext(n);
			head.setPrev(n);
			n.setNext(head);
			head = n;
		}
		size++;
	}
	
	//Adds a new node of element e to the end of the list.
	public void addLast(E e) {
		Node<E> n = new Node<E>(e);
		
		if(tail == null) {
			n.setNext(n);
			n.setPrev(n);		
			head = n;
			tail = n;
		}
		else {
			n.setPrev(tail);
			tail.setNext(n);
			head.setPrev(n);
			n.setNext(head);
			tail = n;
		}
		size++;
	}
	
	
	//Adds Node n to the end of the list.
	public void addLast(Node<E> n) {
		if(tail == null) {
			n.setNext(n);
			n.setPrev(n);		
			head = n;
			tail = n;
		}
		else {
			n.setPrev(tail);
			tail.setNext(n);
			head.setPrev(n);
			n.setNext(head);
			tail = n;
		}
		size++;
	}
	
	//Adds a new node of element e at a specified position.
	public void insertAtPos(int pos, E e) {
		if(pos == 0)
			addFirst(e);
		
		else if(pos >= size)
			addLast(e);
		
		else {
			Node<E> node1 = head;					//This part is confusing
			for(int i = 1; i < pos; i++) {
				node1 = node1.getNext();			//Traverses the list to the node before insertion point. In comments, this node will be referred to 
			}										//	as node1. The node being inserted will be newNode. The node after will be node2.
			
			Node<E> node2 = node1.getNext();		//Creates a pointer to node 2
			
			Node<E> newNode = new Node<E>(e); 		//Creates newNode 
			
			node1.setNext(newNode);					//Sets node1's next pointer to newNode
			
			newNode.setPrev(node1); 				//Sets newNode's previous pointer to node1
			
			newNode.setNext(node2);					//Sets newNode's next pointer to node2
			
			node2.setPrev(newNode); 				//Sets node2's previous pointer to newNode 
		}
		size++;
	}
	
	//Adds node n at a specified position.
		public void insertAtPos(int pos, Node<E> n) {
			if(pos == 0)
				addFirst(n);
			
			else if(pos >= size)
				addLast(n);
			
			else {
				Node<E> node1 = head;					//This part is confusing
				for(int i = 1; i < pos; i++) {
					node1 = node1.getNext();			//Traverses the list to the node before insertion point. In comments, this node will be referred to 
				}										//	as node1. The node being inserted will be newNode. The node after will be node2.
				
				Node<E> node2 = node1.getNext();		//Creates a pointer to node 2
				
				Node<E> newNode = n; 		//Creates newNode 
				
				node1.setNext(newNode);					//Sets node1's next pointer to newNode
				
				newNode.setPrev(node1); 				//Sets newNode's previous pointer to node1
				
				newNode.setNext(node2);					//Sets newNode's next pointer to node2
				
				node2.setPrev(newNode); 				//Sets node2's previous pointer to newNode 
			}
			size++;
		}
	
	//Removes and returns the first element. If the list is empty it returns an empty node. If the list has a single 
	//	element, it empties the list and returns the single node.
	public Node<E> removeFirst() {
		if(size == 0)
			return new Node<E>();
		else if(size == 1) {
			Node<E> temp = head;
			head = null;
			tail = null;
			size = 0;
			return temp;
		}
		else {
			Node<E> temp = head;
			head = head.getNext();
			head.setPrev(tail);
			tail.setNext(head);
			size--;
			return temp;
		}
	}
	
	//Removes and returns the last element. If the list is empty it returns an empty node. If the list has a single 
	//	element, it empties the list and returns the single node.
	public Node<E> removeLast() {
		if(size == 0)
			return new Node<E>();
		else if(size == 1) {
			Node<E> temp = tail;
			head = null;
			tail = null;
			size = 0;
			return temp;
		}
		else {
			Node<E> temp = tail;
			tail = tail.getPrev();
			head.setPrev(tail);
			tail.setNext(head);
			size--;
			return temp;
		}
	}
	
	public void deleteAtPos(int pos) {
		if(pos == 1) {
			if(size == 1) {
				head = null;
				tail = null;
				size = 0;
				return;
			}
			head = head.getNext();
			head.setPrev(tail);
			tail.setNext(head);
			size--;
			return;
		}

		else if(pos >= size) {
			tail = tail.getPrev();
			tail.setNext(head);
			head.setPrev(tail);
			size--;
			return;
		}

		else {
			Node<E> node1 = head;					
			for(int i = 1; i < pos; i++) {
				node1 = node1.getNext();			
			}	
			Node<E> n = node1.getNext();		
			Node<E> p = node1.getPrev(); 		 

			n.setPrev(p);
			p.setNext(n);
			size--;
		}
	}
	
	public String display() {
		StringBuilder sB = new StringBuilder();
		sB.append("\n\t**********\n\t" + name + ": ");
		
		if (size == 0) {
			sB.append("empty.");
			return sB.toString();
		}
			
		Node<E> current = head;
		sB.append(size + "\n\t**********");
		sB.append("\n\t" + current.getElement().toString());
		
		if (current.getNext() == current)
			return sB.toString();
		
		else
			current = current.getNext();
			while(current.getNext() != head) {
				sB.append("\n\t" + current.getElement().toString());
				current = current.getNext();
			}
			
			sB.append("\n\t" + current.getElement().toString());

			return sB.toString();
	}
	
	public String toString() {
		return name + ": " + size;
	}
	
	public Node<E> getHead(){
		return head;
	}
	
	public Node<E> getTail(){
		return tail;
	}
}
	
