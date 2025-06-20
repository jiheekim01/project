package contactMVC.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import contactMVC.dto.PersonDTO;

public interface ChangePersonService {
	void addPerson(Scanner scanner);

	void searchPerson(Scanner scanner);

	void deletePerson(String name, Scanner scanner);

	void changePersonInfo(String name, Scanner scanner);

	ArrayList<PersonDTO> printContactList();

	HashMap<String, PersonDTO> getHashList();

	void putHashList(HashMap<String, PersonDTO> personList);
}
