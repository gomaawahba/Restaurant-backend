package com.ahmed.config;


import com.ahmed.model.Category;
import com.ahmed.model.Order;

import com.ahmed.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class DataRestApiConfig implements RepositoryRestConfigurer {


    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] preventMethod = {HttpMethod.GET,HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE};

        disableHttpMethod(Category.class,config,preventMethod);
        disableHttpMethod(Order.class,config,preventMethod);
        disableHttpMethod(User.class,config,preventMethod);
        disableHttpMethod(User.class,config,preventMethod);
      //  disableHttpMethod(User.class,config,preventMethod);
      //  disableHttpMethod(Authorities.class,config,preventMethod);

    }
    private void disableHttpMethod(Class theClass, RepositoryRestConfiguration config,HttpMethod[] unsupportedMethod){
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedMethod)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedMethod));
    }
}