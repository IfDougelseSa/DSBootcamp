import { formatterPrice } from 'util/formatters';
import './styles.css';

type Props = {
    price: number;
}

const ProductPrice = ( { price } : Props) => {

    return(
        <div className="product-price-container">
            <span>R$</span> 
            <h3>{formatterPrice(price)}</h3>   
         </div>
    )
}

export default ProductPrice;