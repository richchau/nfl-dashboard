package com.richchau.nfldashboard.data;

import java.time.LocalDate;

import com.richchau.nfldashboard.model.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class GameDataProcessor implements ItemProcessor<GameInput, Game> {

    private static final Logger log = LoggerFactory.getLogger(GameDataProcessor.class);

    @Override
    public Game process(final GameInput gameInput) throws Exception {
        Game game = new Game();

        game.setId(Long.parseLong(gameInput.getId()));
        game.setScheduleDate(LocalDate.parse(gameInput.getSchedule_date()));
        game.setScheduleSeason(gameInput.getSchedule_season());
        game.setScheduleWeek(gameInput.getSchedule_week());
        game.setSchedulePlayoff(Boolean.parseBoolean(gameInput.getSchedule_playoff()));
        game.setTeamHome(gameInput.getTeam_home());
        game.setScoreHome(Double.parseDouble(gameInput.getScore_home()));
        game.setScoreAway(Double.parseDouble(gameInput.getScore_away()));
        game.setTeamAway(gameInput.getTeam_away());
        game.setTeamFavoriteId(gameInput.getTeam_favorite_id());
        game.setSpreadFavorite(Double.parseDouble(gameInput.getSpread_favorite()));
        game.setOverUnderLine(Double.parseDouble(gameInput.getOver_under_line()));
        game.setStadium(gameInput.getStadium());

        return game;
    }

}