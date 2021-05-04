package com.cg.ucaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ucaa.entities.AdmissionCommiteeMemberEntity;

@Repository
public interface IAdmissionCommiteeMemberRepository extends JpaRepository<AdmissionCommiteeMemberEntity, Long> {

}
