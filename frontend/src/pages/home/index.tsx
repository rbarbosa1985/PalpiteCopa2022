import "./styles.css";
import Logo from "../../assets/images/logo.png";
import { useNavigate } from "react-router-dom";

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
        <div className="home-title">
          <h1 className="home-title-text">BOLÃO</h1>
          <h1 className="home-title-text">da</h1>
          <h1 className="home-title-text">COPA DO MUNDO 2022</h1>
        </div>
        <div className="home-text">
          <p>
            Participe do nosso bolão.
          </p>
          <p>
            Acerte as seleções vencedoras da copa e ganhe os melhores prêmios da internet!!
          </p>
        </div>
        <div className="home-options">
          <button type="button" onClick={handleClickPartial} className="btn-lg btn btn-warning option">Parcial</button>
          <button type="button" onClick={handleClickGuess} className="btn-lg btn btn-success option">Palpitar</button>
        </div>
        <div className="home-rodape">
          <img src={Logo} alt="logo" className="home-rodape-logo" />
          <div className="home-rodape-text">
            <h1 className="home-rodape-text1">COPA DO MUNDO FIFA</h1>
            <h1 className="home-rodape-text2">Qatar 2022 </h1>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Home;