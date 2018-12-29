package com.ecjtu.kongtao.service;


import com.ecjtu.kongtao.bean.Photo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepK
 */
@Service
public interface PhotoService {
    List<Photo> getPhotos();

    Photo getPhoto(Integer id);

    boolean savePhoto(Photo photo);

    boolean addPhoto(Photo photo);

    boolean delPhoto(Integer id);

    List<Photo> searchPhotos(Integer roomId);
}
