package com.cg.ucaa.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cg.ucaa.entities.AdmissionCommiteeMemberEntity;
import com.cg.ucaa.entities.ApplicantEntity;
import com.cg.ucaa.entities.UniversityStaffMemberEntity;

public class LoginModel {
	
	/**
	 * primary key
	 */
	@NotNull(message = "login Id cannot be null")
	private Long loginId;
	
	/**
	 * user name cannot be null/blank
	 **/
	@NotNull(message = "user name cannot be null")
	@NotBlank(message = "user name cannot be blank")
	private String userName;
	
	/**
	 * password cannot be null/blank
	 **/
	@NotNull(message = "password cannot be null")
	@NotBlank(message = "password cannot be blank")
	private String password;

	private UniversityStaffMemberEntity member;
	
	private ApplicantEntity applicant;
	
	private AdmissionCommiteeMemberEntity admissionCommiteeMember;
	
	/**
	 * default constructor
	 **/
	public LoginModel() {
		/* no implementation */
	}
	
	/**
	 * parameterized constructor
	 **/
	public LoginModel(Long loginId, String userName, String password) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * corresponding getters and setters
	 **/
	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public UniversityStaffMemberEntity getMember() {
		return member;
	}

	public void setMember(UniversityStaffMemberEntity member) {
		this.member = member;
	}

	public ApplicantEntity getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantEntity applicant) {
		this.applicant = applicant;
	}

	public AdmissionCommiteeMemberEntity getAdmissionCommiteeMember() {
		return admissionCommiteeMember;
	}

	public void setAdmissionCommiteeMember(AdmissionCommiteeMemberEntity admissionCommiteeMember) {
		this.admissionCommiteeMember = admissionCommiteeMember;
	}
	
	/**
	 * over-riding equals and hashCode() methods
	 **/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admissionCommiteeMember == null) ? 0 : admissionCommiteeMember.hashCode());
		result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginModel other = (LoginModel) obj;
		if (admissionCommiteeMember == null) {
			if (other.admissionCommiteeMember != null)
				return false;
		} else if (!admissionCommiteeMember.equals(other.admissionCommiteeMember))
			return false;
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	/**
	 * corresponding toString() method
	 **/
	@Override
	public String toString() {
		return String.format("LoginModel [loginId=%s, userName=%s, password=%s]", loginId, userName, password);
	}


}