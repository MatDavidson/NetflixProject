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
				
			case "wesr":
				wes.addLast(m);
				continue;
				
//			case "":
//				.addLast(m);
//				continue;
			}
		}
	}
	
	public CircularDoublyLinkedList<Movie> commonMovies(CircularDoublyLinkedList<Movie> list1, CircularDoublyLinkedList<Movie> list2){
		CircularDoublyLinkedList<Movie> result = new CircularDoublyLinkedList<Movie>("Result");
		Node<Movie> list1Ptr = list1.getTail();
		Node<Movie> list2Ptr = list2.getHead();
		Node<Movie> list2Start = list2Ptr;
		int l2SCount = 0;
		int addCount = 0;
		String t1 = "";
		String t2 = "";
		Movie m1, m2;
		
		for(int i = 0; i < list1.getSize(); i++) {
			list1Ptr = list1Ptr.getNext();
			t1 = list1Ptr.getElement().getTitle();
			list2Ptr = list2Start;
			t2 = list2Ptr.getElement().getTitle();
			for(int j = l2SCount; j < list2.getSize(); j++){		
				if(t1.compareTo(t2) == 0) {
					result.addLast(list1Ptr.getElement());
					l2SCount += addCount;
					list2Start = list2Ptr;
					addCount = 0;
					break;
				}
				else if(t1.compareTo(t2) > 0) {
					addCount++;
					list2Ptr = list2Ptr.getNext();
					t2 = list2Ptr.getElement().getTitle();
				}
				else {
					break;
				}
			}
			
//			while(title1.charAt(0) < list2Ptr.getElement().getTitle().charAt(0) && list2Ptr.getNext() != list2.getHead()) {
//				if(title1.equals(list2Ptr.getElement().getTitle())){
//					result.addLast(list1Ptr.getElement());
//					list2Start = list2Ptr;
//					break;
//				}
//				list2Ptr = list2Ptr.getNext();
//			}
		}
		
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public CircularDoublyLinkedList<CircularDoublyLinkedList> getCategories() {
		return categories;
	}
}
