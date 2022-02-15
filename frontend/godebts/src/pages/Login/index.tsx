import React from "react";
import { BannerLogin } from "./styles";
import moneybaglogo from '../../assets/moneybaglogo.png';

const Login: React.FC = () => {
    return (
        <>
            <BannerLogin>
                <div className="segura">
                    <p> Go </p>
                    <img src={moneybaglogo} alt="" />
                </div>
                <div className="segura"> 
                    <p> Debts </p>
                </div>
            </BannerLogin>
        </>
    )
}

export default Login