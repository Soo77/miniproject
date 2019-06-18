package view;

import java.util.ArrayList;
import java.util.List;

import model.Movie;
import model.MovieT;
import model.MoviesN;

public class MovieDemo {

	public static void main(String[] args) {

		List<MoviesN> mName = new ArrayList<>();
		List<MovieT> mTime = new ArrayList<>();
		
		List<Movie> mList = new ArrayList<>();
		
		mList.add(new Movie(mName, mTime));
	}

}
