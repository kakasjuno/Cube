package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import play.db.jpa.JPA;

@Entity
public class Application {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;

	@Column
	public String identifier;

	@Column
	public String name;

	@Column
	public String version;
	
	@Column
	public int build;
	
	@Column
	public String releaseNote;
	
	@Column
	public String platform;
	
	@Column
	public String icon;

	@ManyToMany
	public List<Widget> widgets;
	
	public static List<Application> all() {
		return JPA.em().createQuery("from Application", Application.class).getResultList();
	}

	public static Application findyByIdentifier(String identifier) {
		String jpql = String.format("from Application a where a.identifier = '%s'", identifier); 
		TypedQuery<Application> query = JPA.em().createQuery(jpql, Application.class);
		return query.getSingleResult();
	}
	
	public void save() {
		JPA.em().persist(this);
	}
	
	public void delete() {
		JPA.em().remove(this);
	}
	
	public static void deleteAll() {
		for (Application app : all()) {
			app.delete();
		}
	}
}
