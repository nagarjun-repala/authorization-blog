package com.nagarjun.authorizationblog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.List;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false)    
    private String lastName;

    @NonNull
    @Column(nullable = false, unique = true)    
    private String username;

    @NonNull
    @Column(nullable = false)    
    @Getter(onMethod = @__(@JsonIgnore))
    @Setter(onMethod = @__(@JsonProperty))
    private String password;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(name = "created_on", nullable = false)
    private String createdOn;

    @JsonIgnore
    @ManyToMany(mappedBy = "users", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books;

}

