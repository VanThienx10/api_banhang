package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "userrole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "role_id",foreignKey = @ForeignKey(name = "Role_UserRole"))
    @JsonIgnore
    private Role role;

    @ManyToOne
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "User_UserRole"))
    @JsonIgnore
    private User user;
}
