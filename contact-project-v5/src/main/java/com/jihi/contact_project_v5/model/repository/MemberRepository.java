package com.jihi.contact_project_v5.model.repository;

import com.jihi.contact_project_v5.model.member.MemberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<MemberEntity, String> { }