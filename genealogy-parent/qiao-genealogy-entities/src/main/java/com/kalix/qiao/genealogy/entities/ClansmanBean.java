package com.kalix.qiao.genealogy.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.DateTimeException;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/20 0020.
 */
@Entity
@Table(name = "qiao_genealogy_clansman")
public class ClansmanBean extends PersistentEntity {
    private Date birth;//出生日期
    private int brothersid;//兄弟姐妹ID
    private int childrenid;//子女ID
    private Date datetime;//死亡日期
    private String describe;//描述
    private String duty;//官爵
    private String education;//教育
    private int fatherid;//父id
    private int genealogynameid;//家谱id
    private String generations;//世代
    private int gradeid;//字辈id
    private String health;//健康状况
    private String imgurl;//图片
    private String matrimony;//婚姻
    private String monicker;//字号
    private int motherid;//母id
    private String name;//族人姓名
    private String necropolis;//埋葬地
    private String sequence;//排行
    private String sex;//性别
    private String site;///家庭住址
    private int spouseid;//配偶id
    private String stature;//身高
    private String videourl;//视频
    private String voiceurl;//音频
    private String weight;//体重

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getBrothersid() {
        return brothersid;
    }

    public void setBrothersid(int brothersid) {
        this.brothersid = brothersid;
    }

    public int getChildrenid() {
        return childrenid;
    }

    public void setChildrenid(int childrenid) {
        this.childrenid = childrenid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getFatherid() {
        return fatherid;
    }

    public void setFatherid(int fatherid) {
        this.fatherid = fatherid;
    }

    public int getGenealogynameid() {
        return genealogynameid;
    }

    public void setGenealogynameid(int genealogynameid) {
        this.genealogynameid = genealogynameid;
    }

    public String getGenerations() {
        return generations;
    }

    public void setGenerations(String generations) {
        this.generations = generations;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getMatrimony() {
        return matrimony;
    }

    public void setMatrimony(String matrimony) {
        this.matrimony = matrimony;
    }

    public String getMonicker() {
        return monicker;
    }

    public void setMonicker(String monicker) {
        this.monicker = monicker;
    }

    public int getMotherid() {
        return motherid;
    }

    public void setMotherid(int motherid) {
        this.motherid = motherid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNecropolis() {
        return necropolis;
    }

    public void setNecropolis(String necropolis) {
        this.necropolis = necropolis;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getSpouseid() {
        return spouseid;
    }

    public void setSpouseid(int spouseid) {
        this.spouseid = spouseid;
    }

    public String getStature() {
        return stature;
    }

    public void setStature(String stature) {
        this.stature = stature;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getVoiceurl() {
        return voiceurl;
    }

    public void setVoiceurl(String voiceurl) {
        this.voiceurl = voiceurl;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
