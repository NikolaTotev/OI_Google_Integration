package com.ocado.bootcamp.server.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record User(
        @Id
        int id,
        UserRole role
) {
}
