package array_practice;

import java.util.Random;

/**
 * @packageName	: array_practice
 * @fileName	: twelve_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class twelve_practice {

	public static void main(String[] args) {
		Random random = new Random();

//		길이가 10인 배열 선언
		int intArray[] = new int[10];
//		최솟값 초기화
		int min_number = 10;
//		최댓값 초기화
		int max_number = 1;
//		배열에 난수 삽입
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = random.nextInt(10) + 1;
		}
//		배열 출력
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
//		
		for (int i = 0; i < intArray.length; i++) {
//		최솟값 비교하여 최솟값보다 작으면 최솟값에 대입
			if (min_number > intArray[i]) {
				min_number = intArray[i];
			}
//			최대값 비교하여 최대값보다 크면 최대값에 대입
			if (max_number < intArray[i]) {
				max_number = intArray[i];
			}
		}
//		출력
		System.out.println();
		System.out.println("최대값은 " + max_number + "이고 최소값은 " + min_number);
	}

}
