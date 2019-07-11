/*
 * Copyright © ShiwaForce.com 2012 - 2019.
 *
 * All rights reserved.
 * Unauthorized using, copying, distributing or providing this program`s
 * source code is prohibited.
 */
package net.psalmus.reactivepoc.handler.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.reactive.function.server.MockServerRequest;
import org.springframework.web.reactive.function.server.ServerRequest;

/**
 * Tests the {@link SimpleGreetingHandler} class
 *
 * @author Bence DEMETER
 * @since 2019/07/11
 */
public class SimpleGreetingHandlerTest {

    private SimpleGreetingHandler handler;
    private ServerRequest request;

    @Before
    public void initTest() {
        handler = new SimpleGreetingHandler();
        request = MockServerRequest.builder().method(HttpMethod.GET).build();
    }

    @Test
    public void canHandleHello() {
        var responseMono = handler.hello(request);
        var response = responseMono.block();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.statusCode());
    }

    @Test
    public void canHandleBello() {
        var responseMono = handler.bello(request);
        var response = responseMono.block();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.statusCode());
    }

}
