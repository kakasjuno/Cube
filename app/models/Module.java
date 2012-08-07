package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Module extends Model{

	@Id
    public Long id;
    
	@Constraints.Required
    public String identifier;
    
    public String name;
    
    @Constraints.Required
    public String version;
    
    @ManyToMany
    public List<Application> applications;
    
    public static Finder<Long, Module> find = new Finder<Long, Module>(
			Long.class, Module.class);
}
