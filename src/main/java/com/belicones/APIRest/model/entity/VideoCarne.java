package com.belicones.APIRest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "video_carne")
public class VideoCarne implements Serializable {
    @Id
    @Column(name = "id_video_carne")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVideoCarne;
    @Column(name = "url_video_carne")
    private String urlVideoCarne;
    @Column(name = "descripcion_video_carne")
    private String descripcionVideoCarne;
    @Column(name = "fk_id_carne")
    private int fkIdCarne;
}
