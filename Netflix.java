package Netflix;

import java.util.ArrayList;

public class Netflix {
	@SuppressWarnings("rawtypes") CircularDoublyLinkedList<CircularDoublyLinkedList> categories = new CircularDoublyLinkedList<CircularDoublyLinkedList>("Categories");
	
	CircularDoublyLinkedList<Movie> action = new CircularDoublyLinkedList<Movie>("Action");
	CircularDoublyLinkedList<Movie> adventure = new CircularDoublyLinkedList<Movie>("Adventure");
	CircularDoublyLinkedList<Movie> animation = new CircularDoublyLinkedList<Movie>("Animation");
	CircularDoublyLinkedList<Movie> biography = new CircularDoublyLinkedList<Movie>("Biography");
	CircularDoublyLinkedList<Movie> comedy = new CircularDoublyLinkedList<Movie>("Comedy");
	CircularDoublyLinkedList<Movie> crime = new CircularDoublyLinkedList<Movie>("Crime");
	CircularDoublyLinkedList<Movie> drama = new CircularDoublyLinkedList<Movie>("Drama");
	CircularDoublyLinkedList<Movie> family = new CircularDoublyLinkedList<Movie>("Family");
	CircularDoublyLinkedList<Movie> fantasy = new CircularDoublyLinkedList<Movie>("Fantasy");
	CircularDoublyLinkedList<Movie> history = new CircularDoublyLinkedList<Movie>("History");
	CircularDoublyLinkedList<Movie> horror = new CircularDoublyLinkedList<Movie>("Horror");
	CircularDoublyLinkedList<Movie> music = new CircularDoublyLinkedList<Movie>("Music");
	CircularDoublyLinkedList<Movie> mystery = new CircularDoublyLinkedList<Movie>("Mystery");
	CircularDoublyLinkedList<Movie> romance = new CircularDoublyLinkedList<Movie>("Romance");
	CircularDoublyLinkedList<Movie> scifi = new CircularDoublyLinkedList<Movie>("Science Fiction");
	CircularDoublyLinkedList<Movie> suspense = new CircularDoublyLinkedList<Movie>("Suspense");
	CircularDoublyLinkedList<Movie> thriller = new CircularDoublyLinkedList<Movie>("Thriller");
	CircularDoublyLinkedList<Movie> war = new CircularDoublyLinkedList<Movie>("War");
	
	ArrayList<Movie> all = new ArrayList<Movie>();
	
	public Netflix() {
		this.categories.addLast(action);
		this.categories.addLast(adventure);
		this.categories.addLast(animation);
		this.categories.addLast(biography);
		this.categories.addLast(comedy);
		this.categories.addLast(crime);
		this.categories.addLast(drama);
		this.categories.addLast(family);
		this.categories.addLast(fantasy);
		this.categories.addLast(history);
		this.categories.addLast(horror);
		this.categories.addLast(music);
		this.categories.addLast(mystery);
		this.categories.addLast(romance);
		this.categories.addLast(scifi);
		this.categories.addLast(suspense);
		this.categories.addLast(thriller);
		this.categories.addLast(war);
						
	}
}
