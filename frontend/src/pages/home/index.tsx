import { useNavigate } from "react-router-dom";

import Taca from "../../assets/images/taca.png";

import "./styles.css";

function Home() {

  const navigate = useNavigate();

  const handleClickGuess = () => {
    navigate("/guess");
  }

  const handleClickPartial = () => {
    navigate("/partial");
  }

  return (
    <div className="home-container">
      <div className="home-content">
        <div className="card-home">
          <img src={Taca} alt="logo" className="home-card-logo" />
          <div className="card-home-content">
            <div className="home-title">
              <h1 className="home-title-text">Quem será o grande <br />campeão da copa do mundo?</h1>
            </div>
            <div className="home-text">
              <p>
                Aproveite nossa campanha e deixe seu palpite <br />sobre quem será o grande vencedor da copa do mundo Fifa 2022!!
              </p>
              <p>
                Acertertando as seleções vencedoras da copa, <br />você concorrerá aos melhores prêmios da internet!!
              </p>
            </div>
            <div className="home-options">
              <button type="button" onClick={handleClickPartial} className="btn btn-lg btn-primary option">Parcial</button>
              <button type="button" onClick={handleClickGuess} className="btn btn-lg btn-success option">Palpitar</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Home;