package com.richchau.nfldashboard.controller;

import java.util.List;

import com.richchau.nfldashboard.model.Game;
import com.richchau.nfldashboard.model.Team;
import com.richchau.nfldashboard.repository.GameRepository;
import com.richchau.nfldashboard.repository.TeamRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {

    private TeamRepository teamRepository;
    private GameRepository gameRepository;

    public TeamController(TeamRepository teamRepository, GameRepository gameRepository) {
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = this.teamRepository.findByTeamName(teamName);
        team.setGames(gameRepository.findLatestGamesByTeam(teamName, 4));

        return team;
    }

    @GetMapping("/team/{teamName}/games")
    public List<Game> getGamesForTeam(@PathVariable String teamName, @RequestParam String scheduleSeason) {
        return this.gameRepository.getGamesByTeamBySeason(teamName, scheduleSeason);
    }

}