import "./styles.css";
import 'bootstrap/js/src/collapse.js';
import { Link, NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar bg-primary navbar-expand-md main-nav navbar-light">
      <div className="container-fluid">
        <Link to="/" className="nav-logo-text">
          <h4>Carros top</h4>
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#dscatalog-navbar"
          aria-controls="dscatalog-navbar"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse main-menu" id="dscatalog-navbar">
          <ul className="navbar-nav offset-md-2">
            <li className="space">
              <NavLink to="/" activeClassName="active" exact>
                HOME
              </NavLink >
            </li>
            <li className="space2">
              <NavLink  to="/cars" activeClassName="active">CATÁLOGO</NavLink >
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
