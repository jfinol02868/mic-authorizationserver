package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.AuthorizationGrantTypeEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientAuthenticationMethodEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RedirectUriEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ScopeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T12:59:39+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ClientDocMapperImpl implements ClientDocMapper {

    @Override
    public Client toModel(ClientEntity client) {
        if ( client == null ) {
            return null;
        }

        Client.ClientBuilder client1 = Client.builder();

        client1.id( client.getId() );
        client1.clientId( client.getClientId() );
        client1.clientSecret( client.getClientSecret() );
        client1.authenticationMethods( clientAuthenticationMethodEntityListToClientAuthenticationMethodList( client.getAuthenticationMethods() ) );
        client1.authorizationGrantTypes( authorizationGrantTypeEntityListToAuthorizationGrantTypeList( client.getAuthorizationGrantTypes() ) );
        client1.redirectUris( redirectUriEntityListToRedirectUriList( client.getRedirectUris() ) );
        client1.scopes( scopeEntityListToScopeList( client.getScopes() ) );

        return client1.build();
    }

    @Override
    public ClientEntity toEntity(Client model) {
        if ( model == null ) {
            return null;
        }

        ClientEntity.ClientEntityBuilder clientEntity = ClientEntity.builder();

        clientEntity.id( model.getId() );
        clientEntity.clientId( model.getClientId() );
        clientEntity.clientSecret( model.getClientSecret() );
        clientEntity.authenticationMethods( clientAuthenticationMethodListToClientAuthenticationMethodEntityList( model.getAuthenticationMethods() ) );
        clientEntity.authorizationGrantTypes( authorizationGrantTypeListToAuthorizationGrantTypeEntityList( model.getAuthorizationGrantTypes() ) );
        clientEntity.redirectUris( redirectUriListToRedirectUriEntityList( model.getRedirectUris() ) );
        clientEntity.scopes( scopeListToScopeEntityList( model.getScopes() ) );

        return clientEntity.build();
    }

    @Override
    public List<Client> toModelList(List<ClientEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( entities.size() );
        for ( ClientEntity clientEntity : entities ) {
            list.add( toModel( clientEntity ) );
        }

        return list;
    }

    @Override
    public List<ClientEntity> toEntityList(List<Client> models) {
        if ( models == null ) {
            return null;
        }

        List<ClientEntity> list = new ArrayList<ClientEntity>( models.size() );
        for ( Client client : models ) {
            list.add( toEntity( client ) );
        }

        return list;
    }

    protected ClientAuthenticationMethod clientAuthenticationMethodEntityToClientAuthenticationMethod(ClientAuthenticationMethodEntity clientAuthenticationMethodEntity) {
        if ( clientAuthenticationMethodEntity == null ) {
            return null;
        }

        ClientAuthenticationMethod.ClientAuthenticationMethodBuilder clientAuthenticationMethod = ClientAuthenticationMethod.builder();

        clientAuthenticationMethod.id( clientAuthenticationMethodEntity.getId() );
        clientAuthenticationMethod.value( clientAuthenticationMethodEntity.getValue() );
        clientAuthenticationMethod.description( clientAuthenticationMethodEntity.getDescription() );

        return clientAuthenticationMethod.build();
    }

    protected List<ClientAuthenticationMethod> clientAuthenticationMethodEntityListToClientAuthenticationMethodList(List<ClientAuthenticationMethodEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientAuthenticationMethod> list1 = new ArrayList<ClientAuthenticationMethod>( list.size() );
        for ( ClientAuthenticationMethodEntity clientAuthenticationMethodEntity : list ) {
            list1.add( clientAuthenticationMethodEntityToClientAuthenticationMethod( clientAuthenticationMethodEntity ) );
        }

        return list1;
    }

    protected AuthorizationGrantType authorizationGrantTypeEntityToAuthorizationGrantType(AuthorizationGrantTypeEntity authorizationGrantTypeEntity) {
        if ( authorizationGrantTypeEntity == null ) {
            return null;
        }

        AuthorizationGrantType.AuthorizationGrantTypeBuilder authorizationGrantType = AuthorizationGrantType.builder();

        authorizationGrantType.id( authorizationGrantTypeEntity.getId() );
        authorizationGrantType.value( authorizationGrantTypeEntity.getValue() );
        authorizationGrantType.description( authorizationGrantTypeEntity.getDescription() );

        return authorizationGrantType.build();
    }

    protected List<AuthorizationGrantType> authorizationGrantTypeEntityListToAuthorizationGrantTypeList(List<AuthorizationGrantTypeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AuthorizationGrantType> list1 = new ArrayList<AuthorizationGrantType>( list.size() );
        for ( AuthorizationGrantTypeEntity authorizationGrantTypeEntity : list ) {
            list1.add( authorizationGrantTypeEntityToAuthorizationGrantType( authorizationGrantTypeEntity ) );
        }

        return list1;
    }

    protected RedirectUri redirectUriEntityToRedirectUri(RedirectUriEntity redirectUriEntity) {
        if ( redirectUriEntity == null ) {
            return null;
        }

        RedirectUri.RedirectUriBuilder redirectUri = RedirectUri.builder();

        redirectUri.id( redirectUriEntity.getId() );
        redirectUri.uri( redirectUriEntity.getUri() );
        redirectUri.description( redirectUriEntity.getDescription() );

        return redirectUri.build();
    }

    protected List<RedirectUri> redirectUriEntityListToRedirectUriList(List<RedirectUriEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<RedirectUri> list1 = new ArrayList<RedirectUri>( list.size() );
        for ( RedirectUriEntity redirectUriEntity : list ) {
            list1.add( redirectUriEntityToRedirectUri( redirectUriEntity ) );
        }

        return list1;
    }

    protected Scope scopeEntityToScope(ScopeEntity scopeEntity) {
        if ( scopeEntity == null ) {
            return null;
        }

        Scope.ScopeBuilder scope = Scope.builder();

        scope.id( scopeEntity.getId() );
        scope.name( scopeEntity.getName() );
        scope.description( scopeEntity.getDescription() );

        return scope.build();
    }

    protected List<Scope> scopeEntityListToScopeList(List<ScopeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Scope> list1 = new ArrayList<Scope>( list.size() );
        for ( ScopeEntity scopeEntity : list ) {
            list1.add( scopeEntityToScope( scopeEntity ) );
        }

        return list1;
    }

    protected ClientAuthenticationMethodEntity clientAuthenticationMethodToClientAuthenticationMethodEntity(ClientAuthenticationMethod clientAuthenticationMethod) {
        if ( clientAuthenticationMethod == null ) {
            return null;
        }

        ClientAuthenticationMethodEntity.ClientAuthenticationMethodEntityBuilder clientAuthenticationMethodEntity = ClientAuthenticationMethodEntity.builder();

        clientAuthenticationMethodEntity.id( clientAuthenticationMethod.getId() );
        clientAuthenticationMethodEntity.value( clientAuthenticationMethod.getValue() );
        clientAuthenticationMethodEntity.description( clientAuthenticationMethod.getDescription() );

        return clientAuthenticationMethodEntity.build();
    }

    protected List<ClientAuthenticationMethodEntity> clientAuthenticationMethodListToClientAuthenticationMethodEntityList(List<ClientAuthenticationMethod> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientAuthenticationMethodEntity> list1 = new ArrayList<ClientAuthenticationMethodEntity>( list.size() );
        for ( ClientAuthenticationMethod clientAuthenticationMethod : list ) {
            list1.add( clientAuthenticationMethodToClientAuthenticationMethodEntity( clientAuthenticationMethod ) );
        }

        return list1;
    }

    protected AuthorizationGrantTypeEntity authorizationGrantTypeToAuthorizationGrantTypeEntity(AuthorizationGrantType authorizationGrantType) {
        if ( authorizationGrantType == null ) {
            return null;
        }

        AuthorizationGrantTypeEntity.AuthorizationGrantTypeEntityBuilder authorizationGrantTypeEntity = AuthorizationGrantTypeEntity.builder();

        authorizationGrantTypeEntity.id( authorizationGrantType.getId() );
        authorizationGrantTypeEntity.value( authorizationGrantType.getValue() );
        authorizationGrantTypeEntity.description( authorizationGrantType.getDescription() );

        return authorizationGrantTypeEntity.build();
    }

    protected List<AuthorizationGrantTypeEntity> authorizationGrantTypeListToAuthorizationGrantTypeEntityList(List<AuthorizationGrantType> list) {
        if ( list == null ) {
            return null;
        }

        List<AuthorizationGrantTypeEntity> list1 = new ArrayList<AuthorizationGrantTypeEntity>( list.size() );
        for ( AuthorizationGrantType authorizationGrantType : list ) {
            list1.add( authorizationGrantTypeToAuthorizationGrantTypeEntity( authorizationGrantType ) );
        }

        return list1;
    }

    protected RedirectUriEntity redirectUriToRedirectUriEntity(RedirectUri redirectUri) {
        if ( redirectUri == null ) {
            return null;
        }

        RedirectUriEntity.RedirectUriEntityBuilder redirectUriEntity = RedirectUriEntity.builder();

        redirectUriEntity.id( redirectUri.getId() );
        redirectUriEntity.uri( redirectUri.getUri() );
        redirectUriEntity.description( redirectUri.getDescription() );

        return redirectUriEntity.build();
    }

    protected List<RedirectUriEntity> redirectUriListToRedirectUriEntityList(List<RedirectUri> list) {
        if ( list == null ) {
            return null;
        }

        List<RedirectUriEntity> list1 = new ArrayList<RedirectUriEntity>( list.size() );
        for ( RedirectUri redirectUri : list ) {
            list1.add( redirectUriToRedirectUriEntity( redirectUri ) );
        }

        return list1;
    }

    protected ScopeEntity scopeToScopeEntity(Scope scope) {
        if ( scope == null ) {
            return null;
        }

        ScopeEntity.ScopeEntityBuilder scopeEntity = ScopeEntity.builder();

        scopeEntity.id( scope.getId() );
        scopeEntity.name( scope.getName() );
        scopeEntity.description( scope.getDescription() );

        return scopeEntity.build();
    }

    protected List<ScopeEntity> scopeListToScopeEntityList(List<Scope> list) {
        if ( list == null ) {
            return null;
        }

        List<ScopeEntity> list1 = new ArrayList<ScopeEntity>( list.size() );
        for ( Scope scope : list ) {
            list1.add( scopeToScopeEntity( scope ) );
        }

        return list1;
    }
}
