package com.yachae.teamauction.dto;

import com.yachae.teamauction.domain.most.PlayerMost;
import com.yachae.teamauction.domain.player.Player;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by MinKyu Kim
 * Created on 2022-01-07.
 **/

@Getter
@Setter
public class RegisterPlayerDto {

    @NotNull
    private String name;
    @NotNull
    private String profileImg;
    @NotNull
    private String tier;
    @NotNull
    private String pos;
    @NotNull
    private String subPos;
    @NotNull
    private List<String> most;
    @NotNull
    private String comment;
    @NotNull
    private int userType;


    public Player toEntity() {
        Player player = Player.builder()
                .name(name)
                .profileImg(profileImg)
                .tier(tier)
                .pos(pos)
                .subPos(subPos)
                .comment(comment)
                .userType(userType)
                .build();

        most.forEach(heroName -> player.addPlayerMost(
                PlayerMost.builder()
                    .heroName(heroName)
                    .build()
            )
        );

        return player;
    }
}
