package Netflix;

public class NetflixTester {

	public static void main(String[] args) {
		Netflix netflix = new Netflix();
		
		System.out.print(netflix.categories.display());
		System.out.println("\n****************************");
		
		for(Movie m: netflix.all) {
			
			System.out.println(m.toString());
		}
		
		@SuppressWarnings("rawtypes")
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
		
		System.out.print(act.display());
		System.out.print(adv.display());
		
		CircularDoublyLinkedList<Movie> res = netflix.commonMovies(act, adv);
		System.out.print(res.display());
		
		System.out.print(netflix.com.display());
		System.out.print(netflix.dra.display());
		
		CircularDoublyLinkedList<Movie> res2 = netflix.commonMovies(netflix.com, netflix.dra);
		System.out.print(res2.display());
		
		CircularDoublyLinkedList<Movie> res3 = netflix.commonMovies(netflix.com, adv);
		System.out.print(res3.display());
		
		System.out.print("\n\n********************************************");
		for(Movie m: netflix.searchAll("hon")) {
			System.out.print("\n\t" + m.toString());
		}
		
		System.out.print(netflix.mus.display());
		
		CircularDoublyLinkedList<Movie> res4 = netflix.commonMovies(netflix.com, netflix.spo);
		System.out.print(res4.display());
	}

}
