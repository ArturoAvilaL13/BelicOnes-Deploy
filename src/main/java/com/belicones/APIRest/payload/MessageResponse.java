package com.belicones.APIRest.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MessageResponse implements Serializable {
    private String mensaje;
    private Object object;
}
