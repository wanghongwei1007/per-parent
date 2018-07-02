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
    private String name;//族人姓名
    private String sex;//性别
    private String matrimony;//婚姻
    private int spouseid;//配偶id
    private int fatherid;//父id
    private int motherid;//母id
    private String sequence;//排行
   // private int sequenceOrder;// 排行排序字段，字典表获取？
    private String generations;//世代
    private String gradeid;//字辈id
    private String monicker;//字号s
    private Date birth;//出生日期
    private Date datetime;//死亡日期
    private String weight;//体重
    private String stature;//身高
    private String duty;//官爵
    private String health;//健康状况
    private String education;//教育
    private int brothersid;//兄弟ID
    private int sistersid;//姐妹ID
    private String appearance;//外貌
    private String honor;//荣誉
    private String hobby;//爱好
    private String homeaddress;///家庭住址
    private String detailedAddress;//详细地址
    private int childrenid;//子女ID
    private String necropolis;//埋葬地
    private String necropolisAddress;//详细地址
    private String describe;//描述
    private String imgurl;//图片
    private String imgName;
    private String videourl;//视频
    private String videoName;//视频
    private String voiceurl;//音频
    private String voiceName;//音频
    private int genealogynameid;//家谱id

//    public int getSequenceOrder() {
//        return sequenceOrder;
//    }
//
//    public void setSequenceOrder(int sequenceOrder) {
//        this.sequenceOrder = sequenceOrder;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMatrimony() {
        return matrimony;
    }

    public void setMatrimony(String matrimony) {
        this.matrimony = matrimony;
    }

    public int getSpouseid() {
        return spouseid;
    }

    public void setSpouseid(int spouseid) {
        this.spouseid = spouseid;
    }

    public int getFatherid() {
        return fatherid;
    }

    public void setFatherid(int fatherid) {
        this.fatherid = fatherid;
    }

    public int getMotherid() {
        return motherid;
    }

    public void setMotherid(int motherid) {
        this.motherid = motherid;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getGenerations() {
        return generations;
    }

    public void setGenerations(String generations) {
        this.generations = generations;
    }

    public String getGradeid() {
        return gradeid;
    }

    public void setGradeid(String gradeid) {
        this.gradeid = gradeid;
    }

    public String getMonicker() {
        return monicker;
    }

    public void setMonicker(String monicker) {
        this.monicker = monicker;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStature() {
        return stature;
    }

    public void setStature(String stature) {
        this.stature = stature;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getBrothersid() {
        return brothersid;
    }

    public void setBrothersid(int brothersid) {
        this.brothersid = brothersid;
    }

    public int getSistersid() {
        return sistersid;
    }

    public void setSistersid(int sistersid) {
        this.sistersid = sistersid;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public int getChildrenid() {
        return childrenid;
    }

    public void setChildrenid(int childrenid) {
        this.childrenid = childrenid;
    }

    public String getNecropolis() {
        return necropolis;
    }

    public void setNecropolis(String necropolis) {
        this.necropolis = necropolis;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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

    public int getGenealogynameid() {
        return genealogynameid;
    }

    public void setGenealogynameid(int genealogynameid) {
        this.genealogynameid = genealogynameid;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVoiceName() {
        return voiceName;
    }

    public void setVoiceName(String voiceName) {
        this.voiceName = voiceName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getNecropolisAddress() {
        return necropolisAddress;
    }

    public void setNecropolisAddress(String necropolisAddress) {
        this.necropolisAddress = necropolisAddress;
    }
}
