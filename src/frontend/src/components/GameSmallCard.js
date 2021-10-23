import {React} from 'react';
import {Link} from 'react-router-dom';

import './GameSmallCard.scss';

export const GameSmallCard = ({teamName, game}) => {

    const otherTeam = game.teamHome === teamName ? game.teamAway : game.teamHome;
    const otherTeamRoute = `/teams/${otherTeam}`;

    const teamScore = game.teamHome === teamName ? game.scoreHome : game.scoreAway;
    const otherTeamScore = game.teamHome === teamName ? game.scoreAway : game.scoreHome;

    var gameOutcome = "";

    if(teamScore > otherTeamScore){
        gameOutcome = "won";
    }else if(teamScore < otherTeamScore){
        gameOutcome = "lost";
    }else{
        gameOutcome = "tied";
    }

    return (
        <div className={'GameSmallCard ' + gameOutcome + '-card'}>
            <span className="vs">vs</span>
            <h3><Link to={otherTeamRoute}>{otherTeam}</Link></h3>
            <p className = "game-score">{teamScore} - {otherTeamScore}</p>
        </div>
    );
}
