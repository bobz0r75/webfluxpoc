/*
 * Copyright © ShiwaForce.com 2012 - 2019.
 *
 * All rights reserved.
 * Unauthorized using, copying, distributing or providing this program`s
 * source code is prohibited.
 */
package net.psalmus.reactivepoc.router;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import net.psalmus.reactivepoc.dto.ResponseDTO;
import net.psalmus.reactivepoc.handler.api.GreetingHandler;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Tests the {@link GreetingRouter} class
 *
 * @author Bence DEMETER
 * @since 2019/07/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingRouterTest {

    private static final int TEST_STRING_LENGTH = 64;

    @MockBean
    private GreetingHandler greetingHandler;

    @Autowired
    private WebTestClient testClient;

    private String testString;

    @Before
    public void initTest() {
        testString = RandomStringUtils.randomAlphanumeric(TEST_STRING_LENGTH);
        when(greetingHandler.hello(any())).thenReturn(ServerResponse.ok()
            .body(BodyInserters.fromObject(new ResponseDTO(testString))));
        when(greetingHandler.bello(any())).thenReturn(ServerResponse.ok()
            .body(BodyInserters.fromObject(new ResponseDTO(testString))));
    }

    @Test
    public void testHelloRoute() {
        testClient.get().uri("/hello")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange()
            .expectStatus().is2xxSuccessful()
            .expectBody(ResponseDTO.class)
            .value(response -> assertEquals(testString, response.getResponse()));
    }

    @Test
    public void testBelloRoute() {
        testClient.get().uri("/bello")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange()
            .expectStatus().is2xxSuccessful()
            .expectBody(ResponseDTO.class)
            .value(response -> assertEquals(testString, response.getResponse()));
    }

}
