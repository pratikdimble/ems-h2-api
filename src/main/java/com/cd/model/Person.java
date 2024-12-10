package com.cd.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
public class Person implements Serializable {

    @NotBlank(message = "Name cannot be null or empty!")
    private String name;

    @NotBlank(message = "Title cannot be null or empty!")
    private String title;

    @NotBlank(message = "Task cannot be null or empty!")
    private String task;

    @NotNull(message = "Age should not be null!")
    @Min(value=18, message = "Minimum working age 18")
    @Max(value=60, message = "Maximum working age 60")
    private Integer age;

    @Size(min = 10, max = 200, message = "Address should be b/w 10-200 characters!")
    private String address;
}
