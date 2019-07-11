/*
 * Copyright © ShiwaForce.com 2012 - 2019.
 *
 * All rights reserved.
 * Unauthorized using, copying, distributing or providing this program`s
 * source code is prohibited.
 */
package net.psalmus.webfluxpoc.handler.api;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Performs a greeting
 *
 * @author Bence DEMETER
 * @since 2019/07/11
 */
public interface GreetingHandler {

    /**
     * Handles a Hello World request
     *
     * @param request The request
     * @return The response Mono
     */
    Mono<ServerResponse> hello(ServerRequest request);

    /**
     * Handles a Hello Bello World request
     *
     * @param request The request
     * @return The response Mono
     */
    Mono<ServerResponse> bello(ServerRequest request);

}
