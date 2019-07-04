package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import model.Movie;

public class MovieController {
    Scanner sc;
    ArrayList<String> dateList;
    ArrayList<String> movies;
    ArrayList<String> time;
    Map<String, Map<String, boolean[][]>> movieInfo;
    Calendar cal = Calendar.getInstance();
    ArrayList<String> storeSeat = new ArrayList<>();
    Iterator<Integer> iteratorInt;
    Iterator<String> iteratorStr;
    // Map<Integer, ArrayList<String>> result = new HashMap<>();
    // ArrayList<String> resultValue;
    ArrayList<Movie> resultValue2;
    HashMap<String, boolean[][]> timeSeat;
    int firstNum = 20190000;

    public void initField() {

        // m.setMovieId(20190001);
        resultValue2 = new ArrayList<>();
        movies = new ArrayList<>();
        movies.add("어벤져스");
        movies.add("알라딘");
        movies.add("토이스토리4");
        movies.add("맨 인 블랙");
        movies.add("엑스맨");

        dateList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("M월 d일");
            dateList.add(sdf.format(cal.getTime()));
            cal.add(Calendar.DATE, 1);
        }

        time = new ArrayList<>();
        time.add("12:00");
        time.add("14:20");
        time.add("16:20");
        time.add("18:00");
        time.add("20:15");

