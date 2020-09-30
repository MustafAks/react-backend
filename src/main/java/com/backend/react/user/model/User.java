package com.backend.react.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, unique = true, updatable = false, length = 36)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;


    @Column(name = "repeat_password")
    private String repeatPassword;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "aggre")
    private Boolean aggre;

    @Column(name = "image")
    private String image;


    public User(String userName, String password, String repeatPassword, String displayName, Boolean aggre) {
        this.userName = userName;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.displayName = displayName;
        this.aggre = aggre;
    }
}
