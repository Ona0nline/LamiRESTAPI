package com.onaonline.lami.lami_backend.authentication;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

        @NotBlank(message = "Username cannot be blank.")
        private String username;
        @NotBlank(message = "Email is required.")
        @Email
        private String email;
        @NotBlank(message = "Phone number is required")
        @Size(min = 10, max = 10, message = "Number must be 10 digits")
        private String phone_number;
        @NotBlank(message = "Password cannot be empty")
        @Size(min = 8, message = "Password must not be less than 8 characters.")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$")
        private String password;
        @NotBlank
        private String confirmPassword;
        @NotNull
        private double latitude;
        @NotNull
        private double longitude;
        @NotNull
        private String placeName;

        @AssertTrue(message = "Passwords must match")
        public boolean isPasswordMatching(){
            return password.equals(confirmPassword);
        }


}
