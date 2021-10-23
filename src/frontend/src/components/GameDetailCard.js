import {React} from 'react';
import {Link} from 'react-router-dom';

import "./GameDetailCard.scss";

export const GameDetailCard = ({teamName, game}) => {
    if(!game) return null;
    const otherTeam = game.teamHome === teamName ? game.teamAway : game.teamHome;
    const otherTeamRoute = `/teams/${otherTeam}`;
    var gameOutcome = "";

    const teamScore = game.teamHome === teamName ? game.scoreHome : game.scoreAway;
    const otherTeamScore = game.teamHome === teamName ? game.scoreAway : game.scoreHome;

    if(teamScore > otherTeamScore){
        gameOutcome = "won";
    }else if(teamScore < otherTeamScore){
        gameOutcome = "lost";
    }else{
        gameOutcome = "tied";
    }


    return (
        <div className={'GameDetailCard ' + gameOutcome + '-card'}>
            <div>
                <span className="vs">vs</span>
                <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>
                <h2 className="game-date">{game.scheduleDate}</h2>
                <h3 className="game-stadium">at {game.stadium}</h3>
                <h3 className="game-score">{teamScore} - {otherTeamScore}</h3>
            </div>
            <div className="additional-detail">
                <h3>Favorite Team</h3>
                <p>{game.teamFavoriteId}</p>
                <h3>Spread</h3>
                <p>{game.spreadFavorite}</p>
                <h3>Over / Under</h3>
                <p>{game.overUnderLine}</p>
            </div>
        </div>
    );
}
