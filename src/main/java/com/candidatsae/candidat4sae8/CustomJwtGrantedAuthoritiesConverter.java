package com.candidatsae.candidat4sae8;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomJwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {

        System.out.println("JWT Claims: " + jwt.getClaims());


        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
        if (resourceAccess != null && resourceAccess.containsKey("candidat-client")) {
            Map<String, Object> clientAccess = (Map<String, Object>) resourceAccess.get("candidat-client");
            List<String> roles = (List<String>) clientAccess.get("roles");

            System.out.println("Extracted Roles: " + roles);

            if (roles != null) {
                return roles.stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // Prefix with ROLE_
                        .collect(Collectors.toList());
            }
        }

        return List.of();
    }
}
