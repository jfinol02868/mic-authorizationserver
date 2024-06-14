package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("client")
@Entity(name = "clients")
public class ClientEntity {

    @Id
    private String id;
    private String clientId;
    private String clientSecret;

    @ManyToMany
    @JoinTable(
            name = "client_authentication_methods",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "authentication_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ClientAuthenticationMethodEntity> authenticationMethods;

    @ManyToMany
    @JoinTable(
            name = "client_authorization_grant_types",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "authorization_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<AuthorizationGrantTypeEntity> authorizationGrantTypes;

    @ManyToMany
    @JoinTable(
            name = "client_redirect_uris",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "redirecturi_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<RedirectUriEntity> redirectUris;

    @ManyToMany
    @JoinTable(
            name = "client_scopes",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "scopes_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ScopeEntity> scopes;
}
