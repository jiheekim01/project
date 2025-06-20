package array_practice;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @packageName	: array_practice
 * @fileName	: sixteenth_second_practice.java
 * @author		: TJ
 * @date		: 2024.12.04
 * @description	: 16번 문제
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.04				SW WOO				최초 생성
 * 
 */
public class sixteenth_second_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//1. 변수 선언
		int user_array_answer = 0;
		int count = 0;
		String[] user_array = null;
		String[] new_user_array = null;
		String user_string_answer;
		String yes_no_answer = "Y";
		char char_yes_no_answer = 0;
		int add_array_number;
		
		while (true) {
		//배열의 크기 선언
			System.out.println("배열의 크기를 입력하세요 :");
			// 정수를 입력 받아야 하므로 정수가 아닌 경우 예외 처리 필요
			try {
				user_array_answer = Integer.parseInt(scanner.next());
//				배열의 크기는 0이 될수 없음
				if (user_array_answer == 0) {
					System.out.println("배열의 크기는 0이 될수 없습니다.");
					continue;
				} else if (user_array_answer < 0) {
//					배열의 크기는 음이 될수 없음
					System.out.println("배열의 크기는 음수가 될수 없습니다.");
					continue;
				} else {
//					배열의 크기가 0보다 클 때 인제 코드 시작
					user_array = new String[user_array_answer]; // 코드 초기화
					scanner.nextLine();
					// 배열에 삽입
					while (count < user_array_answer) {
						System.out.println((count + 1) + "번째 문자열 : ");
						user_string_answer = scanner.nextLine();
						user_array[count++] = user_string_answer;
					}
//					추가 할지 말지 코드 작성
					while (true) {
						System.out.println("더 값을 입력하시겠습니까?(Y/N) :");
						yes_no_answer = scanner.next();
						char_yes_no_answer = yes_no_answer.charAt(0);
						if (char_yes_no_answer == 'Y' || char_yes_no_answer == 'y') {
							while (true) {
								System.out.println("더 입력하고 싶은 개수 :");
//								더 입력하고 싶은 갯수는 정수형이어야 하므로 예외 처리 필요
								try {
									add_array_number = scanner.nextInt();
//									0보다 작은 수를 입력 받을수는 없음
									if (add_array_number < 0) {
										System.out.println("0보다 작은 값을 입력하였습니다. 입력된 값은 0보다 커야합니다.");
										continue;
									}else if(add_array_number == 0) {
//									0보다 큰수를 입력 받아야함	
										System.out.println("입력된 값은 0 보다 커야합니다.");
										continue;
									}
									else {
//										그 외 경우 정상 처리
										
										new_user_array = new String[user_array_answer + add_array_number];
										// 기존 배열의 값을 새로운 배열에 복사한다.
										for (int i = 0; i < user_array_answer; i++) {
											new_user_array[i] = user_array[i];
										}
										// 기존 배열의 크기를 증가시킴 
										user_array_answer += add_array_number;
										user_array = new_user_array; // 기존 배열을 새로운 배열로 참조
										scanner.nextLine();
										while (count < user_array_answer) {
											System.out.println((count + 1) + "번째 문자열 : ");
											user_string_answer = scanner.nextLine();
											user_array[count++] = user_string_answer;
										}
									}
									break;
								} catch (InputMismatchException e) {
									System.out.println("정수를 입력 하여야 합니다. 숫자를 입력하세요!");
									scanner.nextLine();
								}
							}
						} else if (char_yes_no_answer == 'n' || char_yes_no_answer == 'N') {
							break;
						} else {
							System.out.println("y또는 n으로 입력해주세요");
						}
					}
				}
			}
			catch (NumberFormatException e) {
				System.out.println("정수를 입력 하여야 합니다. 숫자를 입력하세요!!!!!!!!!!!!");
				scanner.nextLine();
				continue;
			}
			System.out.println("총 출력되는 갯수는 "+count+"개 입니다.");
			System.out.print("[");
			if (user_array_answer == 1) {
				System.out.print("\'" + user_array[0] + "\'");
			} else if (user_array_answer == 2) {
				System.out.print("\'" + user_array[0] + "\'" + ", " + "\'" + user_array[1] + "\'");
			} else {
				System.out.print("\'" + user_array[0] + "\'" + ", ");
				for (int i = 1; i < user_array_answer - 1; i++) {
					System.out.print("\'" + user_array[i] + "\'" + ", ");
				}
				System.out.print("\'" + user_array[user_array_answer - 1] + "\'");
			}
			System.out.print("]");
			break;
		}
		scanner.close();
	}
}
