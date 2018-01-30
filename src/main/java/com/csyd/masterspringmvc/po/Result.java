package com.csyd.masterspringmvc.po;

/**
 * Created by ChengShanyunduo
 * 2018/1/29
 */
public class Result {

    private String title;

    private String tag;

    private String act;

    private String year;

    private String rating;

    private String area;

    private String dir;

    private String desc;

    private String cover;

    private String vdo_status;

    private Playlinks playlinks;

    private VideoRec[] video_rec;

    private ActS[] act_s;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVdo_status() {
        return vdo_status;
    }

    public void setVdo_status(String vdo_status) {
        this.vdo_status = vdo_status;
    }

    public Playlinks getPlaylinks() {
        return playlinks;
    }

    public void setPlaylinks(Playlinks playlinks) {
        this.playlinks = playlinks;
    }

    public VideoRec[] getVideo_rec() {
        return video_rec;
    }

    public void setVideo_rec(VideoRec[] video_rec) {
        this.video_rec = video_rec;
    }

    public ActS[] getAct_s() {
        return act_s;
    }

    public void setAct_s(ActS[] act_s) {
        this.act_s = act_s;
    }
}
