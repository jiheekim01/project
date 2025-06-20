package array_practice;
import java.util.Random;
/**
 * @packageName	: array_practice
 * @fileName	: thirteenth_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ===================================================================================
 * DATE				AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class thirteenth_practice {
    public static void main(String[] args) {
        Random random = new Random();
//        배열 초기화
        int intArray[] = new int[10];
        boolean duplicate = false; // 중복 체크    ( 중복 되면 true, 중복되지 않으면 false)    
        int count = 0; 
        while (count < intArray.length) {
            int number = random.nextInt(10) + 1;
            duplicate = false; // 중복 체크 초기화 
            for (int i = 0; i < count; i++) {
                // 중복 값이 존재하면 배열에 삽입을 못하게 함
                if (intArray[i] == number) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate == false) {
                intArray[count++] = number;
            }
        }
//        출력
        for(int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }
}


