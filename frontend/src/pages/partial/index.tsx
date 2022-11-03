import { useCallback, useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { useNavigate } from "react-router-dom";
import Pagination from "../../assets/components/Pagination";

import { GuessResponse } from "../../types/Guess";
import { PartialType } from "../../types/Partial";
import { pieOptions } from "../../utils/chart-options";
import { formatDate } from "../../utils/date";
import { makeRequest } from "../../utils/request";

import "./styles.css";

function Partial() {

  const [partialResponse, setPartialResponse] = useState<PartialType>({
    winner: ["Brasil", "", ""],
    vote_winner: [1, 0, 0],
    vice: ["Brasil", "Argentina", "Alemanha"],
    vote_vice: [0, 1, 0],
    third: ["Brasil", "Argentina", "Alemanha"],
    vote_third: [0, 0, 1]
  });
  const [guessResponse, setGuessResponse] = useState<GuessResponse>();
  const [activePage, setActivePage] = useState(0);
  const navigate = useNavigate();

  const getPartial = () => {
    makeRequest({ url: '/guess/partial' })
      .then(response => setPartialResponse(response.data));
  }

  const getGuess = useCallback(() => {
    const params = {
      page: activePage,
      size: 8,
    }
    makeRequest({ url: '/guess', params }).then(response => setGuessResponse(response.data));
    console.log(guessResponse);
  }, [activePage])

  useEffect(() => {
    getGuess();
    getPartial();
  }, [getGuess])

  const handleClickBack = () => {
    navigate("/");
  }

  const handleChangePage = (page: number) => {
    setActivePage(page);
  };

  return (
    <div className="partial-container">
      <div className="partial-content">
        <div className="card-title card-base">
          <h1>Votação Parcial</h1>
        </div>
        <div className="card-content">

          <div className="card-base card-graph">
            <h1 className="title">Vencedor</h1>
            <Chart options={{ ...pieOptions, labels: partialResponse.winner, legend: { position: "bottom" } }} series={partialResponse.vote_winner} type="donut" width="320" />
          </div>
          <div className="card-base card-vice card-graph">
            <h1 className="title">Vice Campeão</h1>
            <Chart options={{ ...pieOptions, labels: partialResponse.vice, legend: { position: "bottom" } }} series={partialResponse.vote_vice} type="donut" width="320" />
          </div>
          <div className="card-base card-graph">
            <h1 className="title">Terceiro Colocado</h1>
            <Chart options={{ ...pieOptions, labels: partialResponse.third, legend: { position: "bottom" } }} series={partialResponse.vote_third} type="donut" width="320" />
          </div>
        </div>
        <div className="card-base card-table">
          <table className="records-table" cellPadding="0" cellSpacing="0">
            <thead>
              <tr>
                <th>DATA</th>
                <th>NOME</th>
                <th>IDADE</th>
                <th>CAMPEÃO</th>
                <th>VICE CAMPEÃO</th>
                <th>3º LUGAR</th>
              </tr>
            </thead>
            <tbody>
              {guessResponse?.content.map(guess => (
                <tr key={guess.id}>
                  <td>{formatDate(guess.createdAt)}</td>
                  <td>{guess.client.name}</td>
                  <td>{guess.client.age}</td>
                  <td>{guess.winner.name}</td>
                  <td>{guess.vice.name}</td>
                  <td>{guess.third.name}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        {guessResponse && guessResponse.totalPages > 1 && (
          <Pagination
            totalPages={guessResponse.totalPages}
            activePage={activePage}
            onChange={(page) => handleChangePage(page)}
          />
        )}
        <div className="card-total card-base">
          <button type="button" onClick={handleClickBack} className="btn btn-outline-danger option-back">Voltar</button>
          <h4 className="total">Total: {guessResponse?.totalElements}</h4>
        </div>
      </div>
    </div>
  )
}

export default Partial;