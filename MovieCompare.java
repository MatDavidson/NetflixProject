package Netflix;

import java.util.Comparator;

public class MovieCompare implements Comparator<Movie>{
	public int compare(Movie o1, Movie o2) {
		String m1 = o1.getTitle();
		String m2 = o2.getTitle();
		return m1.compareTo(m2);
	}

}

