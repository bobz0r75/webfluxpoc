/*
 * Copyright © ShiwaForce.com 2012 - 2019.
 *
 * All rights reserved.
 * Unauthorized using, copying, distributing or providing this program`s
 * source code is prohibited.
 */
package net.psalmus.reactivepoc.dto;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the {@link ResponseDTO} class
 *
 * @author Bence DEMETER
 * @since 2019/07/11
 */
public class ResponseDtoTest {

    private static final int TEST_STRING_LENGTH = 64;

    private String testString;

    @Before
    public void initTest() {
        testString = RandomStringUtils.randomAlphanumeric(TEST_STRING_LENGTH);
    }

    @Test
    public void canInstantiateProperly() {
        var responseDTO = new ResponseDTO(testString);
        assertNotNull(responseDTO);
        assertSame(testString, responseDTO.getResponse());
    }

}
