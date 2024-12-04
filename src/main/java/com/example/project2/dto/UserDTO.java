package com.example.project2.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Min(value=1 , message = "Age must be at least 1")
    @Max(value = 25, message = "Age must be maximum  25")
    private int age;
    public UserDTO() {} 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    

}
