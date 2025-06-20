package collection_package;

import java.util.*;

/**
 * @packageName	: collection_package
 * @fileName	: second_practice.java
 * @author		: TJ
 * @date		: 2024.12.11
 * @description	: Scanner 클래스를 사용하여 6개 학점('A', 'B', 'C', 'D', 'F')을 문자로 입력받아 ArrayList에 저장하고,
 * 		  ArrayList를 검색하여 학점을 점수(A=4.0, B=3.0, C=2.0, D=1.0, F=0)로 변환하여 평균을 출력하는 프로그램을 작성하라.

 * ========================================================================================
 * DATE					AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.11				SW WOO				최초 생성
 * 
 */
public class second_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> array = new ArrayList<String>();
		while (true) {
			System.out.println("입력되는 학점은 몇개인가여?");
			int number = scanner.nextInt();
			if (number <= 0) {
				System.out.println("잘못된 값을 입력하였습니다. 다시 입력하세요");
			} else {
				for (int i = 0; i < number; i++) {
					System.out.println("학점('A', 'B', 'C', 'D', 'F')을 입력하세요 : ");
					String score = scanner.next();
					char char_score = score.charAt(0);

					if (char_score != 'A' && char_score != 'B' && char_score != 'C' && char_score != 'D'
							&& char_score != 'F') {
						System.out.println("잘못된 값을 입력하였습니다.");
						continue;
					} else {
						array.add(score);
					}
				}

				System.out.println(array);

				// (A=4.0, B=3.0, C=2.0, D=1.0, F=0)
				double sum = 0;
				for (String score : array) {
					switch (score) {
					case "A":
						sum += 4.0;
						break;
					case "B":
						sum += 3.0;
						break;
					case "C":
						sum += 2.0;
						break;
					case "D":
						sum += 1.0;
						break;
					case "F":
						sum += 0.0;
						break;
					}
				}

				System.out.println("학점들의 합은 " + sum + "입니다");
				System.out.println("학점들의 평균은 " + sum / number + "입니다");
				break;

			}
		}

		scanner.close();

	}

}
