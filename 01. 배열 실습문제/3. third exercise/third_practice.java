package array_practice;

import java.util.Scanner;

/**
 * @packageName	: array_practice
 * @fileName	: third_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class third_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		배열 크기 입력
		System.out.print("값을 입력하세요 : ");
		int num = Integer.parseInt(scanner.next());
//		입력된 길이만큼의 배열 초기화
		int intArray[] = new int[num];
		
//		1부터 입력 받은 값 배열에 삽입
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = i + 1; 
		}
//		배열 출력
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i]+" ");
		}
		scanner.close();
	}

}
