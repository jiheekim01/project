package array_practice;

import java.util.Scanner;

/**
 * @packageName	: array_practice
 * @fileName	: six_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class six_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		정수 입력
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int number = Integer.parseInt(scanner.next());
//		0~6 사이 숫자가 아니어서 잘못 입력
		if(number<0 || number > 6) {
			System.out.println("잘못 입력하였습니다.");
		}
//		0~6사이 숫자
		else {
			 String[] week = {"월요일", "화요일", "수요일", "목요일", "금요일","토요일","일요일"};
//			 인덱스에 입력받는 값 대입하여 출력
			 System.out.println(week[number]);
		}
		scanner.close();
	}

}
