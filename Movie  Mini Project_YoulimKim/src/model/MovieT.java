package model;

import java.util.List;

public class MovieT {

	private List<String> movieTimes;
	
	
	public MovieT(List<String> movieTimes) {
		super();
		this.movieTimes = movieTimes;
	}

	public List<String> getMovieTimes() {
		return movieTimes;
	}

	public void setMovieTimes(List<String> movieTimes) {
		this.movieTimes = movieTimes;
		movieTimes.add("9:00 AM");
		movieTimes.add("9:30 AM");
		movieTimes.add("10:00 AM");
		movieTimes.add("11:30 AM");
		movieTimes.add("6:00 PM");
		movieTimes.add("8:00 PM");
		movieTimes.add("9:30 PM");
		movieTimes.add("10:00 PM");
		movieTimes.add("11:30 PM");
	}
	
}
