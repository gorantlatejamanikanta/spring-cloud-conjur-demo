package com.cyberark.conjur.plugintest.config;


import com.cyberark.conjur.springboot.annotations.ConjurPropertySource;
import com.cyberark.conjur.springboot.annotations.ConjurValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
@Configuration
@Primary
@ConfigurationProperties(prefix = "spring.datasource")
@ConjurPropertySource(value = {"data/demojenkinspolicy/demojenkinshost"})
public class ConjurSpringDbConfig extends DataSourceProperties {
    private static final Logger logger = LoggerFactory.getLogger(ConjurSpringDbConfig.class);

    @ConjurValue(key = "data/demojenkinspolicy/conjurdburl")
    private byte[] urlBytes;

    @ConjurValue(key = "data/demojenkinspolicy/conjurdbuser")
    private byte[] usernameBytes;

    @ConjurValue(key = "data/demojenkinspolicy/conjurdbpwd")
    private byte[] passwordBytes;

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();

        // Convert byte arrays to strings
        String url = new String(urlBytes);
        String username = new String(usernameBytes);
        String password = new String(passwordBytes);

        // Set the string values
        this.setUrl(url);
        this.setUsername(username);
        this.setPassword(password);

        // Print the Conjur values to the log
        logger.info("Conjur URL: " + url);
        logger.info("Conjur Username: " + username);
        logger.info("Conjur Password: " + password);
    }
}
