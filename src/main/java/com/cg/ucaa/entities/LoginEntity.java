package com.cg.ucaa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "logins")
public class LoginEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * primary-key uniquely assigned to applicant/staff member/admission committee member
	 */
	@Id
	@Column(name = "login_id")
	private Long loginId;

	/**
	 * user name cannot be null/blank
	 **/
	@Column(name = "username", length = 20)
	private String userName;
	
	/**
	 * password cannot be null/blank
	 **/
	@Column(name = "password", length = 20, unique = true)
	private String password;
	
	/**
	 * mapped with University Entity(One-to-many)
	 */
	@OneToOne
	@JoinColumn(name = "ustaff_validator")
	private UniversityStaffMemberEntity staffMember;
	
	/**
	 * mapped with Applicant Entity(One-to-many)
	 */
	@OneToOne
	@JoinColumn(name="applicant_validator")
	private ApplicantEntity applicant;
	
	/**
	 * mapped with Admission Committee Entity(One-to-many)
	 */
	@OneToOne
	@JoinColumn(name="admission_commitee_validator")
	private AdmissionCommiteeMemberEntity admissionCommiteeMember;
	

	/**
	 * default constructor
	 **/
	public LoginEntity() {
		/* no implementation */
	}
	
	/**
	 * parameterized constructor
	 **/
	public LoginEntity(Long loginId, String userName, String password) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;

	}
	
	/**
	 * corresponding getters and setters
	 */
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

	public ApplicantEntity getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantEntity applicant) {
		this.applicant = applicant;
	}

	public UniversityStaffMemberEntity getStaffMember() {
		return staffMember;
	}

	public void setStaffMember(UniversityStaffMemberEntity staffMember) {
		this.staffMember = staffMember;
	}

	public AdmissionCommiteeMemberEntity getAdmissionCommiteeMember() {
		return admissionCommiteeMember;
	}

	public void setAdmissionCommiteeMember(AdmissionCommiteeMemberEntity admissionCommiteeMember) {
		this.admissionCommiteeMember = admissionCommiteeMember;
	}
	
	/**
	 * overriding hashCode and equals methods
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admissionCommiteeMember == null) ? 0 : admissionCommiteeMember.hashCode());
		result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((staffMember == null) ? 0 : staffMember.hashCode());
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
		LoginEntity other = (LoginEntity) obj;
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (staffMember == null) {
			if (other.staffMember != null)
				return false;
		} else if (!staffMember.equals(other.staffMember))
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
	 */
	@Override
	public String toString() {
		return String.format("LoginEntity [loginId=%s, userName=%s, password=%s]", loginId, userName, password);
	}

}
