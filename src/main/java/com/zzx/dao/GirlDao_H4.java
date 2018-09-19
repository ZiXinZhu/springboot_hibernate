package com.zzx.dao;

import com.zzx.entity.GirlEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mr.John on 2018/9/17 22:03.
 **/

@Repository
public class GirlDao_H4 {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    /**
     * 插入用户
     *
     * @param entity
     */
    public void save(GirlEntity entity) {
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务
        session.save(entity);
        transaction.commit();//事务提交
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂
    }

    /**
     * 删除用户
     *
     * @param id
     */
    public void del(int id) {
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务

        session.delete(session.get(GirlEntity.class, id));
        transaction.commit();//事务提交
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂

    }

    /**
     * 查找某个用户
     *
     * @param id
     * @return
     */
    public GirlEntity getone(int id) {
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务
        GirlEntity girlEntity = session.find(GirlEntity.class, id);
        transaction.commit();//事务提交
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂
        return girlEntity;
    }


    /**
     * 更新用户
     *
     * @param entity
     */
    public void update(GirlEntity entity) {
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务
        session.update(entity);
        transaction.commit();//事务提交
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂

    }

    /**
     *
     * 核心，有了它妈妈再也不用担心我用 hibernate
     *
     * 自定义hql和sql语句查询
     * @param age
     * @param cupSize
     * @return
     */
    public List<GirlEntity> getall(int age, String cupSize) {
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务

        //方法一：hql语句查询
        //String hql = "FROM  GirlEntity g where age=? and cupSize=?";
        String hql = "FROM  GirlEntity g where g.age=? and g.cupSize=?";
        Query query = session.createQuery(hql);
        query.setParameter(0, 23);
        query.setParameter(1, cupSize);
        List<GirlEntity> list = query.list();

        //方法二：Sql语句查询
        /*String sql = "SELECT * FROM  girl where girl.age=? and girl.cupSize=?";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setParameter(0, age);
        sqlQuery.setParameter(1, cupSize);
        List<GirlEntity> list = sqlQuery.list();*/

        transaction.commit();//事务提交
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂
        return list;
    }

}
