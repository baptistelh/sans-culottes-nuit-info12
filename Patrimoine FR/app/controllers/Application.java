package controllers;


import java.util.List;

import play.cache.Cache;
import play.mvc.Controller;
import models.*;

public class Application extends Controller {
    
    public static void about() {
        render();
    }
    
 	public static void index() {
 		
 		List<Ville> villes = (List<Ville>)Cache.get("current"+session.getId());
 		if(villes == null){
 			villes = Ville.all().fetch();
 			Cache.set("current"+session.getId(), villes, "10mn");
 		}
 		
 		render(villes);
 	}

}