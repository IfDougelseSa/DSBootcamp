import "./styles.css";
import 'bootstrap/js/src/collapse.js';

const Navbar = () => {
  return (
    <nav className="navbar bg-primary navbar-expand-md main-nav navbar-light">
      <div className="container-fluid">
        <a href="link" className="nav-logo-text">
          <h4>Carros top</h4>
        </a>
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
              <a href="link" className="active">
                HOME
              </a>
            </li>
            <li className="space2">
              <a href="link">CATÁLOGO</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
