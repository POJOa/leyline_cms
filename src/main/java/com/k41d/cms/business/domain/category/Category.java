package com.k41d.cms.business.domain.category;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.k41d.cms.business.domain.commons.CategoryType;
import com.k41d.cms.business.domain.topic.Topic;
import com.k41d.leyline.framework.domain.LeylineDO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable,LeylineDO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="alias")
    private String alias;

    @Column(name="created_at")
    private LocalDateTime createdAt;

//    @Enumerated(EnumType.STRING)
//    @Column(name="type")
//    private CategoryType type;

    @Column(name="reference")
    private String reference; // topicId IF CatType SINGLE_STATIC_TOPIC , URL IF CatType SINGLE_STATIC_TOPIC.


}
