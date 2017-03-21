package com.optum.devopscoaching.atdd;

public class AuthenticateSearchSystemUser {

	public boolean isUserAdminstrator ( String userId, String password)
	{
		if (userId == "Mehul")
		return true;
		else
		return false;
	}
}
