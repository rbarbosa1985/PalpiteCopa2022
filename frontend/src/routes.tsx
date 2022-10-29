import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/home";
import Partial from "./pages/partial";
import Guess from "./pages/guess";


function Rotas() {
  return (
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home/>}/>
        {/* <Route path="teams" element={<Teams />}>
          <Route path=":teamId" element={<Team />} />
          <Route path="new" element={<NewTeamForm />} />
          <Route index element={<LeagueStandings />} />
         */}
      <Route path="/partial" element={<Partial/>} />
      <Route path="/guess" element={<Guess/>} />
    </Routes>
  </BrowserRouter>
  )
}

export default Rotas;

