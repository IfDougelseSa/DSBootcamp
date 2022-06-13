import { ReactComponent as ArrowIcon } from 'assets/img/arrow.svg';
import ProductPrice from 'components/ProductPrice';
import { Link } from 'react-router-dom';
import { Product } from 'types/product';
import axios from 'axios';

import './styles.css';
import { BASE_URL } from 'util/requests';

const ProductDetails = () => {

  //Forma incorreta
  let product : Product;

  //FORMA INCORRETA
  axios.get(BASE_URL + "/products/2")
    .then(response => {
      console.log(response.data)
    })






  return (
    <div className="product-detials-container">
      <div className="base-card product-details-card">
          <Link to="/products">
        <div className="goback-container">
            <ArrowIcon />
            <h2>Voltar</h2>
        </div>
        </Link>
        <div className="row">
          <div className="col-xl-6">
            <div className="img-container">
                <img src="https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg" alt="Nome do produto"></img>
            </div>
            <div className="name-price-container">
                <h1>Nome do produto</h1>
                <ProductPrice price={2345.67} />
            </div>
          </div>
          <div className="col-xl-6">
            <div className="description-container">
                <h2>Descrição do produto</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Exercitationem, consectetur.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProductDetails;
