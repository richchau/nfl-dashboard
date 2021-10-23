import {React, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom';
import { GameDetailCard } from '../components/GameDetailCard';
import { GameSmallCard } from '../components/GameSmallCard';

import './TeamPage.scss';

export const TeamPage = () => {

    const [team, setTeam] = useState({games: []});
    const {teamName} = useParams();

    useEffect(
        () => {
            const fetchGames = async () => {
                const response = await fetch(`http://localhost:8080/team/${teamName}`);
                const data = await response.json();
                setTeam(data);
            };

            fetchGames();
        }, [teamName]
    );

    if(!team || !team.teamName){
        return <h1>Team not found</h1>
    }

    return (
        <div className="TeamPage">
        <div className="team-name-section">
            <h1 className="team-name">{team.teamName}</h1>
        </div>
        <div className="win-loss-ties-section">
            Wins / Losses / Ties
        </div>
        <div className="match-detail-section">
            <h3>Latest Games</h3>
            <GameDetailCard teamName={team.teamName} game={team.games[0]}/>
        </div>
        
        {team.games.slice(1).map(game => <GameSmallCard teamName={team.teamName} game={game}/>)}

        <div className="more-link">
            <a href="#">More ></a>
        </div>
        </div>
    );
}
