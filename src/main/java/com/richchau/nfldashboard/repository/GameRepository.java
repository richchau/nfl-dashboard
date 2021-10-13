package com.richchau.nfldashboard.repository;

import java.util.List;

import com.richchau.nfldashboard.model.Game;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> getByTeamHomeOrTeamAwayOrderByScheduleDateDesc(String teamHome, String teamAway, Pageable pageable);

    default List<Game> findLatestGamesByTeam(String teamName, int count) {
        return getByTeamHomeOrTeamAwayOrderByScheduleDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
