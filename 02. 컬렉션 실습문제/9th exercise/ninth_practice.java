package collection_package;

import java.util.*;

class NationInfo {
	private String country;
	private String capital;

	public NationInfo(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}

	public void printNationInfo() {
		System.out.println("│" + getCountry() + '\t' + capital);
	}

	public String getCountry() {
		return country;
	}

	public String getCapital() {
		return capital;
	}

}

/**
 * @packageName	: collection_package
 * @fileName	: ninth_practice.java
 * @author		: TJ
 * @date		: 2024.12.11
 * @description	: 나라와 수도 맞추기 게임의 실행 예시는 다음과 같다.
 * 		  나라 이름(country)과 수도(capital)로 구성된 Nation 클래스를 작성하고 Vector 컬렉션을 이용하여 프로그램을 작성하라.

 * ========================================================================================
 * DATE					AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.11				SW WOO				최초 생성
 * 
 */
public class ninth_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<NationInfo> nations = new Vector<NationInfo>();
		System.out.println("****** 수도 맞추기 게임을 시작합니다. ******");
		while (true) {
			System.out.println();
			System.out.println("======================================");
			System.out.println("나라와 수도를 입력하고 싶으면 1번을 누르세요.");
			System.out.println("퀴즈로 가고 싶으면 2번을 누르세요.");
			System.out.println("종료를 하고 싶으면 3번을 누르세요.");
			System.out.println("======================================");
			System.out.print(">>");

			int answer_number;
			try {
				answer_number = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자가 아닙니다. 숫자만 입력해주세요.");
				continue;
			}

			if (answer_number == 1) {
				while (true) {
					System.out.println("현재 " + nations.size() + "개 나라와 수도가 입력되어 있습니다.");
					System.out.println("====================================");
					System.out.println("나라와 수도 입력 ");
					System.out.println("입력을 종료하고 싶으면 '그만'을 입력하세요.");
					System.out.println("====================================");
					System.out.print(">>");

					String input = scanner.nextLine();
					if (input.equals("그만")) {
						int captial_count = 0;
						int country_count = 0;
						for (NationInfo nation : nations) {
							if (nation.getCountry().length() > country_count) {
								country_count = nation.getCountry().length();
							}
							if (nation.getCapital().length() > captial_count) {
								captial_count = nation.getCapital().length();
							}
						}
						System.out.println("====================================");
						System.out.println("총 " + nations.size() + "개 나라와 수도가 입력되어 있습니다.");
						System.out.println("입력된 나라와 수도 정보입니다.");
						System.out.print("┌");

						for (int i = 1; i < (country_count + captial_count) * 3; i++) {
							System.out.print("─");
						}

						System.out.println("┐");
						System.out.print("│" + "나라" + '\t' + "수도");

						System.out.println();
						System.out.print("│");
						for (int i = 1; i < (country_count + captial_count) * 3; i++) {
							System.out.print("─");
						}
						System.out.println();
						for (NationInfo nation : nations) {
							nation.printNationInfo();
						}
						System.out.print("└");
						for (int i = 1; i < (country_count + captial_count) * 3; i++) {
							System.out.print("─");
						}
						System.out.println("┘");
						break;
					}

					String[] inputParts = input.split(" ");
					if (inputParts.length != 2) {
						System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
						continue;
					}
					String country = inputParts[0];
					String capital = inputParts[1];
					boolean country_exists = false;
					boolean capital_exists = false;
					for (NationInfo nation : nations) {
						if (nation.getCountry().equals(country)) {
							country_exists = true;
							System.out.println(country + "는 이미 있습니다!");
							break;
						}
					}
					for (NationInfo nation : nations) {
						if (nation.getCapital().equals(capital)) {
							capital_exists = true;
							System.out.println(capital + "는 이미 있습니다!");
							break;
						}
					}
					if (!country_exists && !capital_exists) {
						nations.add(new NationInfo(country, capital));
					}
				}

			} else if (answer_number == 2) {
				if (nations.isEmpty()) {
					System.out.println("먼저 나라와 수도를 입력하세요!");
				} else {
					while (true) {
						Random random_quiz = new Random();
						System.out.println("퀴즈를 종료하고 싶으면 '그만'을 입력하세요.");

						NationInfo randomNation = nations.get(random_quiz.nextInt(nations.size()));
						System.out.println(randomNation.getCountry() + "의 수도는?");
						String input_answer = scanner.nextLine();
						if (input_answer.equals("그만")) {
							break;
						}

						if (input_answer.equals(randomNation.getCapital())) {
							System.out.println("정답!!");
						} else {
							System.out.println("아닙니다!!");
						}
					}
				}

			} else if (answer_number == 3) {
				System.out.println("게임을 종료합니다.");
				break;
			} else {
				System.out.println("잘못 입력하였습니다. 다시 입력하세요!");
			}
		}
		scanner.close();
	}
}
