package vn.Quan.repository;

import java.util.List;

import vn.Quan.entity.VideoEntity;

public interface IVideoRepository {

	List<VideoEntity> searchByTitle(String keyword);

	List<VideoEntity> findByCategoryId(int categoryId);

	List<VideoEntity> findAll();

	VideoEntity findById(int videoId);

	void delete(int videoId);

	void update(VideoEntity entity);

	void create(VideoEntity entity);

}
