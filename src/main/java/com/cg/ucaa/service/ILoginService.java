package com.cg.ucaa.service;

import com.cg.ucaa.exception.LoginFailedException;
import com.cg.ucaa.models.LoginModel;

public interface ILoginService {

	public String loginAsApplicant(LoginModel loginasApplicant) throws LoginFailedException;
	public String loginAsAdmissionCommiteeMember(LoginModel loginasMember) throws LoginFailedException;
	public String loginAsUniversityStaffMember(LoginModel loginasStaff) throws LoginFailedException;
	public boolean logOut(LoginModel login);
	
}
