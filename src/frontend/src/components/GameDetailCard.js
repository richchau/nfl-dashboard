import {React} from 'react';
import {Link} from 'react-router-dom';

export const GameDetailCard = ({teamName, game}) => {
    if(!game) return null;
    const otherTeam = game.teamHome === teamName ? game.teamAway : game.teamHome;
    const otherTeamRoute = `/teams/${otherTeam}`;
    return (
        <div className="GameDetailCard">
        <h3>Latest Games</h3>
        <h1>vs <Link to={otherTeamRoute}>{otherTeam}</Link></h1>
        <h2>{game.scheduleDate}</h2>
        <h3>at {game.stadium}</h3>
        <h3>{game.scoreHome} - {game.scoreAway}</h3>
        </div>
    );
}
