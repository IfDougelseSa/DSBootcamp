import "./styles.css";
import CarImg from "../../assets/img/car-card.png";
import BuyBottom from "../BuyButtom";

const CarCard = () => {
  return (
    <>
      <div className="base-card car-card">
        <div className="card-top-container">
          <img src={CarImg} alt="Nome do carro" />
        </div>
        <div className="card-bottom-container">
          <h6>Audi Supra TT</h6>
          <p className="text">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit.
            Cupiditate, nisi
          </p>
          <div className="change-buttom">
          <BuyBottom />
          </div>
        </div>
      </div>
    </>
  );
};

export default CarCard;
