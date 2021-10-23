import {React} from 'react';
import {Link} from 'react-router-dom';

import './GameSmallCard.scss';

export const GameSmallCard = ({teamName, game}) => {

    const otherTeam = game.teamHome === teamName ? game.teamAway : game.teamHome;
    const otherTeamRoute = `/teams/${otherTeam}`;
    var gameOutcome = "";

    if(game.scoreHome > game.scoreAway){
        gameOutcome = "won";
    }else if(game.scoreHome < game.scoreAway){
        gameOutcome = "lost";
    }else{
        gameOutcome = "tied";
    }

    return (
        <div className={'GameSmallCard ' + gameOutcome + '-card'}>
            <span className="vs">vs</span>
            <h3><Link to={otherTeamRoute}>{otherTeam}</Link></h3>
            <p className = "game-score">{game.scoreHome} - {game.scoreAway}</p>
        </div>
    );
}
