package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ucaa.entities.AdmissionEntity;
import com.cg.ucaa.models.AdmissionModel;
import com.cg.ucaa.repository.IAdmissionRepository;

@Service
public class EMParserAdmission {

	@Autowired
	private IAdmissionRepository admissionRepo;
	
	@Autowired
	private EMParserApplicant parser;
	
	@Autowired
	private EMParserCourse parserCourse;
	
	@Autowired
	private EMParserAdmissionCommiteeMember parserCommitee;

	public EMParserAdmission() {
		super();
		this.parser = new EMParserApplicant();
		this.parserCourse = new EMParserCourse();
		this.parserCommitee = new EMParserAdmissionCommiteeMember();
	}

	public EMParserAdmission(IAdmissionRepository admissionRepo) {
		super();
		this.admissionRepo = admissionRepo;
		this.parser = new EMParserApplicant();
		this.parserCourse = new EMParserCourse();
		this.parserCommitee = new EMParserAdmissionCommiteeMember();
	}

	public AdmissionModel parse(AdmissionEntity source) {
		return source == null ? null
				: new AdmissionModel(source.getAdmissionId().longValue(), source.getAdmissionDate(),
						source.getAdmissionStatus(),parserCourse.parse(source.getCourse()),parser.parse(source.getApplicant()),parserCommitee.parse(source.getAdmissionComMember()));
	}

	public AdmissionEntity parse(AdmissionModel source) {
		return source == null ? null
				: new AdmissionEntity(source.getAdmissionId().longValue(), source.getAdmissionDate(),
						source.getAdmissionStatus(),parserCourse.parse(source.getCourse()),parser.parse(source.getApplicant()),parserCommitee.parse(source.getAdmissionComMember()));
	}
}
