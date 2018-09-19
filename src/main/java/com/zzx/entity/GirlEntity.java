package com.zzx.entity;

import javax.persistence.*;

/**
 * Created by Mr.John on 2018/9/19 10:46.
 **/
@Entity
@Table(name = "girl", schema = "hibernate", catalog = "")
public class GirlEntity {
    private int id;
    private int age;
    private String cupSize;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "cupSize")
    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GirlEntity that = (GirlEntity) o;

        if (id != that.id) return false;
        if (age != that.age) return false;
        if (cupSize != null ? !cupSize.equals(that.cupSize) : that.cupSize != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + age;
        result = 31 * result + (cupSize != null ? cupSize.hashCode() : 0);
        return result;
    }
}
