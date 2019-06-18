package model;

import java.util.List;

public class MoviesN {

	private List<String> movieName;

	
	public MoviesN(List<String> movieName) {
		super();
		this.movieName = movieName;
	}

	public List<String> getMovieName() {
		return movieName;
	}

	public void setMovieName(List<String> movieName) {
		this.movieName = movieName;
		movieName.add("AVENGERS ENDGAME");
		movieName.add("GODZILLA KING OF THE MONSTER");
		movieName.add("ALADDIN");
		movieName.add("THE LION KING");
		movieName.add("TOY STORY 4");
	}
	
}
