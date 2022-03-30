package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserIdDto {

    //TODO NoHTML
    //TODO What size?
    @Size(max = 128)
    private String userId;
}
