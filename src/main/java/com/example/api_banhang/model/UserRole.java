package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "userrole")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "role_id",updatable = false,insertable = false)
    @JsonIgnore
    private Role role;

    @ManyToOne
    @JoinColumn(name = "user_id",updatable = false,insertable = false)
    @JsonIgnore
    private User user;
}
