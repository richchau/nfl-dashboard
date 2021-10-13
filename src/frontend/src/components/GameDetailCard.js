import {React} from 'react';

export const GameDetailCard = ({game}) => {
    if(!game) return null;
    return (
        <div className="GameDetailCard">
        <h3>Latest Matches</h3>
        <h4>Game Details</h4>
        <h4>{game.teamHome} vs {game.teamAway}</h4>
        </div>
    );
}
