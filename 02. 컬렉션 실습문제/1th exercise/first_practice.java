package collection_package;
import java.util.*;

/**
 * @packageName	: collection_package
 * @fileName	: first_practice.java
 * @author		: TJ
 * @date		: 2024.12.11
 * @description	: Scanner 클래스로 -1이 입력될 때까지 양의 정수를 입력받아 벡터에 저장하고 벡터를 검색하여 가장 큰 수를 출력하는 프로그램을 작성하라.
 * ========================================================================================
 * DATE					AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.11				SW WOO				최초 생성
 * 
 */
public class first_practice {

	public static void main(String[] args) {
		Vector<Integer> v= new Vector<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수(-1이 입력될 때까지)");
		int max = -1;
		
		while(true) {
			int number = scanner.nextInt();
			
			if(number < -1) {
				System.out.println("잘못된 값을 입력하였습니다.");
				
			}
			else if (number == -1){
				for(int i=0;i<v.size();i++) {
					if(max<v.elementAt(i)) {
						max=v.elementAt(i);
					}
				}
				break;
			}
			else {
				v.add(number);
			}
			
		}
		System.out.println(v);
		System.out.println("최대값은 "+ max+"입니다");
		scanner.close();
	}

}
