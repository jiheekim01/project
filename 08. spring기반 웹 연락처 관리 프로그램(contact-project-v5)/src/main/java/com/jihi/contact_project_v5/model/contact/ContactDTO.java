package com.jihi.contact_project_v5.model.contact;

import lombok.Data;

@Data // getter, setter, toString
public class ContactDTO {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String relationship;
    private String memberId;

    // 가지고 있는 정보로 연락처 entity 생성과 반환
    public ContactEntity toEntity() {
        return new ContactEntity(this.id,
                this.name, // 이름
                this.phoneNumber, // 전화번호
                this.address, // 주소
                this.relationship, // 관계
                this.memberId); //아이디
    }
}
