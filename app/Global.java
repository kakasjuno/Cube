import java.util.ArrayList;

import models.Widget;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;

public class Global extends GlobalSettings {

	@Transactional
	@Override
	public void onStart(Application app) {
		Logger.info("Application has started");

		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable {
				testData();
			}
		});
	}

	protected void testData() {
		
		models.Application.deleteAll();
		models.Widget.deleteAll();
		
		models.Application a = new models.Application();
		a.identifier = "com.csair.amp";
		a.name = "移动保障";
		a.version = "1.0";
		a.build = 3;
		a.releaseNote = "first release";
		a.platform = "Android";
		a.save();
		
		Widget w1 = new Widget();
		w1.identifier = "com.csair.amp.wether";
		w1.name = "天气预报";
		w1.version = "1.0";
		w1.build = 1;
		w1.platform = "Android";
		w1.save();
		
		Widget w2 = new Widget();
		w2.identifier = "com.csair.amp.av";
		w2.name = "航班动态";
		w2.version = "1.0";
		w2.build = 1;
		w2.platform = "Android";
		w2.save();
		
		Widget w3 = new Widget();
		w3.identifier = "com.csair.amp.im";
		w3.name = "即时通信";
		w3.version = "1.0";
		w3.build = 1;
		w3.platform = "Android";
		w3.save();
		
		a.widgets = new ArrayList<Widget>();
		a.widgets.add(w1);
		a.widgets.add(w2);
		a.widgets.add(w3);
		a.save();
	}

	@Override
	public void onStop(Application app) {
		Logger.info("Application shutdown...");
	}
	
	
}
