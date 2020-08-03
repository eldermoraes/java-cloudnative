package com.eldermoraes;

import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessProbe implements HealthCheck {

    @Inject
    @RestClient
    TimeService timeservice;

    @Override
    public HealthCheckResponse call() {        

        if (timeservice.getTime() == null){
            return HealthCheckResponse.down("espera aí...");
        } else{
            return HealthCheckResponse.up("estoy listo!");
        }
        
    }
    
}