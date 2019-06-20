package model;

import java.util.Arrays;

public class Movie {
    // 영화제목
    private String moviesTitle;
    // 영화시간 
    private String moviesTime;
    // 영화좌석
    private boolean[] moviesSeat;
    // 인원수
    private int userNum;
    // 예약정보
    private String loadInfo;
    
    
    public String getMoviesTitle() {
        return moviesTitle;
    }
    public void setMoviesTitle(String moviesTitle) {
        this.moviesTitle = moviesTitle;
    }
    public String getMoviesTime() {
        return moviesTime;
    }
    public void setMoviesTime(String moviesTime) {
        this.moviesTime = moviesTime;
    }
    public boolean[] getMoviesSeat() {
        return moviesSeat;
    }
    public void setMoviesSeat(boolean[] moviesSeat) {
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((loadInfo == null) ? 0 : loadInfo.hashCode());
        result = prime * result + Arrays.hashCode(moviesSeat);
        result = prime * result + ((moviesTime == null) ? 0 : moviesTime.hashCode());
        result = prime * result + ((moviesTitle == null) ? 0 : moviesTitle.hashCode());
        result = prime * result + userNum;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (loadInfo == null) {
            if (other.loadInfo != null)
                return false;
        } else if (!loadInfo.equals(other.loadInfo))
            return false;
        if (!Arrays.equals(moviesSeat, other.moviesSeat))
            return false;
        if (moviesTime == null) {
            if (other.moviesTime != null)
                return false;
        } else if (!moviesTime.equals(other.moviesTime))
            return false;
        if (moviesTitle == null) {
            if (other.moviesTitle != null)
                return false;
        } else if (!moviesTitle.equals(other.moviesTitle))
            return false;
        if (userNum != other.userNum)
            return false;
        return true;
    }
    
    
}
