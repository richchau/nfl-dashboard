package com.richchau.nfldashboard.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    private long id;
    private LocalDate scheduleDate;
    private String scheduleSeason;
    private String scheduleWeek;
    private boolean schedulePlayoff;
    private String teamHome;
    private double scoreHome;
    private double scoreAway;
    private String teamAway;
    private String teamFavoriteId;
    private double spreadFavorite;
    private double overUnderLine;
    private String stadium;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleSeason() {
        return scheduleSeason;
    }

    public void setScheduleSeason(String scheduleSeason) {
        this.scheduleSeason = scheduleSeason;
    }

    public String getScheduleWeek() {
        return scheduleWeek;
    }

    public void setScheduleWeek(String scheduleWeek) {
        this.scheduleWeek = scheduleWeek;
    }

    public boolean isSchedulePlayoff() {
        return schedulePlayoff;
    }

    public void setSchedulePlayoff(boolean schedulePlayoff) {
        this.schedulePlayoff = schedulePlayoff;
    }

    public String getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(String teamHome) {
        this.teamHome = teamHome;
    }

    public double getScoreHome() {
        return scoreHome;
    }

    public void setScoreHome(double scoreHome) {
        this.scoreHome = scoreHome;
    }

    public double getScoreAway() {
        return scoreAway;
    }

    public void setScoreAway(double scoreAway) {
        this.scoreAway = scoreAway;
    }

    public String getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(String teamAway) {
        this.teamAway = teamAway;
    }

    public String getTeamFavoriteId() {
        return teamFavoriteId;
    }

    public void setTeamFavoriteId(String teamFavoriteId) {
        this.teamFavoriteId = teamFavoriteId;
    }

    public double getSpreadFavorite() {
        return spreadFavorite;
    }

    public void setSpreadFavorite(double spreadFavorite) {
        this.spreadFavorite = spreadFavorite;
    }

    public double getOverUnderLine() {
        return overUnderLine;
    }

    public void setOverUnderLine(double overUnderLine) {
        this.overUnderLine = overUnderLine;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

}
