package com.bsc.camelrestproject.camel;

import javax.ws.rs.core.MediaType;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
class RestApi extends RouteBuilder {
	@Value("${server.port}")
	private int serverPort;
	
    @Override
    public void configure() {         
        restConfiguration() 
        .port(serverPort)
        .enableCORS(true)
        .apiContextPath("/api-doc")
        .apiProperty("api.title", "BSC REST API")
        .apiProperty("api.version", "v1")
        .apiContextRouteId("doc-api")
        .component("servlet");
        
        rest("/stack")
        .id("stack-get")
        .get().produces(MediaType.APPLICATION_JSON)
        .to("direct:Stack_getStack");
        
        rest("/stack/push")
        .id("stack-push")
        .get().produces(MediaType.APPLICATION_JSON)
        .param().name("value").type(RestParamType.query).description("value to be inserted").required(true).endParam()
        .to("direct:Stack_push");
        
        rest("/stack/pop")
        .id("stack-pop")
        .get().produces(MediaType.APPLICATION_JSON)
        .to("direct:Stack_pop");
        
        rest("/stack/remove")
        .id("stack-remove")
        .get().produces(MediaType.APPLICATION_JSON)
        .param().name("index").type(RestParamType.query).description("index from the item to be removed").required(true).endParam()
        .to("direct:Stack_remove");
        
        
        from("direct:Stack_getStack")
        .bean("StackProcessor", "getStack")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpStatus.OK.value()));
        
        
        from("direct:Stack_push")
        .bean("StackProcessor", "push(${header.value})")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpStatus.OK.value()));
        
        from("direct:Stack_pop")
        .bean("StackProcessor", "pop")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpStatus.OK.value()));
        
        from("direct:Stack_remove")
        .bean("StackProcessor", "remove(${header.index})")
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(HttpStatus.OK.value()));
    }
}
