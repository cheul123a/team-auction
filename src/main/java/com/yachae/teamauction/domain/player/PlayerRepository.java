package com.yachae.teamauction.domain.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by MinKyu Kim
 * Created on 2022-01-07.
 **/
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(value = "SELECT * FROM player p WHERe p.team_id is null ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Player findRandomPlayer();
}
