import {React, useEffect, useState} from 'react';
import { GameDetailCard } from '../components/GameDetailCard';
import { GameSmallCard } from '../components/GameSmallCard';

export const TeamPage = () => {

    const [team, setTeam] = useState({games: []});

    useEffect(
        () => {
            const fetchGames = async () => {
                const response = await fetch('http://localhost:8080/team/San Francisco 49ers');
                const data = await response.json();
                setTeam(data);
            };

            fetchGames();
        }, []
    );


  return (
    <div className="TeamPage">
     <h1>{team.teamName}</h1>
     <GameDetailCard game={team.games[0]}/>
     {team.games.slice(1).map(game => <GameSmallCard game={game}/>)}
    </div>
  );
}
