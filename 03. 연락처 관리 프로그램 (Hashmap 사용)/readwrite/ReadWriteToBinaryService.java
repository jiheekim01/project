package contactMVC.readwrite;

import java.util.HashMap;

import contactMVC.dto.PersonDTO;

public interface  ReadWriteToBinaryService {
    HashMap<String, PersonDTO> readFile();
    void writeFile(HashMap<String, PersonDTO> temp);
}