import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import Login from './pages/Login';
import GlobalStyle from './styles/global';


function App() {
  return (
    <>
     <Login /> 
     <GlobalStyle />
    </>
  );
}

export default App;
