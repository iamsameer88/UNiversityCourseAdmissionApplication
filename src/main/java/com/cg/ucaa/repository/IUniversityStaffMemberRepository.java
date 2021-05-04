package com.cg.ucaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ucaa.entities.UniversityStaffMemberEntity;

@Repository
public interface IUniversityStaffMemberRepository extends JpaRepository<UniversityStaffMemberEntity, Long> {

}
