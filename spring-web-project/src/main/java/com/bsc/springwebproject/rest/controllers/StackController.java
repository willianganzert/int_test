package com.bsc.springwebproject.rest.controllers;

import java.util.Stack;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/stack")
public class StackController {
	private Stack<String> stack;
	public StackController() {
		this.stack = new Stack<>();
	}
	
	@GetMapping
	public String getStack() {
		return stack.toString();
	}
	
	@GetMapping("/push")
	public String push(@RequestParam("value") String value) {
		stack.push(value);
		return stack.toString();
	}
	
	@GetMapping("/pop")
	public String pop() {
		if(!stack.isEmpty()) {
			stack.pop();
		}		
		return stack.toString();
	}
	@GetMapping("/remove")
	public String pop(@RequestParam("index") int index) {
		if(stack.size() > index && index >= 0) {
			stack.remove(index);
		}		
		return stack.toString();
	}
}
