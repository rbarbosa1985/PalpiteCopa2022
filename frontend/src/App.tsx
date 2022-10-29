import 'bootstrap/dist/css/bootstrap.css';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';
import Rotas from './routes';

function App() {
  return (
    <>
      <ToastContainer />
      <Rotas />
    </>
  )
}

export default App
