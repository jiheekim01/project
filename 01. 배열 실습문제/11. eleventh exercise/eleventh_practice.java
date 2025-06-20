package array_practice;
import java.util.Random;
/**
 * @packageName	: array_practice
 * @fileName	: eleventh_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class eleventh_practice {

	public static void main(String[] args) {
//		난수 발생
		Random random = new Random();
//		길이가 10인 배열 선언
		int intArray[] = new int[10];
//		1~10까지 랜덤으로 생성된 난수를 배열에 삽입
		for(int i=0;i<intArray.length;i++) {
			intArray[i]=random.nextInt(10)+1;
		}
//		배열 출력
		for(int i=0;i<intArray.length;i++) {
			System.out.print(intArray[i]+" ");
		}
		
	}

}
