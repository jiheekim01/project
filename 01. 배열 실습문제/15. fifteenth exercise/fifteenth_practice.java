package array_practice;

import java.util.Scanner;

/**
 * @packageName	: array_practice
 * @fileName	: fifteenth_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class fifteenth_practice {
	
	// 배열을 정렬하는 함수 호출
	public static void bubbleSort(char[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					char temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열 : ");
		String new_word = scanner.next();
		int num = 0;
//		문자열을 문자 배열에 넣기 위해서 문자 배열 초기화
		char[] word = new char[new_word.length()];
		// 배열에 입력된 문자열 삽입
		for (int i = 0; i < new_word.length(); i++) {
			word[i] = new_word.charAt(i);
		}
		// 배열을 정렬
		bubbleSort(word);
//		새로운 배열 호출
		char[] new_array = new char[word.length];
		
		new_array[num++] = word[0]; //첫 번째 문자를 new_array 배열에 추가하는 역할
		for (int i = 1; i < word.length; i++) {
			// 중복되지 않으면 새로운 배열에  삽입
			if (word[i] != word[i - 1]) {
				new_array[num++] = word[i];
			}
		}

		System.out.print("문자열에 있는 문자: ");
		for (int i = 0; i < num; i++) {
			System.out.print(new_array[i] + " ");
		}
		System.out.println();
		System.out.println("문자 개수 : " + num);
		scanner.close();
	}
}
