package vn.Quan.service;

import java.util.List;

import vn.Quan.entity.VideoEntity;

public interface IVideoService {

    void create(VideoEntity video) throws Exception;

    void update(VideoEntity video) throws Exception;

    void delete(int videoId) throws Exception;

    VideoEntity findById(int videoId);

    List<VideoEntity> findAll();

    List<VideoEntity> findByCategoryId(int categoryId);

    List<VideoEntity> searchByTitle(String keyword);
}
