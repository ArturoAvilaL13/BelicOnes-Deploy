package com.belicones.APIRest.service.video;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dao.VideoCarneDao;
import com.belicones.APIRest.model.dto.VideoCarneDto;
import com.belicones.APIRest.model.entity.Usuario;
import com.belicones.APIRest.model.entity.VideoCarne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideoCarneImplementsService implements VideoCarneService{
    @Autowired
    private VideoCarneDao videoCarneDao;

    @Transactional
    @Override
    public List<VideoCarne> listAll() {
        List<VideoCarne> videos = (List<VideoCarne>) videoCarneDao.findAll();
        if(videos.isEmpty()){
            return null;
        }
        return videos;
    }

    @Override
    public VideoCarne save(VideoCarneDto videoCarneDto) {
        VideoCarne videoCarne = new Builders().builderVideoCarne(videoCarneDto);
        return videoCarneDao.save(videoCarne);
    }

    @Override
    public VideoCarne findById(int id) {
        return videoCarneDao.findById(id).orElse(null);
    }

    @Override
    public void delete(VideoCarne videoCarne) {
    videoCarneDao.delete(videoCarne);
    }

    @Override
    public boolean existsById(Integer id) {
        return videoCarneDao.existsById(id);
    }
}
