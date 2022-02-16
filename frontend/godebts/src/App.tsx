import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import { AuthProvider } from './hooks/auth';
import Login from './pages/Login';
import GlobalStyle from './styles/global';
import Routes from './routes';


function App() {
  return (
    <>
      <Router>
        <AuthProvider>
          <Routes />
        </AuthProvider>
        <GlobalStyle />
      </Router>
    </>
  );
}

export default App;
