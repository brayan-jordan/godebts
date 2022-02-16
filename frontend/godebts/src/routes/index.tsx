import React from "react"
import { Route, Routes as Switch } from 'react-router-dom';
import Login from "../pages/Login";

const Routes: React.FC = () => (
    <Switch>
        <Route path="/home" element={Login} />
    </Switch>
)