        movieInfo = new HashMap<String, Map<String, boolean[][]>>();
        for (String s : movies) {
            timeSeat = new HashMap<String, boolean[][]>();
            for (String date : dateList) {
                for (String time : time) {
                    timeSeat.put(date + " " + time, new boolean[3][4]);
                }
            }
            movieInfo.put(s, timeSeat);
        }
    }

    // 실행 메소드
    public void init() {
        Scanner scanner = new Scanner(System.in);
        initField();
        showMenu(scanner); 
    }

    // 메인 메뉴 메소드
    // 1. 예약 하기 2. 예약 정보 3. 종료
    private void showMenu(Scanner scanner) {
        boolean run = true;
        while (run) {
            System.out.println("=================영화관==================");
            System.out.println("1. 예매 하기 2. 예매 취소 3. 예매 내역 조회 4. 종료 ");
            int mainKey = Integer.parseInt(scanner.nextLine());

            switch (mainKey) {
            case 1:
                // 1번 예약하기
                bookingMovie();
                break;
            case 2:
                // 2번 예매 취소
                cancelMovie();
                break; 
            case 3:
                // 3번 예매 내역 조회
                bookingReview();
                break;
            case 4:
                System.out.println("종료합니다!");
                run = false;
                break;
            default:
                System.out.println("다시 입력해주세요.");
                break;

            }
        }
    }

    private void bookingReview() {
        for (Movie m : resultValue2) {
            // replace(str1, str2) --> 실행한 string 내에서 str1을 찾으면 str2로 내용을 바꿔라!
            m.setMoviesSeat(m.getMoviesSeat().trim());
            System.out.println(m);
        }
    }

    private void cancelMovie() {
        if (resultValue2.isEmpty()) {
            System.out.println("취소할 내역이 없습니다. 예매를 먼저 해주세요.");
            return;
        }

        for (Movie m : resultValue2) {
            m.setMoviesSeat(m.getMoviesSeat().trim());
            System.out.println(m);
        }

        System.out.print("삭제하실 movieId를 입력해주세요(뒤로가기는 6번)  >>");
        int mId = sc.nextInt();

        if (mId == 6) {
            return;
        } 

        for (int i = 0; i < resultValue2.size(); i++) {
            if (mId == resultValue2.get(i).getMovieId()) {
                String tempMovieTitle = resultValue2.get(i).getMoviesTitle();
                String tempMovieDate = resultValue2.get(i).getMoviesDate();
                String tempMovieTime = resultValue2.get(i).getMoviesTime();
                String tempMovieSeat = resultValue2.get(i).getMoviesSeat();

                String str = tempMovieSeat;
                String[] a = str.split(" ");
                char[] tempRow = new char[a.length];
                int[] intRow = new int[a.length];
                int[] tempCol = new int[a.length];
                
                for(int l=0; l<a.length; l++) {
                    tempRow[l] = a[l].charAt(0);
                    tempCol[l] = Integer.parseInt(a[l].substring(1));
                }
                
                for(int j=0; j<tempRow.length; j++) {
                    if(tempRow[j] == 'A') {
                        intRow[j] = 1;
                    } else if(tempRow[j] == 'B') {
                        intRow[j] = 2;
                    } else if(tempRow[j] == 'C') {
                        intRow[j] = 3;
                    }
                }
                
                String tempDateandTime = tempMovieDate + " " + tempMovieTime;
                System.out.println("\n======삭제된 좌석==========");
                boolean[][] tempseat = movieInfo.get(tempMovieTitle).get(tempDateandTime);
                
                for (int j = 0; j < intRow.length; j++) {
                    for (int k = 0; k < tempCol.length; k++) {
                        tempseat[intRow[j]-1][tempCol[k]-1] = false;//선택한 무비아이디 좌석 삭제
                    }
                }

                for (int j = 0; j < tempseat.length; j++) {
                    for (int k = 0; k < tempseat[j].length; k++) {
                        if (tempseat[j][k] == false) {// 좌석이 비어있으면
                            System.out.print("□");
                        } else {
                            System.out.print("■");
                        }
                    }
                    System.out.println();
                }
                resultValue2.remove(i);//리스트에서 삭제
                System.out.println("=================삭제가 완료되었습니다==================");
                for (Movie m : resultValue2) {
                    m.setMoviesSeat(m.getMoviesSeat().trim());
                    System.out.println(m);
                }
                break;
            } 
//            else {
//                if(i == resultValue2.size()-1) {
//                    System.out.println("해당번호로 예약된 내역이 없습니다. 다시입력해주세요.");
//                    cancelMovie();
//                }
//            }
        }

    }

    // 처음 화면: 상영 시간표
    // 영화이름: 미리 10개정도 ArrayList로 저장 -> 유저 화면에서는 랜덤으로 5개만 출력 (1~5선택)
    // 날짜 출력: Calendar사용 해서 당일 ~ 3정도 --> ex) 오늘 20 20~22일까지

    // 시간 출력: 시간 리스트로 5개저장 5개 불러오기. (1~5번 선택) 12:00 14:20 16:20 18:00 20:15
    // 인원 선택: 인원수 물어보고 int로 출력값 받기.
    // 좌석 선택: parkingLot 처럼 처음부터 다 빈칸, 좌석은 boolean으로 true --> 선택 ■ // false --> 빈칸 □
    // 예매확인: 지금까지 선택한 정보들 쭉 애뿌게 나오게 하기. 선택하신 정보 맞음? -> 1) 예2) 아니요(처음 메인 메뉴로돌아감)
    // 결제: 예 누르면 바로 예매 성공 -> 강제로 메인메뉴로.
    private void bookingMovie() {
        // 랜덤값 포기... 그냥 5개로!!!
        firstNum++;

        for (int i = 0; i < movies.size(); i++) {// 결국 랜덤 포기하구 그냥 5가지 출력.. (랜덤하면 메인메뉴갔다가 다시 예매할때 영화제목들 달라지는 것때문에...ㅋㅋ)
            System.out.println((i + 1) + "." + movies.get(i));
        }
        sc = new Scanner(System.in);
        System.out.print("번호를 입력하여 영화를 선택하세요 (6번을 누르면 뒤로가기) >>");
        int movieSelect = sc.nextInt();
        if (movieSelect == 6) {// 6번누르면 메소드 종료해서 메인메뉴로 돌아가게.
            return;
        }
        String movie = movies.get(movieSelect - 1);
        // resultValue.add("영화 제목: "+movie);

        System.out.println();
        for (int i = 0; i < dateList.size(); i++) {
            System.out.println((i + 1) + "." + dateList.get(i));
        }

        System.out.print("번호를 입력하여 날짜를 선택하세요 >>");
        int dateSelect = sc.nextInt() - 1;
        String selectedDate = dateList.get(dateSelect);

        // 시간 5가지: 12:00 14:20 16:20 18:00 20:15
        System.out.println();
        System.out.println("===시간선택===");

        for (int i = 0; i < time.size(); i++) {// 시간 다섯가지 출력
            System.out.println((i + 1) + "." + time.get(i));
        }

        System.out.print("번호를 입력하여 시간을 선택하세요 >>");
        int timeSelect = sc.nextInt() - 1;
        String selectedTime = time.get(timeSelect);

        System.out.println("\n===인원 수 입력===");
        System.out.print("몇개의 좌석을 예매하시겠습니까? >>");

        int peopleNum = sc.nextInt();
        String strSeat = "";
        for (int i = 0; i < peopleNum; i++) {
            System.out.println();
            System.out.println((i + 1) + "번째 좌석 선택");
            System.out.println("===좌석 선택=== ■:좌석있음 □:좌석없음");
            switch (movie) {
            case "어벤져스":
                strSeat += selectSeat(movieInfo.get("어벤져스").get(selectedDate + " " + selectedTime));
                break;
            case "알라딘":
                strSeat += selectSeat(movieInfo.get("알라딘").get(selectedDate + " " + selectedTime));
                break;
            case "토이스토리4":
                strSeat += selectSeat(movieInfo.get("토이스토리4").get(selectedDate + " " + selectedTime));
                break;
            case "맨 인 블랙":
                strSeat += selectSeat(movieInfo.get("맨 인 블랙").get(selectedDate + " " + selectedTime));
                break;
            case "엑스맨":
                strSeat += selectSeat(movieInfo.get("엑스맨").get(selectedDate + " " + selectedTime));
                break;
            default:
                System.out.println("다시 선택해주세요.");
                break;
            }
        }
        resultValue2.add(new Movie(firstNum, movie, selectedDate, selectedTime, strSeat));
    }

    private String selectSeat(boolean[][] seat) {
        String strSeat = "";
        char ch = 'A';
        for (int j = 0; j < seat.length; j++) {
            System.out.print((char) (ch + j) + ">");
            for (int k = 0; k < seat[j].length; k++) {
                if (seat[j][k] == false) {// 좌석이 비어있으면
                    System.out.print("□");
                } else {
                    System.out.print("■");
                }
            }
            System.out.println();
        }
        System.out.print("알파벳을 입력하여 행을 선택하세요>>");

        int row =0;
        String al = sc.next().toUpperCase();
        while(!(al.equals("A")||al.equals("B")||al.equals("C"))) {
            System.out.println(al);
            System.out.println("다시 입력해주세요.");
            al = sc.next().toUpperCase();
        }
        if (al.equals("A")) {
            row = 1;
            al = "A";
            //break;
        } else if (al.equals("B")) {
            row = 2;
            al = "B";
            //break;
        } else if (al.equals("C")) {
            row = 3;
            al = "C";
            //break;
        } 

        System.out.println();
        System.out.println("1234");
        System.out.println("↓↓↓↓");
        for (int j = 0; j < seat.length; j++) {
            for (int k = 0; k < seat[j].length; k++) {
                if (seat[j][k] == false) {// 좌석이 비어있으면
                    System.out.print("□");
                } else {
                    System.out.print("■");
                }
            }
            System.out.println();
        }
        System.out.print("번호를 눌러 열을 선택하세요>>");
        int column = sc.nextInt();
        while(column != 1 && column !=2 && column !=3 && column !=4) {
            System.out.println("다시 입력해주세요.");
            System.out.print("번호를 눌러 열을 선택하세요>>");
            column = sc.nextInt();
            if(column == 1) {
                column = 1;
                break;
            } else if(column == 2) {
                column = 2;
                break;
            } else if(column == 3) {
                column = 3;
                break;
            } else if(column == 4) {
                column = 4;
                break;
            }
        }
        
        
        if (seat[row - 1][column - 1] == false) {
            seat[row - 1][column - 1] = true;
            System.out.println("\n선택된 좌석");
            for (int j = 0; j < seat.length; j++) {
                for (int k = 0; k < seat[j].length; k++) {
                    if (seat[j][k] == false) {// 좌석이 비어있으면
                        System.out.print("□");
                    } else {
                        System.out.print("■");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("이미 선택된 좌석입니다. 다시 골라주세요.");
            selectSeat(seat);// 다시 선택할 수 있게 재귀
        }

        strSeat = al + "" + column + " ";
        return strSeat;
    }

}