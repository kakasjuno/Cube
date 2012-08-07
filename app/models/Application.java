package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.codehaus.jackson.map.annotate.JsonFilter;

import play.data.validation.*;

import play.db.ebean.Model;

@Entity
public class Application extends Model {

	@Id
	public Long id;

	@Constraints.Required
	public String identifier;

	public String name;

	@Constraints.Required
	public String version;
	
	public String iconFile;

	@ManyToMany
	public List<Module> modules;

	public static Finder<Long, Application> find = new Finder<Long, Application>(
			Long.class, Application.class);
}
