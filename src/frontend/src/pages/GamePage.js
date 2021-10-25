import {React, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom';
import { GameDetailCard } from '../components/GameDetailCard';
import { YearSelector } from '../components/YearSelector';

import "./GamePage.scss";

export const GamePage = () => {

    const [games, setGames] = useState([]);
    const {teamName, scheduleSeason} = useParams();

    useEffect(
        () => {
            const fetchGames = async () => {
                const response = await fetch(`http://localhost:8080/team/${teamName}/games?scheduleSeason=${scheduleSeason}`);
                const data = await response.json();
                setGames(data);
            };

            fetchGames();
        }, []
    );

    return (
        <div className="GamePage">
            <div className="year-selector">
                <YearSelector teamName={teamName}/>
            </div>
            <div>
                <h1>Games Page</h1>
                {
                    games.map(game => <GameDetailCard teamName={teamName} game={game}/>)
                }
            </div>
        </div>
    );
}
