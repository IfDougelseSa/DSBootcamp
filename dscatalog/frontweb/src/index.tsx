import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

//O React.StrictMode renderiza o App, e o document.getElementById pega a pagina renderizada e exibi 
