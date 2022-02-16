import React from "react"
import { Route, Routes as Switch } from 'react-router-dom';
import Login from "../pages/Login";
import Home from "../pages/Home";


const Routes: React.FC = () => (
    <Switch>
        <Route path="/login" element={<Login />} />
        <Route path="/home" element={<Home />} />
    </Switch>
)

export default Routes;