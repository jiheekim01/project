package collection_package;

import java.util.*;

class Student_Info {
	private String student_name;
	private String department_information;
	private int student_number;
	private double student_score;

	public Student_Info(String student_name, String department_information, int student_number, double student_score) {
		this.student_name = student_name;
		this.department_information = department_information;
		this.student_number = student_number;
		this.student_score = student_score;
	}

	public void printStudentInfo() {
		System.out.println("이름: " + student_name + ", 학과: " + department_information + ", 학번: " + getStudent_number()
				+ ", 학점 평균: " + getStudent_score());
	}

	public int getStudent_number() {
		return student_number;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public void setStudent_number(int student_number) {
		this.student_number = student_number;
	}

	public void setStudent_score(double student_score) {
		this.student_score = student_score;
	}

	public double getStudent_score() {
		return student_score;
	}

}

/**
 * @packageName : collection_package
 * @fileName : fifth_practice.java
 * @author : TJ
 * @date : 2024.12.11
 * @description : 하나의 학생 정보를 나타내는 Student 클래스에는 이름, 학과, 학번, 학점 평균을 저장하는 필드가 있다.
 *              학생마다 Student 객체를 생성하고 4명의 학생 정보를 ArrayList 컬렉션에 저장한 후에,
 *              ArrayList의 모든 학생(4명) 정보를 출력하고 학생 이름을 입력받아 해당 학생의 학점 평균을 출력하는
 *              프로그램을 작성하라.
 * 
 * 
 */
public class fifthSecond {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<Student_Info> insert_student = new ArrayList<>();
		int number = 0;
		String input = null;
		String[] input_split;
		String name;
		String major;
		int studentNo;
		double score;
		while (true) {
			System.out.print("입력 받고 싶은 인원의 수는 몇명인가요? ");
			try {
				number = scanner.nextInt();
				scanner.nextLine();
				if (number <= 0) {
					System.out.println("학생 수는 1명 이상이어야 합니다.");
					continue;
				} else {
					for (int i = 0; i < number; i++) {
						System.out.println("정보를 입력하세요");
						input = scanner.nextLine();
						input_split = input.split(",");
						if (input_split.length == 4) {
							name = input_split[0].trim();
							major = input_split[1].trim();
							studentNo = Integer.parseInt(input_split[2].trim());
							score = Double.parseDouble(input_split[3].trim());
							insert_student.add(new Student_Info(name, major, studentNo, score));
						}
					}
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요");
				scanner.next();
			}

		}

		System.out.println("입력된 학생 정보:");
		for (Student_Info student : insert_student) {
			student.printStudentInfo();
		}

		double sum = 0.0;
		double result = 0.0;
		for (Student_Info student : insert_student) {
			sum += student.getStudent_score();
		}
		result = sum / number;
		System.out.println("입력된 학생들의 학점 합은 " + sum + "이고 입력된 학생들의 학접 평균은 " + result + "입니다");

		System.out.print("찾고자 하는 학생을 입력 하세요 > ");
		String find_name = scanner.next();
		boolean found = false;
		for (Student_Info student : insert_student) {
			if (student.getStudent_name().equalsIgnoreCase(find_name)) {
				System.out.println(find_name + "의 학점 평균은 " + student.getStudent_score() + "입니다.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("학생을 찾을 수 없습니다.");
		}
		scanner.close();
	}
}
