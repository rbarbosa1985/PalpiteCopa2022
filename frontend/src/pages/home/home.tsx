import "./styles.css";
import Logo from "../../assets/images/logo.png";

function Home() {
  return(
    <div className="home-container">
      <div className="home-title">
        <img src={Logo} alt="logo" className="home-title-logo" />
        <div className="home-title-text">
          <h1 className="home-title-text1">COPA DO MUNDO FIFA</h1>
          <h1 className="home-title-text2">Qatar 2022 </h1>
        </div>
      </div>
      <div className="home-text">
        <p>
          Participe do nosso bolão. 
        </p>
        <p>
          Acerte as seleções vencedoras da copa e ganhe os melhores prêmios da internet!! 
        </p>
      </div>
      {/* <button>Palpite Já</button> */}
    </div>
  )
}

export default Home;