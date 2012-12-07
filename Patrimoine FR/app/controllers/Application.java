package controllers;


import java.util.List;

import play.cache.Cache;
import play.mvc.Controller;
import models.*;

public class Application extends Controller {
    
	public static void showMonument(Long id) {
		List<Ville> villes = Ville.find("order by nom_ville desc").fetch();
    	Monument monument = Monument.findById(id);
    	render(monument, villes);
    }
	
    public static void showVille(Long id) {
    	List<Ville> villes = Ville.find("order by nom_ville desc").fetch();
    	Ville ville = Ville.findById(id);
    	render(ville, villes);
    }
    
    public static void about() {
        render();
    }
    
 	public static void index() {
 		
 		/*List<Ville> villes = (List<Ville>)Cache.get("current"+session.getId());
 		if(villes == null){
 			villes = Ville.all().fetch();
 			Cache.set("current"+session.getId(), villes, "10mn");
 		}*/
 		
 		List<Ville> villes = Ville.find("order by nom_ville desc").fetch();
 		render(villes);
 	}

}