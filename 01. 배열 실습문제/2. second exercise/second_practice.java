package array_practice;

/**
 * @packageName	: array_practice
 * @fileName	: second_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class second_practice {

	public static void main(String[] args) {
//		길이가 10인 배열을 선언
		int intArray[] = new int[10];
//		1부터 10까지의 값을 반복문을 이용하여 역순으로 삽입
		for (int i = 0; i <intArray.length; i++) {
			intArray[i] = intArray.length-i; 
		}
//		배열 출력
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i]+" ");
		}
	}

}
