package com.eldermoraes;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/gateway")
public class ExampleResource {

    @Inject    
    @RestClient
    TimeService timeservice;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted
    public String hello() {
        return "gateway => " + getFromClient();
    }

    @Timed
    public String getFromClient(){
        return "gateway => " + timeservice.getTime();
    }
}