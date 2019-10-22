package com.bsc.camelrestproject.camel.beanprocessors;

import java.util.Stack;

import org.springframework.stereotype.Component;

@Component("StackProcessor")
public class StackProcessor {
	private Stack<String> stack;
	public StackProcessor() {
		this.stack = new Stack<>();
	}
	
	public Object getStack() {
		return this.stack.toString();
	}
	
	public Object push(String value) {
		stack.push(value);
		return stack.toString();
	}
	
	public Object pop() {
		if(!stack.isEmpty()) {
			stack.pop();
		}		
		return stack.toString();
	}
	public Object remove(int index) {
		if(stack.size() > index && index >= 0) {
			stack.remove(index);
		}		
		return stack.toString();
	}
}
