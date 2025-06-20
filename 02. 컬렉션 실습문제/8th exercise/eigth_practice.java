package collection_package;

import java.util.*;

/**
 * @packageName	: collection_package
 * @fileName	: eigth_practice.java
 * @author		: TJ
 * @date		: 2024.12.11
 * @description	: 고객의 이름과 포인트 점수를 관리하는 프로그램을 해시맵을 이용하여 작성하라. 프로그램은 고객의 이름과 포인트를 함께 저장 관리하는데, 포인트는 추가될 때마다 누적하여 저장된다.
 * ========================================================================================
 * DATE					AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.11				SW WOO				최초 생성
 * 
 */
public class eigth_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> point = new HashMap<String, Integer>();
		String answer = "null";
		String name = "null";
		int score = 0;
		System.out.println("포인트 관리 프로그램입니다");
		while (true) {
			System.out.println("이름과 포인트 입력 >> ");
			answer = scanner.nextLine();
			if (answer.equals("그만")) {
				break;
			}
			String[] strArr = answer.split(" ");
			name = strArr[0];
			try {
				score = Integer.parseInt(strArr[1]);

				if (point.containsKey(name)) {
					score += point.get(name);
				}
				point.put(name, score);
				for (Map.Entry<String, Integer> entry : point.entrySet()) {
					System.out.print("(" + entry.getKey() + "," + entry.getValue() + ")");
				}
				System.out.println();

			} catch (NumberFormatException e) {
				System.out.println("포인트는 숫자여야 합니다.");
			}

		}

		scanner.close();
	}

}
