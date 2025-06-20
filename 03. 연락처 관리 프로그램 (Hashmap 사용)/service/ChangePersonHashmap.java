package contactMVC.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import contactMVC.dto.PersonDTO;
import contactMVC.readwrite.ReadWriteToBinary;
import contactMVC.view.printResult;

public class ChangePersonHashmap implements ChangePersonService {
	printResult printresult = new printResult();

	private HashMap<String, PersonDTO> personList = new HashMap<>();
	ReadWriteToBinary readWriteToBinary = new ReadWriteToBinary();

	@Override
	public void addPerson(Scanner scanner) {
		String name = null;
		String phoneNumber = null;
		String address = null;
		String relationship = null;
		boolean checkIsDigit = false;
		Pattern phoneNumberPattern = Pattern.compile("^010[0-9]*$");
		if (personList.containsKey(phoneNumber)) {
			System.out.println(phoneNumber + "은 이미 존재합니다.");
		} else {
			System.out.println("회원의 정보를 입력하세요.");
			while (true) {
				System.out.print("▶ 이름 \n> ");
				name = scanner.nextLine();
				if (name.isBlank()) {
					System.out.println("이름은 공백이면 안됩니다.");
				} else {
					break;
				}
			}
			while (!checkIsDigit) {
				System.out.print("▶ 휴대폰 전화번호 \n(e.g. 01012345678) > ");
				phoneNumber = scanner.nextLine();
				Matcher matcher = phoneNumberPattern.matcher(phoneNumber);
				if (!matcher.matches()) {
					System.out.println("010으로 시작하는 숫자만 입력 가능합니다.");
					checkIsDigit = false;
					continue;
				} else if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
					System.out.println("10자리 또는 11자리로 입력해주세요.");
					checkIsDigit = false;
					continue;
				} else if (personList.containsKey(phoneNumber)) {
					System.out.println("중복된 값입니다.");
					checkIsDigit = false;
				} else {
					checkIsDigit = true;
				}
			}
			while (true) {
				System.out.print("▶ 주소 \n> ");
				address = scanner.nextLine();
				if (address.isBlank()) {
					System.out.println("주소는 빈칸이면 안됩니다.");
				} else {
					break;
				}
			}
			while (true) {
				System.out.print("▶ 종류 (가족, 친구, 기타 중에서 입력하세요) \n> ");
				relationship = scanner.nextLine();
				if (!relationship.equals("가족") && !relationship.equals("친구") && !relationship.equals("기타")) {
					System.out.println("가족, 친구, 기타 중에서 입력하세요.");
				} else {
					break;
				}
			}
			PersonDTO person = new PersonDTO(name, phoneNumber, address, relationship);
			personList.put(phoneNumber, person);
		}
	}

	@Override
	public void searchPerson(Scanner scanner) {
	    try {
	        System.out.println("이름으로 검색을 하고 싶으면 1번, 전화번호로 검색하고 싶으면 2번을 선택해주세요");
	        int number = Integer.parseInt(scanner.nextLine());

	        switch (number) {
	        case 1:
	            System.out.println("조회하고 싶은 회원의 이름을 입력하세요.");
	            String name = scanner.nextLine();
	            if (name.isEmpty()) {
	                System.out.println("공백을 입력하였습니다");
	            } else {
	                ArrayList<PersonDTO> peopleList = new ArrayList<PersonDTO>(personList.values());
	                ArrayList<PersonDTO> nameList = new ArrayList<PersonDTO>();
	                for (int i = 0; i < peopleList.size(); i++) {
	                    if (peopleList.get(i).getName().equals(name)) { 
	                        nameList.add(peopleList.get(i));
	                    }
	                }
	                printresult.printPersonList(nameList);
	            }
	            break;
	        case 2:
	            System.out.println("조회하고 싶은 회원의 전화번호를 입력하세요.");
	            String phoneNumber = scanner.nextLine();
	            if (phoneNumber.isEmpty()) {
	                System.out.println("공백을 입력하였습니다");
	            } else {
	                boolean found = false;
	                for (String name1 : personList.keySet()) {
	                    PersonDTO person = personList.get(name1);
	                    if (person.getPhoneNumber().equals(phoneNumber)) {
	                        System.out.println("이름 : " + person.getName() + ", 전화번호 : " + person.getPhoneNumber()
	                                + ", 주소 : " + person.getAddress() + ", 관계 : " + person.getRelationship());
	                        found = true;
	                        break;
	                    }
	                }
	                if (!found) {
	                    System.out.println("해당 전화번호의 회원을 찾을 수 없습니다.");
	                }
	            }
	            break;
	        default:
	            System.out.println("잘못 입력하였습니다.");
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("정수로 입력하셔야합니다.");
	    }
	}


	@Override
	public void deletePerson(String name, Scanner scanner) {
		ArrayList<String> phoneNumbers = new ArrayList<>();
		int number;
		int addOneNumber;
		String isYes = "예";
		for (String phone : personList.keySet()) {
			if (personList.get(phone).getName().equals(name)) {
				phoneNumbers.add(phone);
			}
		}

		if (phoneNumbers.isEmpty()) {
			System.out.println("이름 '" + name + "'을 찾을 수 없습니다.");
		} else if (phoneNumbers.size() == 1) {
			String userDelete = phoneNumbers.get(0);
			PersonDTO person = personList.get(userDelete);
			while (true) {
				System.out.println("이름 : " + person.getName() + ", 전화번호 : " + person.getPhoneNumber() + ", 주소 : "
						+ person.getAddress() + ", 관계 : " + person.getRelationship());
				System.out.println("삭제할 정보가 맞나여 > (예/아니요)");
				isYes = scanner.nextLine();
				if (isYes.equals("예")) {
					personList.remove(userDelete);
					System.out.println("삭제된 정보 = 이름 : " + person.getName() + ", 전화번호 : " + person.getPhoneNumber()
							+ ", 주소 : " + person.getAddress() + ", 관계 : " + person.getRelationship());
					break;
				} else if (isYes.equals("아니요")) {
					System.out.println("삭제가 되지 않았습니다.");
					break;
				} else {
					System.out.println("예/아니요 중에서 선택하세요.");
				}
			}
		} else {
			System.out.println("이름 '" + name + "'을 가진 사람들은 총 " + phoneNumbers.size() + "명");
			for (int i = 0; i < phoneNumbers.size(); i++) {
				String phone = phoneNumbers.get(i);
				PersonDTO person = personList.get(phone);
				System.out.println("[" + (i + 1) + "] 이름 = " + person.getName() + ", 전화번호 : " + person.getPhoneNumber()
						+ ", 주소 : " + person.getAddress() + ", 관계 : " + person.getRelationship());
			}
			while (true) {
				try {
					System.out.println("삭제하고 싶은 번호를 입력하세요 >");
					number = Integer.parseInt(scanner.nextLine());
					addOneNumber = number - 1;
					if (addOneNumber < 0 || addOneNumber > phoneNumbers.size()) {
						System.out.println("숫자를 다시 입력하세요.");
						continue;
					} else {
						while (true) {
							String userDelete = phoneNumbers.get(addOneNumber);
							PersonDTO person = personList.get(userDelete);
							try {
								System.out.println("이름 : " + person.getName() + ", 전화번호 : " + person.getPhoneNumber()
										+ ", 주소 : " + person.getAddress() + ", 관계 : " + person.getRelationship());
								System.out.println("삭제하실건가요? (예/아니요)");
								isYes = scanner.nextLine();
								if (isYes.equals("예")) {
									personList.remove(userDelete);
									System.out.println("삭제된 정보 = 이름 : " + person.getName() + ", 전화번호 : "
											+ person.getPhoneNumber() + ", 주소 : " + person.getAddress() + ", 관계 : "
											+ person.getRelationship());
									break;
								} else if (isYes.equals("아니요")) {
									System.out.println("삭제가 되지 않았습니다.");
									break;
								} else {
									System.out.println("예/아니요 중에서 선택하세요.");
									continue;
								}
							} catch (NoSuchElementException e) {
								System.out.println("잘못 입력했습니다.");
							}
							break;
						}

					}
				} catch (NumberFormatException e) {
					System.out.println("숫자를 입력하세요.");
					continue;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("범위 안에 숫자를 입력하세요.");
					continue;
				}
				break;
			}
		}
	}

	@Override
	public void changePersonInfo(String name, Scanner scanner) {
		ArrayList<String> phoneNumbers = new ArrayList<>();
		String isYes = "예";
		for (String phone : personList.keySet()) {
			if (personList.get(phone).getName().equals(name)) {
				phoneNumbers.add(phone);
			}
		}
		if (phoneNumbers.isEmpty()) {
			System.out.println("이름 '" + name + "'을 찾을 수 없습니다.");
		} else if (phoneNumbers.size() == 1) {
			String changePersonName = phoneNumbers.get(0);
			PersonDTO person = personList.get(changePersonName);
			System.out.println("수정할 사람 정보 = 이름 : " + person.getName() + ", 전화번호 : " + person.getPhoneNumber()
					+ ", 주소 : " + person.getAddress() + ", 관계 : " + person.getRelationship());
			while (true) {
				System.out.println("수정하실건가요? (예/아니요)");
				isYes = scanner.nextLine();
				if (isYes.equals("예")) {
					personList.remove(changePersonName);
					addPerson(scanner);
					break;
				} else if (isYes.equals("아니요")) {
					System.out.println("수정 되지 않았습니다.");
					break;
				} else {
					System.out.println("예/아니요 중에서 선택하세요.");
					continue;
				}
			}

		} else {
			System.out.println("이름 '" + name + "'을 가진 사람들은 총 " + phoneNumbers.size() + "명");
			for (int i = 0; i < phoneNumbers.size(); i++) {
				String phone = phoneNumbers.get(i);
				PersonDTO person = personList.get(phone);
				System.out.println("[" + (i + 1) + "] 이름 = " + person.getName() + ", 전화번호 : " + person.getPhoneNumber()
						+ ", 주소 : " + person.getAddress() + ", 관계 : " + person.getRelationship());
			}
			while (true) {
				try {

					System.out.println("수정하고 싶은 번호를 입력하세요 >");
					int number = Integer.parseInt(scanner.nextLine());
					int addOneNumber = number - 1;
					if (addOneNumber < 0 || addOneNumber > phoneNumbers.size()) {
						System.out.println("숫자를 다시 입력하세요.");
						continue;
					} else {
						while (true) {
							String changeuser = phoneNumbers.get(addOneNumber);
							PersonDTO person = personList.get(changeuser);
							System.out
									.println("수정할 정보 = 이름 : " + person.getName() + ", 전화번호 : " + person.getPhoneNumber()
											+ ", 주소 : " + person.getAddress() + ", 관계 : " + person.getRelationship());
							System.out.println("수정하실건가요? (예/아니요)");
							isYes = scanner.nextLine();
							if (isYes.equals("예")) {
								personList.remove(changeuser);
								addPerson(scanner);
								break;
							} else if (isYes.equals("아니요")) {
								System.out.println("수정 되지 않았습니다.");
								break;
							} else {
								System.out.println("예/아니요 중에서 선택하세요.");
								continue;
							}

						}

					}
				} catch (NumberFormatException e) {
					System.out.println("숫자를 입력하세요.");
					continue;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("범위 안에 숫자를 입력하세요.");
					continue;
				}
				break;
			}
		}
	}

	@Override
	public ArrayList<PersonDTO> printContactList() {
		ArrayList<PersonDTO> valuesList = new ArrayList<PersonDTO>(personList.values());
		return valuesList;
	}

	public HashMap<String, PersonDTO> getHashList() {
		return this.personList;
	}

	public void putHashList(HashMap<String, PersonDTO> personList) {
		this.personList = personList;
	}

}