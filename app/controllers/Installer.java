package controllers;

import models.Widget;
import play.*;
import play.mvc.*;

import views.html.*;

public class Installer extends Controller {
  
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }
  
  public static Result install() {
//	  models.Application a1 = new models.Application();
//	  a1.name = "客舱移动";
//	  a1.identifier = "iCabin";
//	  a1.version = "3.0";
//	  a1.save();
//	  
//	  models.Application a2 = new models.Application();
//	  a2.identifier = "iStation";
//	  a2.name = "站长移动";
//	  a2.version = "0.1EA";
//	  a2.save();
//	  
//	  models.Application a3 = new models.Application();
//	  a3.identifier = "iBiz";
//	  a3.name = "商务移动";
//	  a3.version = "1.3";
//	  a3.save();
//	  
//	  Widget m1 = new Widget();
//	  m1.identifier = "Passenger";
//	  m1.name = "旅客列表";
//	  m1.version = "1.0";
//	  m1.save();
//	  
//	  Widget m2 = new Widget();
//	  m2.identifier = "Weather";
//	  m2.name = "天气预报";
//	  m2.version = "1.0.Beta";
//	  
//	  Widget m3 = new Widget();
//	  m3.identifier = "Report";
//	  m3.name = "主动预警";
//	  m3.version = "1.0.GA";
	  
	  return ok();
  }
}