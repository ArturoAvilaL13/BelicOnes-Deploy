package com.belicones.APIRest.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class VideoCarneDto {
    private int idVideoCarne;
    private String urlVideoCarne;
    private String descripcionVideoCarne;
    private int fkIdCarne;
}
