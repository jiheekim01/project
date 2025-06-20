package array_practice;

import java.util.Scanner;

/**
 * @packageName	: array_practice
 * @fileName	: tenth_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class tenth_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요(-포함) : ");
//		주민등록번호 입력
		String identy = scanner.next();
//		주민등록번호를 넣을 배열 초기화
		char[] id_identy = new char[identy.length()];
//		마스킹 하기 위한 배열 초기화
		char[] new_id = new char[identy.length()];
//		입력된 문자열을 배열에 입력
		for (int i = 0; i < identy.length(); i++) {
			id_identy[i] = identy.charAt(i);
		}
		for (int i = 0; i < id_identy.length; i++) {
			System.out.print(id_identy[i]);
		}
		System.out.println();
//		123456-1 < 여기 까지는 배열 그대로 넣기
		for (int i = 0; i < 8; i++) {
			new_id[i]=id_identy[i];
		}
//		123456-1234567 중에서 - 뒤에 부분 234567은 *로 대체 
		for(int i =8;i<id_identy.length;i++) {
			new_id[i]='*';
		}
//		대체된 배열 출력
		for(int i=0;i<id_identy.length;i++) {
			System.out.print(new_id[i]);
		}
		scanner.close();
	}

}
