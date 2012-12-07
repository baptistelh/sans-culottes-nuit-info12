package controllers;

import play.*;
import play.mvc.*;

@With(Secure.class)
public class Admin extends Controller {
	
	public static void index() {
		render();
	}
}
