package com.tecomerce.mic.authorizationserver.repository.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "authorities")
public class AuthorityDocument {

    private String id;
    private String name;
}
