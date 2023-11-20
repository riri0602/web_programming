package com.example.admin.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role)
    {
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
        this.email = email;
    }
    public User update(String name, String picture)
    {
        this.name=name;
        this.picture=picture;

        return this;
    }
    public String getRoleKey()
    {
        return this.role.getKey();
    }

}
