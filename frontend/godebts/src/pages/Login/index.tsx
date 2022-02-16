import React from "react";
import { BannerLogin, InfoLogin  } from "./styles";
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
            <InfoLogin>
                <p>Faça seu login</p>
                <input type="text" placeholder="Insira seu email, telefone, nome de usuário"/>
                <input type="text" placeholder="Insira sua senha, chave de acesso"/>
                <button> Entrar </button>
                <h1 className="esqueceusenha"> Esqueceu sua senha?</h1>
                <h1 className="cadastrese"> Não tem uma conta? Cadastre-se</h1>
            </InfoLogin>
        </>
    )
}

export default Login