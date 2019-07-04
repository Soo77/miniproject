package model;

import java.util.Arrays;

public class Movie {
    //관리번호
    private int movieId;
    // 영화제목
    private String moviesTitle;
    // 날짜
    private String moviesDate;
    // 영화시간
    private String moviesTime;
    // 영화좌석
    private String moviesSeat;

    // 인원수
    private int userNum;
    // 예약정보
    private String loadInfo;

//    @Override
//    public String toString() {
//        return "Movie [moviesTitle=" + moviesTitle + ", moviesDate=" + moviesDate + ", moviesTime=" + moviesTime
//                + ", moviesSeat=" + moviesSeat + "]";
//    }
    public Movie() {
        this.movieId = 0;
        this.moviesTitle = "";
        this.moviesDate = "";
        this.moviesTime = "";
        this.moviesSeat = "";
    }
    @Override
    public String toString() {
        return "movieId:" + movieId + " [moviesTitle=" + moviesTitle + ", moviesDate=" + moviesDate
                + ", moviesTime=" + moviesTime + ", moviesSeat=" + moviesSeat + "]";
    }
    public Movie(int movieId, String movie, String selectedDate, String selectedTime, String strSeat) {
        this.movieId = movieId;
        this.moviesTitle = movie;
        this.moviesDate = selectedDate;
        this.moviesTime = selectedTime;
        this.moviesSeat = strSeat;
    }

    public String getMoviesTitle() {
        return moviesTitle;
    }

    public void setMoviesTitle(String moviesTitle) {
        this.moviesTitle = moviesTitle;
    }

    public String getMoviesDate() {
        return moviesDate;
    }

    public void setMoviesDate(String moviesDate) {
        this.moviesDate = moviesDate;
    }

    public String getMoviesTime() {
        return moviesTime;
    }

    public void setMoviesTime(String moviesTime) {
        this.moviesTime = moviesTime;
    }


    public String getMoviesSeat() {
        return moviesSeat;
    }

    public void setMoviesSeat(String moviesSeat) {
        this.moviesSeat = moviesSeat;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public String getBookingHis() {
        return loadInfo;
    }

    public void setBookingHis(String bookingHis) {
        this.loadInfo = bookingHis;
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }



}
