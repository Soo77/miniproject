package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class MovieController {
    Scanner sc = new Scanner(System.in);
    Calendar cal = Calendar.getInstance();

    
    // 실행 메소드
    public void init() {
        Scanner scanner = new Scanner(System.in);
        showMenu(scanner);
    }

    // 메인 메뉴 메소드
    // 1. 예약 하기 2. 예약 정보 3. 종료
    private void showMenu(Scanner scanner) {
        boolean run = true;
        while(run) {
            System.out.println("=================영화관==================");
            System.out.println("1. 예매 하기 2. 예매 취소 3. 예매 내역 조회 4. 종료 ");
            int mainKey = Integer.parseInt(scanner.nextLine());
            switch(mainKey) {
            case 1:
                // 1번 예약하기
                bookingMovie();
                System.out.println();
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
        
    }

    private void cancelMovie() {
        
    }

    // 처음 화면: 상영 시간표 
    // 영화이름: 미리 10개정도 ArrayList로 저장 -> 유저 화면에서는 랜덤으로 5개만 출력 (1~5선택)
    // 날짜 출력: Calendar사용 해서 당일 ~ 3정도 --> ex) 오늘 20 20~22일까지
    
    // 시간 출력: 시간 리스트로 5개저장 5개 불러오기. (1~5번 선택)
    // 인원 선택: 인원수 물어보고 int로 출력값 받기.
    // 좌석 선택: parkingLot 처럼 처음부터 다 빈칸, 좌석은 boolean으로 true --> 선택  ■ // false --> 빈칸 □
    // 예매확인: 지금까지 선택한 정보들 쭉 애뿌게 나오게 하기. 선택하신 정보 맞음? -> 1) 예2) 아니요(처음 메인 메뉴로돌아감)
    // 결제:    예 누르면 바로 예매 성공 -> 강제로 메인메뉴로.
    private void bookingMovie() {

        ArrayList<String> Movies = new ArrayList<>();
        Movies.add("어벤져스");
        Movies.add("알라딘");
        Movies.add("토이스토리4");
        Movies.add("맨 인 블랙");
        Movies.add("엑스맨");
        Movies.add("이웃집 토토로");
        Movies.add("로켓맨");
        Movies.add("라라랜드");
        Movies.add("걸캅스");
        Movies.add("악인전");
        
        int[] rand = new int[5];// 랜덤값 0~9중에 다섯가지 받아서 중복값 제거.
        for(int i=0; i<rand.length; i++) {
            rand[i] = (int)(Math.random()*10);
            for(int j=0; j<i; j++) {
                if(rand[i] == rand [j]) {
                    i--;
                }
            }
        }
        
        for(int i=0; i<rand.length; i++) {// 0~9중에 중복제거한 다섯가지 값을 인덱스로 넘겨서 Movies 에서 영화 5가지 출력.
            System.out.println((i+1)+ "." + Movies.get(rand[i]));
        }
        System.out.print("\n번호를 입력하여 영화를 선택하세요 >>");
        int movieSelect = sc.nextInt();
        System.out.println();
        
        
        System.out.println("===날짜선택===");
        int month = cal.get (cal.MONTH) + 1;
        int date = cal.get (cal.DATE);

        for(int i=0; i<3; i++) {//오늘날짜, 내일날짜, 모레날짜.  3개 출력.
            System.out.println((i+1)+"."+month+"월 " + (date+i) + "일");
        }
        System.out.print("\n번호를 입력하여 날짜를 선택하세요 >>");
        int dateSelect = sc.nextInt();
        System.out.println();
        
        
        System.out.println("===시간선택===");
        
        
    }
    
}
