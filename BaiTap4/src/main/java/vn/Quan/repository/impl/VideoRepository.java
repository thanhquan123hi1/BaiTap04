package vn.Quan.repository.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.Quan.config.JPAConfig;
import vn.Quan.entity.VideoEntity;
import vn.Quan.repository.IVideoRepository;

public class VideoRepository implements IVideoRepository {

    @Override
    public void create(VideoEntity entity) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(VideoEntity entity) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int videoId) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            VideoEntity entity = em.find(VideoEntity.class, videoId);
            if (entity != null) {
                em.remove(entity);
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public VideoEntity findById(int videoId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.find(VideoEntity.class, videoId);
        } finally {
            em.close();
        }
    }

    @Override
    public List<VideoEntity> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT v FROM VideoEntity v";
            TypedQuery<VideoEntity> query = em.createQuery(jpql, VideoEntity.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<VideoEntity> findByCategoryId(int categoryId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT v FROM VideoEntity v WHERE v.category.categoryId = :cid";
            TypedQuery<VideoEntity> query = em.createQuery(jpql, VideoEntity.class);
            query.setParameter("cid", categoryId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<VideoEntity> searchByTitle(String keyword) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT v FROM VideoEntity v WHERE v.title LIKE :kw";
            TypedQuery<VideoEntity> query = em.createQuery(jpql, VideoEntity.class);
            query.setParameter("kw", "%" + keyword + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
