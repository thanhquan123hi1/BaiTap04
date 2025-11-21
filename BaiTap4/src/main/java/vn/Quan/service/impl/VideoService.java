package vn.Quan.service.impl;

import java.util.List;

import vn.Quan.entity.VideoEntity;
import vn.Quan.repository.IVideoRepository;
import vn.Quan.repository.impl.VideoRepository;
import vn.Quan.service.IVideoService;

public class VideoService implements IVideoService {

    private IVideoRepository videoRepo = new VideoRepository();

    @Override
    public void create(VideoEntity video) throws Exception {

        if (video.getTitle() == null || video.getTitle().isEmpty()) {
            throw new Exception("Tiêu đề video không được bỏ trống");
        }

        if (video.getCategory() == null || video.getCategory().getCategoryId() <= 0) {
            throw new Exception("Video phải thuộc một category hợp lệ");
        }

        videoRepo.create(video);
    }

    @Override
    public void update(VideoEntity video) throws Exception {

        VideoEntity old = videoRepo.findById(video.getVideoId());

        if (old == null) {
            throw new Exception("Video không tồn tại");
        }

        if (video.getTitle() == null || video.getTitle().isEmpty()) {
            throw new Exception("Tiêu đề video không được bỏ trống");
        }

        if (video.getCategory() == null
                || video.getCategory().getCategoryId() <= 0) {
            throw new Exception("Category không hợp lệ");
        }

        videoRepo.update(video);
    }

    @Override
    public void delete(int videoId) throws Exception {

        VideoEntity video = videoRepo.findById(videoId);

        if (video == null) {
            throw new Exception("Video không tồn tại");
        }

        videoRepo.delete(videoId);
    }

    @Override
    public VideoEntity findById(int videoId) {
        return videoRepo.findById(videoId);
    }

    @Override
    public List<VideoEntity> findAll() {
        return videoRepo.findAll();
    }

    @Override
    public List<VideoEntity> findByCategoryId(int categoryId) {
        return videoRepo.findByCategoryId(categoryId);
    }

    @Override
    public List<VideoEntity> searchByTitle(String keyword) {
        return videoRepo.searchByTitle(keyword);
    }
}
