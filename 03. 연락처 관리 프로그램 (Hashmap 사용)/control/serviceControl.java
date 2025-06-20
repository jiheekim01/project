package contactMVC.control;

import java.util.Scanner;

import contactMVC.readwrite.ReadWriteToBinary;
import contactMVC.service.*;

import contactMVC.view.printResult;

public class serviceControl {
	public static void contactControl(String control) {
		printResult printresult = new printResult();
		ReadWriteToBinary readWriteToBinary = new ReadWriteToBinary();
		Scanner scanner = new Scanner(System.in);
		String name = null;
		int number = 0;
		ChangePersonService changeperson = null;

		if (control.equals("hashmap")) {
			changeperson = new ChangePersonHashmap();
			changeperson.putHashList(readWriteToBinary.readFile());
		}
		
		while (true) {
			printresult.printMenu();
			System.out.println("번호를 선택하세요 > ");
			try {
				number = Integer.parseInt(scanner.next());
				scanner.nextLine();
				if (number > 6 || number < 1) {
					System.out.println("1번부터 6번 사이의 숫자를 입력하세요.");
				} else if (number == 6) {
					System.out.println("프로그램을 종료합니다.");
					if (control.equals("hashmap")) {
						readWriteToBinary.writeFile(changeperson.getHashList());
					}
					break;
				} else if (number == 5) {
					System.out.println("삭제할 회원의 이름을 입력하세요.");
					name = scanner.nextLine();
					changeperson.deletePerson(name, scanner);
				} else if (number == 4) {
					System.out.println("수정할 회원의 이름을 입력하세요.");
					name = scanner.nextLine();
					changeperson.changePersonInfo(name, scanner);
				} else if (number == 3) {
					changeperson.addPerson(scanner);
				} else if (number == 2) {
					changeperson.searchPerson(scanner);
				} else if (number == 1) {
					printresult.printMemberList();
					printresult.printPersonList(changeperson.printContactList());
				}

			} catch (NumberFormatException e) {
				System.out.println("정수를 입력해주세요!");
			}
		}

		scanner.close();
	}
}
