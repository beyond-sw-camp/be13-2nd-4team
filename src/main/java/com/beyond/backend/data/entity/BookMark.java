package com.beyond.backend.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookMark {

    @EmbeddedId
    @Column(name = "bookmark_no")
    private BookMarkNo no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postNo", insertable = false, updatable = false, nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postNo", insertable = false, updatable = false, nullable = false)
    private User user;
}