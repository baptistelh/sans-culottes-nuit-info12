package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Ville extends Model{
	
	@Required
	public String nom_ville;
	
	@Lob
	@MaxSize(10000)
	public String histo_ville;
	
	@Required
	public float lat_ville;
	
	@Required
	public float long_ville;
	
	@Required
	public long code_postal;
	
	@Required
	public String img_path_ville;
	
	@OneToMany(mappedBy="ville", cascade=CascadeType.ALL)
	public List<Monument> monuments;	
	
	public String toString() {
		return nom_ville;
	}
	
	public Ville(String nom_ville, String histo_ville, float lat_ville, float long_ville, long code_postal, String img_path_ville){
		this.nom_ville = nom_ville;
		this.histo_ville = histo_ville;
		this.lat_ville = lat_ville;
		this.long_ville = long_ville;
		this.code_postal = code_postal;
		this.img_path_ville = img_path_ville;
		this.monuments = new ArrayList<Monument>();
	}
	
	public Ville(String nom_ville, float lat_ville, float long_ville, long code_postal, String img_path_ville){
		this(nom_ville, null, lat_ville, long_ville, code_postal, img_path_ville);
	}
}

