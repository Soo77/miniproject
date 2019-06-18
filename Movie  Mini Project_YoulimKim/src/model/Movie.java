package model;

import java.util.List;

public class Movie {

	private List<MoviesN> movieName;
	private List<MovieT> movieTime;
	
	public Movie(List<MoviesN> mName, List<MovieT> mTime) {
		super();
		this.movieName = mName;
		this.movieTime = mTime;
	}

	public List<MoviesN> getMovieName() {
		return movieName;
	}

	public void setMovieName(List<MoviesN> movieName) {
		this.movieName = movieName;
	}

	public List<MovieT> getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(List<MovieT> movieTime) {
		this.movieTime = movieTime;
	}
	
	
}
