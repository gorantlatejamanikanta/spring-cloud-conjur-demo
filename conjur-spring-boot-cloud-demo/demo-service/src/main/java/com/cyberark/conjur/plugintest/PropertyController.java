package com.cyberark.conjur.plugintest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyberark.conjur.springboot.annotations.ConjurPropertySource;

@RestController
@RequestMapping("/api")
@ConjurPropertySource(value={"data/demojenkinspolicy/"})
public class PropertyController {

    private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @Value("${demojenkinspwd}")
    private byte[]userProperty;

    @GetMapping("/getUserProperty")
    public String getUserProperty() {

        logger.info("Retrieved property value via API call: " + new String(userProperty));
        return new String(userProperty);
    }
}



