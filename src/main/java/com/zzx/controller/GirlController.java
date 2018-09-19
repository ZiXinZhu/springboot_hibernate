package com.zzx.controller;

import com.zzx.entity.GirlEntity;
import com.zzx.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mr.John on 2018/9/17 22:07.
 **/

@RestController
public class GirlController {

    @Autowired
    private GirlService service;

    @RequestMapping("/sets")
    public Object adds(GirlEntity entity) {
        service.save(entity);
        return "成功！";
    }

    @RequestMapping("/add")
    public Object add(GirlEntity entity) {
        service.add(entity);
        return "成功！";
    }

    @RequestMapping("/del")
    public String del(int id) {
        service.del(id);
        return "成功！";
    }

    @RequestMapping("/getone")
    public GirlEntity getone(int id) {
        GirlEntity girlEntity = service.getone(id);
        if (girlEntity != null) {
            return girlEntity;
        }
        return null;
    }

    @RequestMapping("/update")
    public String update(GirlEntity girlEntity) {
        service.update(girlEntity);
        return "成功！";
    }


    @RequestMapping("/getall")
    public List<GirlEntity> getall(int age, String cupSize) {

        List<GirlEntity> girlEntities=service.getall(age,cupSize);
        if(girlEntities.size()>0){
            return girlEntities;
        }
        return null;
    }
}
