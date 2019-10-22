package com.bsc.jerseyproject.rest.controllers;

import java.util.Stack;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.sun.jersey.spi.resource.Singleton;


@Path("stack")
@Singleton
public class StackController {
	private Stack<String> stack;
	public StackController() {
		this.stack = new Stack<>();
	}
	@GET
	public String getStack() {
		return stack.toString();
	}
	
	@GET
	@Path("/push")
	public String push(@QueryParam("value") String value) {
		stack.push(value);
		return stack.toString();
	}
	
	@GET()
	@Path("/pop")
	public String pop() {
		if(!stack.isEmpty()) {
			stack.pop();
		}		
		return stack.toString();
	}
	@GET
	@Path("/remove")
	public String remove(@QueryParam("index") int index) {
		if(stack.size() > index && index >= 0) {
			stack.remove(index);
		}		
		return stack.toString();
	}
}
