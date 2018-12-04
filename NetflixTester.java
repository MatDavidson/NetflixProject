package Netflix;

import java.util.ArrayList;
import java.util.Random;

public class NetflixTester {

	public static Netflix netflix = new Netflix();
	public static ArrayList<Movie> all = new ArrayList<Movie>();
	
	public static void main(String[] args) {
		netflix.getAll().clear();
		netflix.getCategories().getHead().getElement().clear();
		netflix.getCategories().getHead().getNext().getElement().clear();
		netflix.getCategories().getHead().getNext().getNext().getElement().clear();
		
		generateMovies(50000);
		System.out.print(printResult());
		
//		System.out.print(netflix.categories.display());
//		System.out.println("\n****************************");
//		
//		for(Movie m: netflix.all) {
//			
//			System.out.println(m.toString());
//		}
//		
//		@SuppressWarnings("rawtypes")
//		Node<CircularDoublyLinkedList> ptr = netflix.getCategories().getHead();
//		for(int i = 0; i < netflix.categories.getSize(); i ++) {
//			if(ptr.getElement().getSize() > 0)
//				System.out.print("\n\t" + ptr.getElement().getName() + ": " + ptr.getElement().getSize());
//			ptr = ptr.getNext();
//		}
//		
//		@SuppressWarnings("unchecked")
//		CircularDoublyLinkedList<Movie> act = netflix.getCategories().getHead().getElement();
//		@SuppressWarnings("unchecked")
//		CircularDoublyLinkedList<Movie> adv = netflix.getCategories().getHead().getNext().getElement();
//		
//		System.out.print(act.display());
//		System.out.print(adv.display());
//		
//		CircularDoublyLinkedList<Movie> res = netflix.commonMovies(act, adv);
//		System.out.print(res.display());
//		
//		System.out.print(netflix.com.display());
//		System.out.print(netflix.dra.display());
//		
//		CircularDoublyLinkedList<Movie> res2 = netflix.commonMovies(netflix.com, netflix.dra);
//		System.out.print(res2.display());
//		
//		CircularDoublyLinkedList<Movie> res3 = netflix.commonMovies(netflix.com, adv);
//		System.out.print(res3.display());
//		
//		System.out.print("\n\n********************************************");
//		for(Movie m: netflix.searchAll("hon")) {
//			System.out.print("\n\t" + m.toString());
//		}
//		
//		System.out.print(netflix.mus.display());
//		
//		CircularDoublyLinkedList<Movie> res4 = netflix.commonMovies(netflix.com, netflix.spo);
//		System.out.print(res4.display());
	}
	
	public static void generateMovies(int max) {
		int total = (int)(Math.random() * max);
		String title = "";
		StringBuilder genre = new StringBuilder();
		Movie m;
		
		for(int i = 0; i < total; i++) {
			title = randomString();
			genre.append("act");
			
			if(i % 2 == 0)
				genre.append(" adv");
			if(i % 3 == 0)
				genre.append(" ani");
			m = new Movie(title, "", genre.toString(), 0, 0);
			
			netflix.all.add(m);
			genre.delete(0, genre.length());
			
//			System.out.print("\n\t" + m.toString());
		}
		
		netflix.all.sort(new MovieCompare());
		
		for(int j = 0; j < netflix.all.size(); j++) {
			netflix.catSort(netflix.all.get(j));
		}
		
	}
	
	public static String randomString() {
		StringBuilder result = new StringBuilder();
		Random r = new Random();
		char c;
		
		for(int i = 0; i < r.nextInt(26); i++) {
			c = (char)(r.nextInt(26) + 'a');
			result.append(c);
		}
		
		return result.toString();
	}
	
	public static String printResult() {
		StringBuilder result = new StringBuilder();
		result.append("\tNumber of movies:");
		result.append("\n\t\tAct: " + netflix.getCategories().getHead().getElement().getSize());
		result.append("\n\t\tAdv: " + netflix.getCategories().getHead().getNext().getElement().getSize());
		result.append("\n\t\tAni: " + netflix.getCategories().getHead().getNext().getNext().getElement().getSize());
		
		result.append("\n" + searchCompare(netflix.getCategories().getHead().getElement(), netflix.getCategories().getHead().getNext().getElement()));
		result.append("\n" + searchCompare(netflix.getCategories().getHead().getElement(), netflix.getCategories().getHead().getNext().getNext().getElement()));
		result.append("\n" + searchCompare(netflix.getCategories().getHead().getNext().getElement(), netflix.getCategories().getHead().getNext().getNext().getElement()));
		return result.toString();
	}
	
	public static String searchCompare(CircularDoublyLinkedList<Movie> l1, CircularDoublyLinkedList<Movie> l2) {
		StringBuilder result = new StringBuilder();
		CircularDoublyLinkedList<Movie> movies = new CircularDoublyLinkedList<Movie>("");
		long t1;
		long t2;
		
		result.append("\n\tComparison of " + l1.getName() + " and " + l2.getName());
		t1 = System.nanoTime();
		movies = netflix.linearCommonMovies(l1, l2);
		t2 = System.nanoTime();
		
		result.append("\n\t\tLinear Search Time: " + String.valueOf((int)(t2 - t1)));
		result.append("\n\t\tNumber of entries:  " + String.valueOf(movies.getSize()));
		
		t1 = System.nanoTime();
		movies = netflix.commonMovies(l1, l2);
		t2 = System.nanoTime();
		
		result.append("\n\t\tStartpoint Search Time: " + String.valueOf((int)(t2 - t1)));
		result.append("\n\t\tNumber of entries:  " + String.valueOf(movies.getSize()));
		
		return result.toString();
	}

}
