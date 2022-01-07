package com.yachae.teamauction.domain.team;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yachae.teamauction.domain.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MinKyu Kim
 * Created on 2022-01-07.
 **/

@Entity
@Table(name="leader", schema = "public")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

//    @OneToOne
//    private String leader;

    @JsonManagedReference
    @Builder.Default
    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();
}
