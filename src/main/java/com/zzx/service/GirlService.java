package com.zzx.service;

import com.zzx.dao.GirlDao_H4;
import com.zzx.dao.GirlDao_H5;
import com.zzx.entity.GirlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.John on 2018/9/17 22:05.
 **/
@Service
public class GirlService {

    @Autowired
    private GirlDao_H4 girlDao;
    @Autowired
    private GirlDao_H5 base;

    public void save(GirlEntity entity) {
        girlDao.save(entity);
    }

    public void add(GirlEntity entity) {
        base.add(entity);
    }

    public void del(int id){
        girlDao.del(id);
    }

    public GirlEntity getone(int id) {
        return girlDao.getone(id);
    }

    public void update(GirlEntity girlEntity){
        girlDao.update(girlEntity);
    }

    public List<GirlEntity> getall(int age, String cupSize){
        return girlDao.getall(age,cupSize);
    }
}
