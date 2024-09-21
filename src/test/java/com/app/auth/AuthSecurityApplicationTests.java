package com.app.auth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

class AuthSecurityApplicationTests {

    @Test
    void contextLoads() {
        try (MockedStatic<SpringApplication> utilities = Mockito.mockStatic(SpringApplication.class)) {
            utilities.when((MockedStatic.Verification) SpringApplication.run(AuthSecurityApplication.class, new String[]{})).thenReturn(null);
            AuthSecurityApplication.main(new String[]{});
            Assertions.assertThat(SpringApplication.run(AuthSecurityApplication.class)).isNull();
        }
    }
}
