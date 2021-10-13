import {React} from 'react';
import {Link} from 'react-router-dom';

export const GameSmallCard = ({teamName, game}) => {

    const otherTeam = game.teamHome === teamName ? game.teamAway : game.teamHome;
    const otherTeamRoute = `/teams/${otherTeam}`;
    return (
        <div className="GameSmallCard">
        <h3>vs <Link to={otherTeamRoute}>{otherTeam}</Link></h3>
        <p>{game.scoreHome} - {game.scoreAway}</p>
        </div>
    );
}
