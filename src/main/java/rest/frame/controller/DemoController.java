package rest.frame.controller;

import org.restexpress.Request;
import org.restexpress.Response;

import rest.frame.domain.Domain;

public class DemoController {
	public String read(Request request, Response response) {
		String myName = "Dhanushanth";
		return myName;
	}

	public String create(Request request, Response response) {
		Domain d = request.getBodyAs(Domain.class);
		return d.getDataIn();

	}
}
