package com.app.auth.conf.db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "db")
public class DBProperties {
    private String url;
    private String username;
    private String password;
}
