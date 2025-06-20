package array_practice;

import java.util.Scanner;

/**
 * @packageName	: array_practice
 * @fileName	: ninth_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class ninth_practice {

	public static void main(String[] args) {
//		치킨 배열 초기화 
		String[] bbq = { "황금올리브", "자메이카", "스모크" };

		Scanner scanner = new Scanner(System.in);
		System.out.print("치킨 이름을 입력하세요: ");
//        찾고자 하는 치킨 입력
		String chicken = scanner.next();

		boolean isSame = true; // 같은지 확인
		boolean found = false; // 같은 단어 찾은 여부

		for (int i = 0; i < bbq.length; i++) {
			// 입력된 단어와 배열에 있는 치킨의 길이가 같은지 확인
			if (bbq[i].length() == chicken.length()) {
				// 길이가 같으면 단어가 같은지 체크
				for (int j = 0; j < chicken.length(); j++) {
					// 길이가 같은것 중 문자 하나하나 비교
					if (bbq[i].charAt(j) != chicken.charAt(j)) {
						isSame = false;
						break;
					}
				}

//               같으면 found에서 true
				if (isSame == true) {
					found = true;
					System.out.println(chicken + " 치킨 배달 가능합니다.");

					break;
				}
			}
		}

		if (found == false || isSame == false) {
			System.out.println(chicken + " 치킨은 없는 메뉴입니다.");
		}

		scanner.close();
	}
}
