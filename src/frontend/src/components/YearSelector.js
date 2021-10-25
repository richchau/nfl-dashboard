import { React } from 'react';

export const YearSelector = ({teamName}) => {

    let years = [];
    const startYear = process.env.REACT_APP_DATA_START_YEAR;
    const endYear = process.env.REACT_APP_DATA_END_YEAR;

    for(let i = startYear; i <= endYear; i++){
        years.push(i);
    }

    return (
        <ol>
            {years.map(year => <li>{year}</li>)}
        </ol>
    
    )

}