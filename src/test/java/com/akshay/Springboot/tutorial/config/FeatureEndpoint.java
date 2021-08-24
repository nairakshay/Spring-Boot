package com.akshay.Springboot.tutorial.config;

import jdk.jfr.DataAmount;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="features")
public class FeatureEndpoint {

    private final Map<String,Feature> featureMap=new ConcurrentHashMap<>();

    public FeatureEndpoint() {

        featureMap.put("Department", new Feature(isEnabled:true));
        featureMap.put("User", new Feature(isEnabled:false));
        featureMap.put("Authentication", new Feature(isEnabled:false));
    }

    @ReadOperation
    public Map<String, Feature> features(){

        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName){

        return featureMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {

        private boolean isEnabled;
    }
}
