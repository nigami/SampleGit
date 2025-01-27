package com.yusuf.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="adverttable")
public class Advert {

    @Id
    @GeneratedValue
    @Column(name="advertid")
   private long id;
    
    @Column(name="title")
   private String title;
    
    @Column(name="message")
   private String message;
    
    @Transient
   private String postedBy;
    
   @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
   @JoinColumn(name="user")
   private User user;
   
   @Transient
   private String category_name;
   
   @JoinColumn(name="categoryid")
   private long category;

   public Advert(String title, String message, User user,long category_id,String categoryName) {
       this.title = title;
       this.message = message;
       this.user = user;
       this.category = category_id;
       this.category_name=categoryName;
   }

   Advert() {
   }

   public String getMessage() {
       return message;
   }

   public void setMessage(String message) {
       this.message = message;
   }

   public String getTitle() {
       return title;
   }

   public void setTitle(String title) {
       this.title = title;
   }

   public User getUser() {
       return user;
   }

   public void setUser(User user) {
       this.user = user;
   }

   protected long getId() {
       return id;
   }

   protected void setId(long id) {
       this.id = id;
   }

   public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getPostedBy() {
       return this.postedBy;
   }

   public void setPostedBy(String pb) {
       this.postedBy = pb;
   }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }
}