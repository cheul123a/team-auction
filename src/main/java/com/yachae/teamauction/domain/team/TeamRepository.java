package com.yachae.teamauction.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MinKyu Kim
 * Created on 2022-01-07.
 **/
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByLeader(String leader);
}
