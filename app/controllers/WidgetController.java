package controllers;


import org.codehaus.jackson.map.ObjectMapper;

import models.Module;
import play.*;
import play.libs.Json;
import play.mvc.*;

public class WidgetController extends Controller {

	public static Result download(Long id) {
		return ok();
	}
	
	public static Result show(Long id) {
		Module m = Module.find.byId(id);
		
		String json = null;
		ObjectMapper om = new ObjectMapper();
		try {
			json = om.writeValueAsString(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok();
	}
}
