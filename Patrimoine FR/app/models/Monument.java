package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
public class Monument extends Model {
 
	@Required
	public String nom_mon;
	
	@Lob
	@MaxSize(10000)
	public String histo_mon;
	
	@Required
	public double lat_mon;
	
	@Required
	public double long_mon;
	
	@Required
	@URL
	public String img_path_mon;
	
	@ManyToOne
    @Required
	public Ville ville;
	    
	public Monument(Ville ville, String nom_mon, double lat_mon, double long_mon, String img_path_mon) {
        this.ville = ville;
        this.nom_mon = nom_mon;
        this.lat_mon = lat_mon;
        this.long_mon = long_mon;
        this.img_path_mon = img_path_mon;
    }
	
    public Monument(Ville ville, String nom_mon, String histo_mon, double lat_mon, double long_mon, String img_path_mon) {
        this.ville = ville;
        this.nom_mon = nom_mon;
        this.histo_mon = histo_mon;
        this.lat_mon = lat_mon;
        this.long_mon = long_mon;
        this.img_path_mon = img_path_mon;
    }
    
    public String toString() {
    	return this.nom_mon + "-" + this.ville.nom_ville;
    }
    /*public Monument previous() {
    	return Monument.find("", ).first();
    }
    
    public Monument next() {
    	return Monument.find("", ).first();
    }*/
 
}