package com.yachae.teamauction.domain.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yachae.teamauction.domain.most.PlayerMost;
import com.yachae.teamauction.domain.team.Team;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by MinKyu Kim
 * Created on 2022-01-07.
 **/

//    "name": "니초봇",
//    "profileImg": "니달리초보봇",
//    "tier":"G1",
//    "pos": 1,
//    "subPos": 2,
//    "most": ["니달리", "레오나", "블리츠크랭크"],
//    "comment": "우승합니다.^^.",
//    "userType": 0

@Entity
@Table(name="player", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String profileImg;

    @Column(nullable = false)
    private String tier;

    @Column(nullable = false)
    private String pos;

    @Column(nullable = false)
    private String subPos;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private int userType;

    @JsonManagedReference
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    @Builder.Default
    private List<PlayerMost> playerMost = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;


    public void addPlayerMost(PlayerMost playerMost) {
        this.playerMost.add(playerMost);
        if(playerMost.getPlayer() != this) {
            playerMost.setPlayer(this);
        }
    }

    public void setTeam(Team team) {
        this.team = team;
        if(!team.getPlayers().contains(this)) {
            team.getPlayers().add(this);
        }
    }

//    @Column
//    private int teamId;

}



