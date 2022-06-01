
import CarCard from "../../components/CarCard";

const Catalog = () => {
  return (
    <div className="container my-4">
      <div className="row">
        <div className="col-xs-12 col-sm-6 col-xl-4">
          <CarCard />
        </div>
        <div className="col-xs-12 col-sm-6 col-xl-4">
          <CarCard />
        </div>
        <div className="col-xs-12 col-sm-6 col-xl-4">
          <CarCard />
        </div>
        <div className="col-xs-12 col-sm-6 col-xl-4">
          <CarCard />
        </div>
        <div className="col-xs-12 col-sm-6 col-xl-4">
          <CarCard />
        </div>
      </div>
    </div>
  );
};

export default Catalog;
