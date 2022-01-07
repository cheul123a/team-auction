package com.yachae.teamauction.domain.most;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yachae.teamauction.domain.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by MinKyu Kim
 * Created on 2022-01-07.
 **/

@Entity
@Table(name="player_most", schema = "public")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
public class PlayerMost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column
    private String heroName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

//
    public void setPlayer(Player player) {
        this.player = player;
        if(!player.getPlayerMost().contains(this)) {
            player.getPlayerMost().add(this);
        }
    }

}
