package com.cubemora.ax_courses.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class testimonials {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nameTestimonial")
    private String nameTestimonial;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "descriptionTestimonial")
    private String descriptionTestimonial;

    private String professionTestimonial;


    public String getProfessionTestimonial() {
        return professionTestimonial;
    }
    public void setProfessionTestimonial(String professionTestimonial) {
        this.professionTestimonial = professionTestimonial;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNameTestimonial() {
        return nameTestimonial;
    }
    public void setNameTestimonial(String nameTestimonial) {
        this.nameTestimonial = nameTestimonial;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getDescriptionTestimonial() {
        return descriptionTestimonial;
    }
    public void setDescriptionTestimonial(String descriptionTestimonial) {
        this.descriptionTestimonial = descriptionTestimonial;
    }
}
