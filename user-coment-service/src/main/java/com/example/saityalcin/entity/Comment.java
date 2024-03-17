package com.example.saityalcin.entity;


import com.example.saityalcin.enums.EnumCommentPoint;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_comment")
@Getter
@Setter
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentIdSequence")
    @SequenceGenerator(name = "commentIdSequence", sequenceName = "s_comment")
    private Long id;

    @Column(name="content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "point")
    private EnumCommentPoint point;
}
