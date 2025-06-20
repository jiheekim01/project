package array_practice;

import java.util.Scanner;

/**
 * @packageName	: array_practice
 * @fileName	: seventh_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class seventh_practice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
//		배열의 길이 지정
		System.out.print("배열의 길이를 지정해주세요 : ");
//		입력
		int number = Integer.parseInt(scanner.next());
//		배열 초기화
		int intArray[] = new int[number];
		int result = 0; // 배열들의 합을 구하기 위해서 초기화
//		배열에 값들 삽입
		for (int i = 0; i < number; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			intArray[i] = Integer.parseInt(scanner.next());

		}
		System.out.println("------------------------------");
//		배열의 값들 출력
		for (int i = 0; i < number; i++) {
			System.out.println("배열 " + i + "번째 인덱스에 넣은 값 : " + intArray[i]);
		}
		System.out.println("------------------------------");		
		for (int i = 0; i < number; i++) {
			result +=  intArray[i]; // result = result + intArray[i];
		}
		System.out.println("배열들의 합은 "+result);
		scanner.close();
	}

}
