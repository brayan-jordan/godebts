import React from "react";
import { BannerLogin } from "./styles";
import moneybaglogo from '../../assets/moneybaglogo.png';

const Login: React.FC = () => {
    return (
        <>
            <BannerLogin>
                <div className="segura">
                    <img src={moneybaglogo} alt="" />
                </div>
            </BannerLogin>
        </>
    )
}

export default Login