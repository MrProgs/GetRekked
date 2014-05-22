package edu.scranton.getrekked.client;

import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class UserIMS implements EntryPoint {
   /**
    * This is the entry point method.
    */
   public void onModuleLoad() {
	  HashMap<String,String> intent = new HashMap<String,String>();
	  intent.put("Action", "login");
	  System.out.println("UserIMS");
      AppController.instance().go(intent);
   }
}
