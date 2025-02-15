# project
# Auto detect text files and perform LF normalization
* text=auto
$ git init
package com.jihi.contact_project_v5.controller;

import com.jihi.contact_project_v5.projection.ContactProjection;
import com.jihi.contact_project_v5.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class ContactController {
    @Autowired
    private ContactRepository memberRepository;

    @GetMapping("/")
    public String contacts(Model model) {
        List<ContactProjection> contacts = this.memberRepository.getAllContacts();
        for (ContactProjection contact: contacts) {
            log.warn(contact.getName());
        }
        model.addAttribute("contacts", contacts);
        return "contacts";
    }
}
package com.jihi.contact_project_v5.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="members_contacts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactEntity {
    @Id
    @Column(name="memberid")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phoneNumber;

    @Column(name="moimname")
    private String relationship;
}
package com.jihi.contact_project_v5.projection;

public interface ContactProjection {
    String getMemberid();
    String getName();
    String getPhone();
    String getAddress();
    String getMoimname();
}
package com.jihi.contact_project_v5.repository;

import com.jihi.contact_project_v5.model.entity.ContactEntity;
import com.jihi.contact_project_v5.projection.ContactProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {
    final String GET_ALL_CONTACTS =
            "with contacts as ( " +
                    "select mc.contactid, " +
                    "   mc.name, " +
                    "   mc.phone, " +
                    "   mc.address, " +
                    "   m.moimname  " +
                    "  from memberscontacts mc " +
                    " inner join moim m " +
                    "  on mc.moimid = m.moimid " +
                    "),  " +
                    "map_contacts as ( " +
                    "select m.memberid, " +
                    "   c.name, " +
                    "   c.phone, " +
                    "   c.address, " +
                    "   c.moimname " +
                    "from membercontactmap m " +
                    "   inner join contacts c " +
                    "      on m.contactid = c.contactid " +
                    "), " +
                    "members_contacts as ( " +
                    "select m.memberid, " +
                    "   mc.name, " +
                    "   mc.phone, " +
                    "   mc.address, " +
                    "   mc.moimname " +
                    "  from member m " +
                    " inner join map_contacts mc " +
                    " on m.memberid = mc.memberid " +
                    ")" +
                    "select *" +
                    "  from members_contacts";
    @Query(value = GET_ALL_CONTACTS, nativeQuery = true)
    List<ContactProjection> getAllContacts();
}
package com.jihi.contact_project_v5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactProjectV5Application {

	public static void main(String[] args) {
		SpringApplication.run(ContactProjectV5Application.class, args);
	}

}
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>연락처</title>
</head>
<body>
<h1>연락처</h1>
<table border="1">
    <thead>
    <tr>
        <th>이름</th>
        <th>번호</th>
        <th>주소</th>
        <th>관계</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        {{#contacts}}
            <th>{{name}}</th>
            <th>{{phone}}</th>
            <th>{{address}}</th>
            <th>{{moimname}}</th>
        {{/contacts}}
    </tr>
    </tbody>

</table>
</body>
</html>
spring.application.name=contact-project-v5
server.servlet.encoding.force=true
# MySQL Database ??
spring.datasource.url=jdbc:mysql://localhost:3306/contact?serverTimezone=UTC&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=doitmysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA ??
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
(master)
