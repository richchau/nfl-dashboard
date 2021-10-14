package com.richchau.nfldashboard.repository;

import java.util.List;

import com.richchau.nfldashboard.model.Game;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> getByTeamHomeOrTeamAwayOrderByScheduleDateDesc(String teamHome, String teamAway, Pageable pageable);

    // List<Game>
    // getByTeamHomeAndScheduleSeasonOrTeamAwayAndScheduleSeasonOrderByScheduleDateDesc(String
    // teamHome,
    // String scheduleSeason1, String teamAway, String scheduleSeason2);

    @Query("select g from Game g where (g.teamHome = :teamName or g.teamAway = :teamName) and scheduleSeason = :scheduleSeason order by scheduleDate desc")
    List<Game> getGamesByTeamBySeason(@Param("teamName") String teamName,
            @Param("scheduleSeason") String scheduleSeason);

    default List<Game> findLatestGamesByTeam(String teamName, int count) {
        return getByTeamHomeOrTeamAwayOrderByScheduleDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
