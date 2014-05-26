package rest.frame.controller;

import org.restexpress.Request;
import org.restexpress.Response;

public class DemoController {
	public String read(Request request, Response response) {
		String myName = "Dhanushanth";
		return myName;
	}

	public String create(Request request, Response response) {
		String myName = "dhanu";
		return myName;

	}
}
