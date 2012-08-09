package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.jpa.JPA;

@Entity
public class Widget {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;
    
    public String identifier;
    
    public String name;
    
    public String version;
    
    public int build;
    
    public String releaseNote;
    
	public String platform;
    
    @ManyToMany(mappedBy = "widgets")
    public List<Application> applications;
    
	public static List<Widget> all() {
		return JPA.em().createQuery("from Widget", Widget.class).getResultList();
	}
    
    public void save() {
		JPA.em().persist(this);
	}
	
	public void delete() {
		JPA.em().remove(this);
	}
	
	public static void deleteAll() {
		for (Widget w : all()) {
			w.delete();
		}
	}
}
