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
	CircularDoublyLinkedList<Movie> spo = new CircularDoublyLinkedList<Movie>("Sports");
	CircularDoublyLinkedList<Movie> sus = new CircularDoublyLinkedList<Movie>("Suspense");
	CircularDoublyLinkedList<Movie> thr = new CircularDoublyLinkedList<Movie>("Thriller");
	CircularDoublyLinkedList<Movie> war = new CircularDoublyLinkedList<Movie>("War");
	CircularDoublyLinkedList<Movie> wes = new CircularDoublyLinkedList<Movie>("Western");
	
	ArrayList<Movie> all = new ArrayList<Movie>();
	
	//Constructor that creates a Netflix object and initializes its lists. It finishes by building the all list.
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
		this.categories.addLast(spo);
		this.categories.addLast(sus);
		this.categories.addLast(thr);
		this.categories.addLast(war);
		this.categories.addLast(wes);
		addAll();				
	}
	
	//Builds the master list of movies as well as sorts the movies into their proper categories.
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
				catSort(m);
			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//This method extracts the genre string from a movie object and splits it into tokens. It then checks them against
	//	a switch and adds the movie to each category listed
	public void catSort(Movie m) {
		String[] genres = m.getGenre().split(" ");
		for (int i = 0; i < genres.length; i++) {
			switch (genres[i]) {

			case "act":
				act.addLast(m);
				continue;

			case "adv":
				adv.addLast(m);
				continue;

			case "ani":
				ani.addLast(m);
				continue;

			case "bio":
				bio.addLast(m);
				continue;

			case "com":
				com.addLast(m);
				continue;

			case "cri":
				cri.addLast(m);
				continue;

			case "dra":
				dra.addLast(m);
				continue;

			case "fam":
				fam.addLast(m);
				continue;

			case "fan":
				fan.addLast(m);
				continue;
				
			case "his":
				his.addLast(m);
				continue;
				
			case "hor":
				hor.addLast(m);
				continue;
				
			case "mus":
				mus.addLast(m);
				continue;
				
			case "mys":
				mys.addLast(m);
				continue;
				
			case "rom":
				rom.addLast(m);
				continue;
				
			case "sci":
				sci.addLast(m);
				continue;
				
			case "spo":
				spo.addLast(m);
				continue;
				
			case "sus":
				sus.addLast(m);
				continue;
				
			case "thr":
				thr.addLast(m);
				continue;
				
			case "war":
				war.addLast(m);
				continue;
				
			case "wes":
				wes.addLast(m);
				continue;
				
//			case "":
//				.addLast(m);
//				continue;
			}
		}
	}
	
	
	//This method iterates over list1 and determines what movies it has in common with list2 while adding those movies to a result list
	public CircularDoublyLinkedList<Movie> commonMovies(CircularDoublyLinkedList<Movie> list1, CircularDoublyLinkedList<Movie> list2){
		CircularDoublyLinkedList<Movie> result = new CircularDoublyLinkedList<Movie>("Result");
		Node<Movie> list1Ptr = list1.getTail();
		Node<Movie> list2Ptr = list2.getHead();
		Node<Movie> list2Start = list2Ptr;		//Holds the place of the last movie in list2 added to result
		int l2SCount = 0;
		int addCount = 0;						//These two integers help determine the position of our list2 placeholder 
		String t1 = "";
		String t2 = "";							//These strings hold our movie titles to be compared 
		
		//Iterate over list1, storing the title of the movie in t1. This requires that all category lists are sorted alphabetically.
		for(int i = 0; i < list1.getSize(); i++) {
			list1Ptr = list1Ptr.getNext();
			t1 = list1Ptr.getElement().getTitle();
			
			//Set the pointer for list2 as the list2 placeholder and the title of that movie in t2
			list2Ptr = list2Start;	
			t2 = list2Ptr.getElement().getTitle();
			
			//Iterate over list2 starting from the list2 placeholder
			for(int j = l2SCount; j < list2.getSize(); j++){
				//Compare the titles of the movies
				if(t1.compareTo(t2) == 0) { 				//Match case
					result.addLast(list1Ptr.getElement());	//Add the movie to the result list
					l2SCount += addCount;					//Add the value of addCount to l2Start to keep up with our place
					list2Start = list2Ptr;					//Update our list2 placeholder
					addCount = 0;							//Reset addCount
					break;									//Exit the inner loop
				}
				else if(t1.compareTo(t2) > 0) {				//No match, but t1 comes before t2
					addCount++;								//Increment addCount
					list2Ptr = list2Ptr.getNext();			//Move to the next movie in list2
					t2 = list2Ptr.getElement().getTitle();	//Update t2
				}
				else {										//Once the value of t1 becomes greater than t2 (alphabetically), exit the loop
					break;
				}
			}
		}
		return result;
	}
	
	public Movie searchAll(String s) {
		
	}
	
	@SuppressWarnings("rawtypes")
	public CircularDoublyLinkedList<CircularDoublyLinkedList> getCategories() {
		return categories;
	}
}
