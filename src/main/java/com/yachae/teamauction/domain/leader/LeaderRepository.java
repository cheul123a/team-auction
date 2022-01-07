package com.yachae.teamauction.domain.leader;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

/**
 * Created by MinKyu Kim
 * Created on 2022-01-07.
 **/

public interface LeaderRepository extends JpaRepository<Leader, Long> {


}
