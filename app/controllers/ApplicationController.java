package controllers;

import java.io.IOException;
import java.util.List;

import models.Application;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;

import play.*;
import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.*;
import views.html.index;

public class ApplicationController extends Controller {

	public static Result index(){
//		ObjectNode jsonResult = Json.newObject();
		List<models.Application> apps = models.Application.find.all();
		Logger.debug("应用列表:" + apps);
		
		ObjectMapper mapper = new ObjectMapper();
		FilterProvider filters = new SimpleFilterProvider().addFilter("app-list", SimpleBeanPropertyFilter.serializeAllExcept("modules"));
		
		String json = null;
		try {
			json = mapper.writer(filters).writeValueAsString(apps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok(json);
	}
	
	public static Result show(Long id){
		Application app = models.Application.find.byId(id);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(app);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		return ok(index.render("123"));
	}
}
