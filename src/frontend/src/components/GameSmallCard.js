import {React} from 'react';

export const GameSmallCard = ({game}) => {
  return (
    <div className="GameSmallCard">
     <p>{game.teamHome} vs {game.teamAway}</p>
    </div>
  );
}
