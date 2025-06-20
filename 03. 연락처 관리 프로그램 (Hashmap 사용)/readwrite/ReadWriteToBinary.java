package contactMVC.readwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import contactMVC.dto.PersonDTO;

public class ReadWriteToBinary implements ReadWriteToBinaryService {
	private static final String DIRECTORY_PATH = "C:\\Temp\\write_and_read_binary";
	private static final String FILENAME = "C:\\Temp\\write_and_read_binary\\hashmap_data.bin";
	static File directory = new File(DIRECTORY_PATH);

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, PersonDTO> readFile() {
		HashMap<String, PersonDTO> map = new HashMap<String, PersonDTO>();
		checkDirectory();
		try (FileInputStream fileIn = new FileInputStream(FILENAME);
				ObjectInputStream ois = new ObjectInputStream(fileIn)) {
			map = (HashMap<String, PersonDTO>) ois.readObject();
			System.out.println("파일에서 데이터를 성공적으로 읽었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다. 새로 시작합니다.");
			map = new HashMap<>();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

		return map;
	}

	@Override
	public void writeFile(HashMap<String, PersonDTO> temp) {
		checkDirectory();
		try (FileOutputStream fileOut = new FileOutputStream(FILENAME);
				ObjectOutputStream oos = new ObjectOutputStream(fileOut)) {
			oos.writeObject(temp);
		} catch (IOException e) {
			System.err.println("파일 저장 중 오류 발생: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void checkDirectory() {
		if (!directory.exists()) {
			boolean created = directory.mkdirs();
			if (!created) {
				System.out.println("디렉토리 생성에 실패했습니다.");
			} else {
				System.out.println("디렉토리가 생성되었습니다.");
			}
		}
	}
}
