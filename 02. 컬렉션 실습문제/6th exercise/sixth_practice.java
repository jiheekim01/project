package collection_package;

import java.util.*;

class Location {
	private String cityName;
	private int longitude; // 경도
	private int latitude; // 위도

	public Location(String cityName, int latitude, int longitude) {
		this.cityName = cityName;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public void display() {
		System.out.println(cityName + " " + latitude + " " + longitude);
	}
}

/**
 * @packageName	: collection_package
 * @fileName	: sixth_practice.java
 * @author		: TJ
 * @date		: 2024.12.11
 * @description	: 도시 이름, 위도, 경도 정보를 가진 Location 클래스를 작성하고,
 * 		  도시 이름을 '키'로 하는 HashMap<String, Location> 컬렉션을 만들고,
 * 		  사용자로부터 입력 받아 4개의 도시를 저장하라. 그리고 도시 이름으로 검색하는 프로그램을 작성하라.
 * ========================================================================================
 * DATE					AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.11				SW WOO				최초 생성
 * 
 */
public class sixth_practice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		HashMap<String, Location> city = new HashMap<>();
		String answer = "null";
		String new_cityName = "null";
		int new_longitude = 0;
		int new_latitude = 0;
		String findCity = "null";

		while (city.size() < 4) {
			try {
				System.out.println("도시, 경도, 위도를 입력하세요 >");
				answer = scanner.nextLine();
				String split_answer[] = answer.split(",");
				new_cityName = split_answer[0];
				new_longitude = Integer.parseInt(split_answer[1]);
				new_latitude = Integer.parseInt(split_answer[2]);
				city.put(new_cityName, new Location(new_cityName, new_longitude, new_latitude));
			} catch (NumberFormatException e) {
				System.out.println("경도와 위도는 숫자여야 합니다.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("입력 형식이 잘못되었습니다. 다시 시도해주세요.");
			}

		}
		System.out.println("---------------------------------");
		while (true) {
			System.out.print("도시 이름 >> ");
			findCity = scanner.nextLine();
			if (findCity.equals("그만")) {
				break;
			} else {
				if (city.containsKey(findCity)) {
					city.get(findCity).display();
				} else {
					System.out.println(findCity + "는 없습니다.");
				}
			}
		}
		scanner.close();
	}

}
