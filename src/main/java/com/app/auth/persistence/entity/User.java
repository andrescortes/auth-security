package com.app.auth.persistence.entity;

import com.app.auth.util.Role;
import com.app.auth.util.RolePermission;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "users_app")
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (Objects.nonNull(role) && Objects.nonNull(role.getRolePermissions())) {
            return role.getRolePermissions()
                    .stream()
                    .map(RolePermission::name)
                    .map(SimpleGrantedAuthority::new)
                    .toList();
        }
        return Collections.emptyList();
    }
}
