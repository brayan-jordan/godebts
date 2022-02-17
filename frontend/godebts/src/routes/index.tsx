import React from "react"
import { Route, Routes as Switch } from 'react-router-dom';
import Login from "../pages/Login";
import Home from "../pages/Home";
import Cadastrar from "../pages/Cadastrar";


const Routes: React.FC = () => (
    <Switch>
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<Home />} />
        <Route path="/cadastrar" element={<Cadastrar />} />
    </Switch>
)

export default Routes;