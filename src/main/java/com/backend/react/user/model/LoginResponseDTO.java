package com.backend.react.user.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {

    private String username;
    private String displayname;
    private String image;

    public LoginResponseDTO(String username, String displayname, String image) {
        super();
        this.username = username;
        this.displayname = displayname;
        this.image = image;

    }
}
