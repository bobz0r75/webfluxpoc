/*
 * Copyright © ShiwaForce.com 2012 - 2019.
 *
 * All rights reserved.
 * Unauthorized using, copying, distributing or providing this program`s
 * source code is prohibited.
 */
package net.psalmus.webfluxpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The application's main class
 *
 * @author Bence DEMETER
 * @since 2019/07/10
 */
@SpringBootApplication
public class ReactivePocApplication {

    /**
     * The main method og the application
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ReactivePocApplication.class, args);
    }
}
