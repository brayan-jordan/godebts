import React from "react";
import { BannerLogin } from "../Login/styles";
import { InfoCadastro } from "./styles";
import moneybaglogo from '../../assets/moneybaglogo.png';

const Cadastrar: React.FC = () => {
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
            <InfoCadastro>
                <p> Faça seu cadastro </p>
                <form>
                    <input type="text" placeholder="Insira seu nome completo" />
                    <input type="tel" placeholder="Insira seu telefone"/>
                    <input type="date" placeholder="Insira sua data de nascimento" />
                    <input type="email" placeholder="Insira seu email" />
                    <input type="password" placeholder="Insira sua senha" />
                    <input type="password" placeholder="Confirme sua senha" />
                    <button type="submit"> Cadastrar </button>
                </form>
                <h1 className="backtologin"> Já tem uma conta? Faça login</h1>
            </InfoCadastro>
        </>

    )
}

export default Cadastrar;