package com.hskim.assetguardian.user.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    private String userEmail;

    private String password;

    private String userName;

    private String userPhn;

    private String userRole;

    private String imgPath;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // PrePersist is used before the very first time the object is inserted into the database.
    // This will set both createdAt and updatedAt timestamps to the current time when a new entity is created.
    @PrePersist
    protected void onCreate() {
        this.createdAt= LocalDateTime.now();
        this.updatedAt= LocalDateTime.now();
    }

    // PreUpdate is used before any update on the data occurs,
    // so every time an update happens on that row updatedAt will be set to that current timestamp.
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt= LocalDateTime.now();
    }

    @Builder
    public Member(String userEmail, String password, String userName, String userPhn, String userRole, String imgPath) {
        this.userEmail = userEmail;
        this.password = password;
        this.userName = userName;
        this.userPhn = userPhn;
        this.userRole = userRole;
        this.imgPath = imgPath;
    }

    public Member update(String userName, String imgPath) {
        if (userName != null) {
            this.userName = userName;
        }if (imgPath != null) {
            this.imgPath = imgPath;
        }
        return this;
    }
}
