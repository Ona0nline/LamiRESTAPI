package com.onaonline.lami.lami_backend.database.details;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Builder
@Data
public class UserDetails {
    @Id
//    id incrementation by 1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String phone_number;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String latitude;
    private String longitude;


    public UserDetails(Long id,String username, String email, String phone_number, String password, String latitude, String longitude) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UserDetails() {
    }

}
