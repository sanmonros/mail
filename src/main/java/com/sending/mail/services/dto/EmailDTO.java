package com.sending.mail.services.dto;

import lombok.Data;

@Data
public class EmailDTO {

    private String addressee;
    private String issue;
    private String message;

}
