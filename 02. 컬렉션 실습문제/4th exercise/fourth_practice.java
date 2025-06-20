package collection_package;
import java.util.*;
/**
 * @packageName	: collection_package
 * @fileName	: fourth_practice.java
 * @author		: TJ
 * @date		: 2024.12.11
 * @description	: Vector 컬렉션을 이용하여 강수량의 평균을 유지 관리하는 프로그램을 작성하라. 강수량을 입력하면 벡터에 추가하고 현재 입력된 모든 강수량과 평균을 출력한다.
 * ========================================================================================
 * DATE					AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.11				SW WOO				최초 생성
 * 
 */
public class fourth_practice {

	public static void main(String[] args) {
		Vector<Integer> v= new Vector<Integer>();
		Scanner scanner = new Scanner(System.in);

		int average;
		int count=0;
		while(true) {
			System.out.print("강수량 입력 (0 입력시 종료) >>");
			int number = scanner.nextInt();
			if(number == 0) {
				v.add(number);
				break;
			}else {
				v.add(number);
				count++;
				int sum = 0;
				System.out.println(v);
				for(int i=0;i<v.size();i++) {
					sum=sum+v.elementAt(i);
				}
				System.out.println("현재 합은 "+sum+"입니다");
				average=sum/count;
				System.out.println("현재 평균은 "+average+"입니다");
			}
			
			
		}
		System.out.println(v);
		

		scanner.close();
	}

}
