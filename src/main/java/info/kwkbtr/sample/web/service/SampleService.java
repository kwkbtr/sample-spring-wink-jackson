package info.kwkbtr.sample.web.service;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/")
public class SampleService implements Service {
	
	public static class Request {
		public String request;
	}
	
	public static class Result {
		public String result;
		public Result(String result) { this.result = result; }
	}
	
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	@POST
	public Result post(Request request) {
		return new Result(request.request);
	}
	
}
