package array_practice;

import java.util.Scanner;

/**
 * @packageName	: array_practice
 * @fileName	: eighth_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class eighth_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("홀수 숫자를 입력해주세요 : ");
			int number;
//			숫자를 입력 받게 예외처리
			try {
				number = Integer.parseInt(scanner.next());
				if (number <= 2 || number % 2 == 0) { //입력된 정수가 2 이하이거나 짝수인 경우
					System.out.println("다시 입력하세요.");
				} else { // 그 외의 경우
//					중간까지는 1부터 1씩 증가하여 중간 까지 오름차순으로 값을 출력
					for (int i = 0; i < (number + 1) / 2; i++) {
						System.out.print(i + 1 + " ");
					}
//					중간부터 1까지 내림차순으로 출력
					
					for (int i = (number) / 2; i > 0; i--) {
						System.out.print(i + " ");
					}

					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}

		}
		scanner.close();
	}

}
