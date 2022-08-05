package com.ecom.api.models;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserAuth {
    
    @NotNull(message = "Le nom est obligatoire")
    @Size(max = 10,min = 2,message = "Le login doit etre compris entre 2 et 10 caractères")
    private String login;

    @NotNull(message = "Le mot de passe est obligatoire")
    private String password;

}
