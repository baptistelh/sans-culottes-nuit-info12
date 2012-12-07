package controllers;

import models.*;

public class Security extends Secure.Security{
	
	static boolean authenticate(String username, String password) {
        return (username.equals("revolution") && password.equals("bastille"));
		//return true;
    }
    
	/*static boolean check(String profile) {
	    if("admin".equals(profile)) {
	        return User.find("byEmail", connected()).<User>first().isAdmin;
	    }
	    return false;
	}*/
	
	static void onDisconnected() {
	    Application.index();
	}
	
	static void onAuthenticated() {
	    Admin.index();
	}

}
