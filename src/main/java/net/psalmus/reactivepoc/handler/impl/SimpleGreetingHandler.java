/*
 * Copyright © ShiwaForce.com 2012 - 2019.
 *
 * All rights reserved.
 * Unauthorized using, copying, distributing or providing this program`s
 * source code is prohibited.
 */
package net.psalmus.reactivepoc.handler.impl;

import net.psalmus.reactivepoc.dto.ResponseDTO;
import net.psalmus.reactivepoc.handler.api.GreetingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Simply implements the {@link GreetingHandler} interface
 *
 * @author Bence DEMETER
 * @since 2019/07/10
 */
@Component("GreetingHandler")
public class SimpleGreetingHandler implements GreetingHandler {

    private static final Logger log = LoggerFactory.getLogger(SimpleGreetingHandler.class);

    @Override
    public Mono<ServerResponse> hello(ServerRequest request) {
        log.info("Handling hello request");
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .body(BodyInserters.fromObject(new ResponseDTO("Hello, Bob!")));
    }

    @Override
    public Mono<ServerResponse> bello(ServerRequest request) {
        log.info("Handling hellobello request");
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .body(BodyInserters.fromObject(new ResponseDTO("Hello bello, Bob!")));
    }

}
