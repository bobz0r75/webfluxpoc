/*
 * Copyright © ShiwaForce.com 2012 - 2019.
 *
 * All rights reserved.
 * Unauthorized using, copying, distributing or providing this program`s
 * source code is prohibited.
 */
package net.psalmus.reactivepoc.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * A generic response DTO
 *
 * @author Bence DEMETER
 * @since 2019/07/10
 */
public class ResponseDTO implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = -6173275953924319789L;

    private String response;

    /**
     * Instantiates the object
     *
     * @param response The response
     */
    @JsonCreator
    public ResponseDTO(@JsonProperty("response") String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

}
