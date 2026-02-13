package org.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDto {
    @Size(max=100, min=10 ,message="length of name must be greater 10 and smaller 100")
    @NotNull(message = "name can not be empty")
    private String name;

    @Email(message = "email must be valid")
    @NotNull(message = "email can not be blank")
    private String email;
    @NotNull(message = "address can not be blank")
    private String address;
    @NotNull(message = "dateOfBirth can not be blank")
    private String dateOfBirth;
    @NotNull(message = "registrationDate can not be blank")
    private String registrationDate;

    public @Size(max = 100, min = 10, message = "length of name must be greater 10 and smaller 100") @NotNull(message = "name can not be empty") String getName() {
        return name;
    }

    public void setName(@Size(max = 100, min = 10, message = "length of name must be greater 10 and smaller 100") @NotNull(message = "name can not be empty") String name) {
        this.name = name;
    }

    public @Email(message = "email must be valid") @NotNull(message = "email can not be blank") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "email must be valid") @NotNull(message = "email can not be blank") String email) {
        this.email = email;
    }

    public @NotNull(message = "address can not be blank") String getAddress() {
        return address;
    }

    public void setAddress(@NotNull(message = "address can not be blank") String address) {
        this.address = address;
    }

    public @NotNull(message = "dateOfBirth can not be blank") String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "dateOfBirth can not be blank") String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotNull(message = "registrationDate can not be blank") String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(@NotNull(message = "registrationDate can not be blank") String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
