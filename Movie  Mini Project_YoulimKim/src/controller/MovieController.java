package controller;

import java.util.Scanner;

public class MovieController {

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
            System.out.println("극장이름");
            System.out.println("1. 예매 하기 2. 예매 취소 3. 예매 내역 조회 4. 종료 ");
            int mainKey = Integer.parseInt(scanner.nextLine());
            switch(mainKey) {
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

    }
    
}
