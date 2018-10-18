package Netflix;

public class NetflixTester {

	public static void main(String[] args) {
		Netflix netflix = new Netflix();
		
		System.out.print(netflix.categories.display());
		System.out.println("\n****************************");
		
		for(Movie m: netflix.all) {
			
			System.out.println(m.toString());
		}
		
		Node<CircularDoublyLinkedList> ptr = netflix.getCategories().getHead();
		for(int i = 0; i < netflix.categories.getSize(); i ++) {
			if(ptr.getElement().getSize() > 0)
				System.out.print("\n\t" + ptr.getElement().getName() + ": " + ptr.getElement().getSize());
			ptr = ptr.getNext();
		}
		
		@SuppressWarnings("unchecked")
		CircularDoublyLinkedList<Movie> act = netflix.getCategories().getHead().getElement();
		@SuppressWarnings("unchecked")
		CircularDoublyLinkedList<Movie> adv = netflix.getCategories().getHead().getNext().getElement();
		CircularDoublyLinkedList<Movie> res = netflix.commonMovies(act, adv);
		
		System.out.print("\n\n\t" + res.getName() + ": " + res.getSize());
	}

}
