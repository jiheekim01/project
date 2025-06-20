package array_practice;

import java.util.Random;

/**
 * @packageName	: array_practice
 * @fileName	: fourteenth_practice.java
 * @author		: TJ
 * @date		: 2024.12.03
 * @description	: 
 * ========================================================================================
 * DATE						AUTHOR				NOTE
 * ----------------------------------------------------------------------------------------
 * 2024.12.03				SW WOO				최초 생성
 * 
 */
public class fourteenth_practice {
	
//	배열을 버블 정렬 함수로 지정
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
// 로또 만드는 함수 
	public static void make_lottery(int[] lottery_Array) {
		Random random = new Random();
		int count = 0;
		while (count < lottery_Array.length) {
			int number = random.nextInt(45) + 1;
			boolean duplicate = false; // 중복 여부 체크를 확인하기 위해서 표시
			for (int i = 0; i < count; i++) {
				//중복
				if (lottery_Array[i] == number) {
					duplicate = true;
					break;
				}
			}
			if (duplicate == false) {
				//중복이 되지 않아 배열에 삽입
				lottery_Array[count++] = number;
			}
		}
	}

	public static void main(String[] args) {
		//로또 배열 초기화
		int lottery_Array[] = new int[6];
		//위에서 만든 함수 호출하여 로또 
		make_lottery(lottery_Array);
		// 정렬전 로또 번호들 출력
		System.out.print("정렬전 로또 번호: ");
		for (int i = 0; i < lottery_Array.length; i++) {
			System.out.print(lottery_Array[i] + " ");
		}
		// 위에서 만든 정렬 함수를 이용하여 정렬
		bubbleSort(lottery_Array);
		System.out.println();
		// 정렬 된 함수 출력
		System.out.print("정렬 후 로또 번호: ");
		for (int i = 0; i < lottery_Array.length; i++) {
			System.out.print(lottery_Array[i] + " ");
		}

	}
}
