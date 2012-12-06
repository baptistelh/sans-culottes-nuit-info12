package controllers;

import play.*;
import play.cache.Cache;
import play.db.jpa.Model;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {
    
    public static void about() {
        render();
    }
    
 // lists all tweets ordered descendant & cache it
 	public static void index() {
 		
 		List<Ville> villes = (List<Ville>)Cache.get("current"+session.getId());
 		if(villes == null){
 			villes = Ville.all().fetch();
 			Cache.set("current"+session.getId(), villes, "10mn");
 		}
 		
 		render(villes);
 	}

}