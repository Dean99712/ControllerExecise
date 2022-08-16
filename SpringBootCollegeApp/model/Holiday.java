package com.lecture.SpringBootCollegeApp.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {

    @Id
    private String day;
    private String reason;

    @Enumerated(EnumType.STRING) // Using this annotation because Type variable is Enum
    private Type type;

    public enum Type {
        FEDERAL,
        FESTIVAL
    }

}
