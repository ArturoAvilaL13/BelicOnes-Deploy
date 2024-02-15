package com.belicones.APIRest.controller;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dto.VideoCarneDto;
import com.belicones.APIRest.model.entity.Usuario;
import com.belicones.APIRest.model.entity.VideoCarne;
import com.belicones.APIRest.payload.MessageResponse;
import com.belicones.APIRest.service.video.VideoCarneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VideoCarneController {
    @Autowired
    private VideoCarneService videoCarneService;

    @PostMapping("video")
    public ResponseEntity<?> create(@RequestBody VideoCarneDto videoCarneDto){
        VideoCarne videoCarne;
        try{
            videoCarne = videoCarneService.save(videoCarneDto);
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("Video guardado con exito")
                            .object(new Builders().builderVideoCarne(videoCarne))
                            .build()
                    ,HttpStatus.CREATED
            );
        }catch (DataAccessException dataAcEx){
            return new ResponseEntity<>(MessageResponse.builder()
                    .mensaje(dataAcEx.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("videos")
    public ResponseEntity<?> listAllVideos(){
        List<VideoCarne> videoCarnes = videoCarneService.listAll();
        if(videoCarnes==null){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("Lista de videos")
                        .object(videoCarnes)
                        .build()
                , HttpStatus.OK);
    }

    @GetMapping("video/{id}")
    public ResponseEntity<?> findVideoById(@PathVariable Integer id){
        VideoCarne videoCarne = videoCarneService.findById(id);
        if(videoCarne==null){
            return new ResponseEntity<>(MessageResponse.builder()
                    .mensaje("El video que intenta buscar no existe")
                    .object(null)
                    .build()
                    , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .mensaje("El video existe")
                        .object(new Builders().builderVideoCarne(videoCarne))
                        .build()
                ,HttpStatus.OK);
    }

    @DeleteMapping("video/{id}")
    public ResponseEntity<?> deleteVideo(@PathVariable Integer id){
        try{
            VideoCarne videoCarne = videoCarneService.findById(id);
            videoCarneService.delete(videoCarne);
            return  new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje("Video eliminado correctamente")
                            .object(videoCarne)
                            .build(),HttpStatus.OK);
        }catch (DataAccessException dataAcEx){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .mensaje(dataAcEx.getMessage())
                            .object(null)
                            .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }

}
