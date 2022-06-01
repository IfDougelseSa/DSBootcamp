import { ReactComponent as CarImg } from "../../assets/img/car.svg";
import "./styles.css";
import Buttom from "../../components/buttom";
import { Link } from "react-router-dom";
const Home = () => {
  return (
    <>
     

      <div className="home-principal">
        <div className="home-image-principal">
          <CarImg />
        </div>
        <div className="home-content-principal">
          <h3>O carro perfeito para você</h3>
          <p className="phrase-content">
            Conheça nossos carros e dê mais um passo na realização do seu sonho
          </p>
        </div>
      </div>

      <div className="base-card home-secondary">
          <Link to="/cars">
          <Buttom />
          </Link>
         <span className="button-phrase">Comece agora a navegar</span>
      </div>
    </>
  );
};

export default Home;
