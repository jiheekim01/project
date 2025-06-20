package array_practice;

import java.util.Scanner;

/**
 * @packageName	: array_practice
 * @fileName	: fifth_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class fifth_practice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
//		문자열 입력
		System.out.print("문자열 : ");
		String new_word = scanner.next();

//		문자열을 문자 배열에 넣기 위해서 문자 배열 초기화
		char[] word = new char[new_word.length()];
//		찾는 값이 몇개인지 세기위해서 초기화
		int count = 0;
//		찾는 값이 존재 하면 word_find가 true 만약에 찾는 값이 존재 하지 않으면 word_find가 false
		boolean word_find = false;
//		문자 배열안에 입력 받는 문자열을 각 단어로 삽입 예를 들어 word를 입력 받으면 0번 index에 w 1번 index에 o 2번 index에 r 3번 index에 d
		for (int i = 0; i < new_word.length(); i++) {
			word[i] = new_word.charAt(i);
		}
//		문자 배열 출력
		for (int i = 0; i < word.length; i++) {
			System.out.print(word[i] + " ");
		}
		System.out.println();
//		찾는 단어 입력
		System.out.print("찾는 문자 : ");
		String string_find_word = scanner.next();
		
//		찾는 단어를 문자로 변경하는 함수
		char find_word = string_find_word.charAt(0);

//		배열 안에 입력 받는 문자가 존재 하면 세는 횟수 증가 및 word_find를 true로 변경 만약에 존재 하지 없으면 count는 늘지 않고 word_find는 false로 유지
		for (int i = 0; i < new_word.length(); i++) {
			if (word[i] == find_word) {
				count++;
				word_find = true;
			}
		}
//		찾는 문자가 없어서 없다고 출력
		if (word_find == false) {
			System.out.println("찾는 문자가 없습니다");
		} else {
//			존재하는 위치 출력 
			System.out.print("문자열에서 찾는 문자 " + find_word + "가 존재하는 위치(인덱스): ");

			for (int i = 0; i < new_word.length(); i++) {
//				몇번째 인덱스에 존재하는지 출력
				if (word[i] == find_word) {
					System.out.print("\'" + i + "\'");
				}
			}
			System.out.println();
//			찾는 문자가 나오는 총 횟수
			System.out.println("문자열에서 찾는 문자 " + find_word + "는 총" + count + "번 존재합니다");
		}

		scanner.close();
	}

}
