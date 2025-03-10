package com.candidatsae.candidat4sae8;


import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    @Bean
    public Keycloak keycloakAdminClient() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("Job_Board_Realm")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("candidat-client")
                .clientSecret("zrU1lWejFYf4jks5FU7YshopzcaNI1nt")
                .build();
    }
}
