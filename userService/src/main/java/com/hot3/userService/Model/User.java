package com.hot3.userService.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@RequiredArgsConstructor
public class User {

//    @Id // todo : How to automatically create the unique user Id ?
    // todo : how to make email field always unique  ?
    private String id;
    private String name;
    private String email;
}
