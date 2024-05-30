package com.tecomerce.mic.authorizationserver.repository.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("authority")
@Document(collection = "authorities")
public class AuthorityDocument {

    private String id;
    private String code;
    private String name;
}
