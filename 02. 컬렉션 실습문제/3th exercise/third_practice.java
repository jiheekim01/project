package collection_package;

import java.util.*;

/**
 * @packageName	: collection_package
 * @fileName	: third_practice.java
 * @author		: TJ
 * @date		: 2024.12.11
 * @description	: "그만"이 입력될 때까지 나라 이름과 인구를 입력받아 저장하고, 다시 나라 이름을 입력받아 인구를 출력하는 프로그램을 작성하라. 다음 해시맵을 이용하라.
 * ========================================================================================
 * DATE					AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.11				SW WOO				최초 생성
 * 
 */
public class third_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> count = new HashMap<String, Integer>();

		String contry_population_answer = "null";
		String country = "null";
		int population = 0;
		String country_population_search = "null";

		System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");

		while (true) {
			System.out.print("나라 이름, 인구 >> ");
			contry_population_answer = scanner.nextLine();

			// "그만"을 입력한 경우 처리
			if (contry_population_answer.equals("그만")) {
				while (true) {
					System.out.print("인구 검색 >> ");
					country_population_search = scanner.nextLine();
					if (country_population_search.equals("그만")) {
						break;
					} else {
						if (count.containsKey(country_population_search)) {
							System.out.println(
									country_population_search + " 인구는 " + count.get(country_population_search));
						} else {
							System.out.println(country_population_search + " 나라는 없습니다.");
						}
					}
				}
				break;
			}

			// "그만"이 아니면 입력을 공백으로 나누어 나라 이름과 인구를 구분
			String[] strArr = contry_population_answer.split(" ");
			country = strArr[0];
			try {
				population = Integer.parseInt(strArr[1]);
				count.put(country, population);
			} catch (NumberFormatException e) {
				System.out.println("인구는 숫자여야 합니다.");
			}

		}

		scanner.close();
	}
}
