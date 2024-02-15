package com.belicones.APIRest.service.video;

import com.belicones.APIRest.model.dto.UsuarioDto;
import com.belicones.APIRest.model.dto.VideoCarneDto;
import com.belicones.APIRest.model.entity.Usuario;
import com.belicones.APIRest.model.entity.VideoCarne;

import java.util.List;

public interface VideoCarneService {
    List<VideoCarne> listAll();
    VideoCarne save(VideoCarneDto videoCarneDto);
    VideoCarne findById(int id);
    void delete(VideoCarne videoCarne);
    boolean existsById(Integer id);
}
