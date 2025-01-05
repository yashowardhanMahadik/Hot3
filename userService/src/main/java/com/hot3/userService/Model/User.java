package com.hot3.userService.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@RequiredArgsConstructor
public class User {

//    @Id // todo : How to automatically create the unique user Id ?
    // todo : how to make email field always unique  ?
    @Id
    private String id;
    @NotNull
    private String name;

    @NotNull
    @NotEmpty
    @Indexed(unique = true)
    private String email;
}
