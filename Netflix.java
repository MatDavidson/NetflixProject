package Netflix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Netflix {
	@SuppressWarnings("rawtypes") CircularDoublyLinkedList<CircularDoublyLinkedList> categories = new CircularDoublyLinkedList<CircularDoublyLinkedList>("Categories");
	
	CircularDoublyLinkedList<Movie> act = new CircularDoublyLinkedList<Movie>("Action");
	CircularDoublyLinkedList<Movie> adv = new CircularDoublyLinkedList<Movie>("Adventure");
	CircularDoublyLinkedList<Movie> ani = new CircularDoublyLinkedList<Movie>("Animation");
	CircularDoublyLinkedList<Movie> bio = new CircularDoublyLinkedList<Movie>("Biography");
	CircularDoublyLinkedList<Movie> com = new CircularDoublyLinkedList<Movie>("Comedy");
	CircularDoublyLinkedList<Movie> cri = new CircularDoublyLinkedList<Movie>("Crime");
	CircularDoublyLinkedList<Movie> dra = new CircularDoublyLinkedList<Movie>("Drama");
	CircularDoublyLinkedList<Movie> fam = new CircularDoublyLinkedList<Movie>("Family");
	CircularDoublyLinkedList<Movie> fan = new CircularDoublyLinkedList<Movie>("Fantasy");
	CircularDoublyLinkedList<Movie> his = new CircularDoublyLinkedList<Movie>("History");
	CircularDoublyLinkedList<Movie> hor = new CircularDoublyLinkedList<Movie>("Horror");
	CircularDoublyLinkedList<Movie> mus = new CircularDoublyLinkedList<Movie>("Music");
	CircularDoublyLinkedList<Movie> mys = new CircularDoublyLinkedList<Movie>("Mystery");
	CircularDoublyLinkedList<Movie> rom = new CircularDoublyLinkedList<Movie>("Romance");
	CircularDoublyLinkedList<Movie> sci = new CircularDoublyLinkedList<Movie>("Science Fiction");
	CircularDoublyLinkedList<Movie> sus = new CircularDoublyLinkedList<Movie>("Suspense");
	CircularDoublyLinkedList<Movie> thr = new CircularDoublyLinkedList<Movie>("Thriller");
	CircularDoublyLinkedList<Movie> war = new CircularDoublyLinkedList<Movie>("War");
	
	ArrayList<Movie> all = new ArrayList<Movie>();
	
	public Netflix() {
		this.categories.addLast(act);
		this.categories.addLast(adv);
		this.categories.addLast(ani);
		this.categories.addLast(bio);
		this.categories.addLast(com);
		this.categories.addLast(cri);
		this.categories.addLast(dra);
		this.categories.addLast(fam);
		this.categories.addLast(fan);
		this.categories.addLast(his);
		this.categories.addLast(hor);
		this.categories.addLast(mus);
		this.categories.addLast(mys);
		this.categories.addLast(rom);
		this.categories.addLast(sci);
		this.categories.addLast(sus);
		this.categories.addLast(thr);
		this.categories.addLast(war);
		addAll();				
	}
	
	private void addAll() {
		File file = new File("src\\Netflix\\movieList.txt");
		String title = "";
		String rating = "";
		String genre = "";
		int year, score;
		Movie m;
		
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				title = scan.nextLine();
				rating = scan.nextLine();
				genre = scan.nextLine();
				year = Integer.parseInt(scan.nextLine());
				score = Integer.parseInt(scan.nextLine());
				
				m = new Movie (title, rating, genre, year, score);
				all.add(m);
			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
