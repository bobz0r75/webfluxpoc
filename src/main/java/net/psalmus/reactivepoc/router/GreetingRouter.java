/*
 * Copyright © ShiwaForce.com 2012 - 2019.
 *
 * All rights reserved.
 * Unauthorized using, copying, distributing or providing this program`s
 * source code is prohibited.
 */
package net.psalmus.reactivepoc.router;

import net.psalmus.reactivepoc.handler.api.GreetingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Routes requests to the Greeting handler
 *
 * @author Bence DEMETER
 * @since 2019/07/10
 */
@Configuration
public class GreetingRouter {

    private static final Logger log = LoggerFactory.getLogger(GreetingRouter.class);

    private static final String HELLO_ROUTE = "/hello";
    private static final String BELLO_ROUTE = "/bello";

    /**
     * Routes a request to the Greeting handler
     *
     * @param greetingHandler The greeting handler
     * @return The routing function
     */
    @Bean
    public RouterFunction<ServerResponse> helloRoute(GreetingHandler greetingHandler) {
        log.info("Creating router function to url {}", HELLO_ROUTE);
        return RouterFunctions.route(
            RequestPredicates.GET(HELLO_ROUTE).and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),
            greetingHandler::hello
        );
    }

    /**
     * Routes another request to the Greeting handler
     *
     * @param greetingHandler The greeting handler
     * @return The routing function
     */
    @Bean
    public RouterFunction<ServerResponse> belloRoute(GreetingHandler greetingHandler) {
        log.info("Creating router function to url {}", BELLO_ROUTE);
        return RouterFunctions.route(
            RequestPredicates.GET(BELLO_ROUTE).and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),
            greetingHandler::bello
        );
    }

}
