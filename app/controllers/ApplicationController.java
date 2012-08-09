package controllers;

import java.io.IOException;
import java.util.List;

import models.Application;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import views.html.index;

public class ApplicationController extends Controller {

	public static Result index(){
////		ObjectNode jsonResult = Json.newObject();
//		List<models.Application> apps = models.Application.find.all();
//		Logger.debug("应用列表:" + apps);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		FilterProvider filters = new SimpleFilterProvider().addFilter("app-list", SimpleBeanPropertyFilter.serializeAllExcept("modules"));
//		
//		String json = null;
//		try {
//			json = mapper.writer(filters).writeValueAsString(apps);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		return ok(json);
		return ok();
	}
	
	@Transactional(readOnly=true)
	public static Result show(String identifier, String scope){
		
		Logger.debug(String.format("show applicaton[%s] scope:%s", identifier, scope));
		
		Application app = models.Application.findyByIdentifier(identifier);
		if (app == null) {
			return notFound();
		}

		Gson gson = new GsonBuilder()
		.setPrettyPrinting()
		.setExclusionStrategies(new ExclusionStrategy() {
			@Override
			public boolean shouldSkipField(FieldAttributes f) {
				if ("applications".equals(f.getName()) && f.getDeclaringClass() == models.Widget.class) {
					return true;
				}
				return false;
			}
			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				return false;
			}
		})
		.create();
		String jsonString = gson.toJson(app);
		
		return ok(jsonString);
	}
}
