package Netflix;

public class NetflixTester {

	public static void main(String[] args) {
		Netflix netflix = new Netflix();
		
		System.out.print(netflix.categories.display());
		System.out.println("\n****************************");
		
		for(Movie m: netflix.all) {
			
			System.out.println(m.toString());
		}
	}

}
