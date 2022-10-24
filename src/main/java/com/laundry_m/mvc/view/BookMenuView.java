package com.laundry_m.mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.laundry_m.mvc.controller.BookController;
import com.laundry_m.mvc.controller.MetapayController;
import com.laundry_m.mvc.service.BookService;
import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.BookLine;

public class BookMenuView {
	private static Scanner sc = new Scanner(System.in);
	private static BookController bookController = new BookController();
	private static MetapayController metapayController = new MetapayController();
	
	/**
	 * 예약 폼 메뉴
	 * */
	public static void bookForm(Long laundryId) {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "세탁할 옷 갯수를 입력해주세요.");
				System.out.print("▶ ");
				int bookCount = Integer.parseInt(sc.nextLine());
				Long bookTotalFee = 0L;
				List<BookLine> bookLines = new ArrayList<BookLine>();
				for (int i = 1; i <= bookCount; i++) {
					System.out.println("\n" + i + "번째 옷의 종류를 입력해주세요.");
					System.out.println("[ 1. 상의/자켓 | 2. 하의 | 3. 스커트 | 4. 와이셔츠/남방 | 5. 티셔츠 | 6. 블라우스 | 7. 원피스 | 8. 스웨터/가디건 | 9. 봄가을점퍼/아웃도어 | 10. 코트"
							+ "\n  11. 가죽/모피의류 | 12. 겨울패딩/점퍼 | 13. 넥타이 | 14. 스카프/목도리 | 15. 이불/침구류 | 16. 커튼/카페트 | 17. 한복류 18. 모자 | 19. 가방/기타가죽제품 20. 운동화/스니커즈류 ]");
					System.out.print("▶ ");
					Long clothesId = (long) Integer.parseInt(sc.nextLine());
					System.out.println("\n" + i + "번째 옷의 재질을 입력해주세요.");
					System.out.println("[ 1. 면 | 2. 니트 | 3. 레이온 | 4. 데님 | 5. 실크/쉬폰 | 6. 린넨 | 7. 퍼 | 8. 앙고라 | 9. 가죽 ]");
					System.out.print("▶ ");
					Long fabricId = (long) Integer.parseInt(sc.nextLine());
					
					// 가격 계산 메소드
					int bookLineFee = 0;
					
					BookLine bookLine = BookLine.builder().clothesId(clothesId).fabricId(fabricId).bookLineFee(bookLineFee).build();
					bookLines.add(bookLine);
					
					// 총 가격에 위에서 구해온 가격 계산
					bookTotalFee += bookLineFee;
				}
				System.out.println("\n" + bookCount + "벌 세탁 가격: " + bookCount + "원");
				boolean pay = true;
				int bookMethodId = 0;
				while (pay) {
					System.out.println("\n결제 수단을 선택해주세요.");
					System.out.println("[ 1. 카드 | 2. 메타페이 | 3. 직접 결제 ]");
					System.out.print("▶ ");
					bookMethodId = Integer.parseInt(sc.nextLine());
					// 메타페이 가입자인지 검색
					if (bookMethodId == 2 && !metapayController.MetapayApplicable()) {
						System.out.println("메타페이 가입자가 아닙니다.\n다른 결제 수단을 선택해주세요.");
					} else {
						pay = false;
					}
				}
				
				System.out.println("\n참고 사항이 있다면 입력해주세요.");
				System.out.print("▶ ");
				String bookMemo = sc.nextLine();
				
				Book book = Book.builder().laundryId(laundryId)
						.bookCount(bookCount)
						.bookMemo(bookMemo)
						.bookMethodId(bookMethodId)
						.bookTotalFee(bookTotalFee)
						.bookLine(bookLines).build();
				
				bookController.updateBookComplete(bookTotalFee);
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	public static void searchBookByLaundryIdAndBookStateId() {
		System.out.println("검색할 예약 상태를 입력해주세요.");
		System.out.println("[ 1. 예약 확인 중 | 2. 수거 예정 | 3. 수거 중 | 4. 세탁 진행 중 | 5. 세탁 완료 | 6. 배달 예정 | 7. 배달 중 | 8. 배달 완료 | 9. 예약 거절 | 10. 정산 완료 ]");
		System.out.print("▶ ");
		Long bookStateId = (long)Integer.parseInt(sc.nextLine());
		bookController.searchBookByLaundryId(bookStateId, bookStateId);
	}
	
	public static void updateBookState() {
		try {
			System.out.println("업데이트할 예약 번호를 입력해주세요.");
			bookController.searchBookByLaundryId(1L, 7L);
			System.out.print("▶ ");
			Long bookId = (long)Integer.parseInt(sc.nextLine());
			System.out.println("업데이트할 예약 상태 번호를 입력해주세요.");
			System.out.println("[ 1. 수거 예정 | 2. 수거 중 | 3. 세탁 진행 중 | 4. 세탁 완료 | 5. 배달 예정 | 6. 배달 중 | 7. 배달 완료 | 8. 예약 거절 | 9. 정산 완료 ]");
			System.out.print("▶ ");
			Long bookStateId = (long)Integer.parseInt(sc.nextLine());
			if (bookStateId == 7) {
				bookController.updateBookComplete(bookId);
			} else {
				bookController.searchBookByLaundryId(bookStateId, ++bookStateId);
			}
		} catch (Exception e) {
			FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
		}
	}
}
