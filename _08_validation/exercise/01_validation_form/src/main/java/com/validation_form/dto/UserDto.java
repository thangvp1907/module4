package com.validation_form.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;

    @NotBlank(message = "không được để trống")
    @Size(min = 5, max = 45, message = "Định dạng phải lớn 5 và nhỏ hơn 45 kí tự")
    private String firstName;

    @NotBlank(message = "không được để trống")
    @Size(min = 5, max = 45, message = "Định dạng phải lớn 5 và nhỏ hơn 45 kí tự")
    private String lastName;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^0\\d{9}$", message = "nhập đúng định dạng 09xxxxxxx")
    private String phone;

    @NotBlank(message = "không được để trống")
    @Min(value = 18,message = "Tuổi phải lớn hơn hoặc bằng 18 tuổi")
    private String age;

    @NotBlank(message = "không được để trống")
    @Email(message = "Hãy nhập một Email chính xác")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phone, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if ("admin".equals(userDto.firstName)) {
            errors.rejectValue("firstName", "", "Trường name không được nhập admin");
        }
    }
}
