import React, { FormEvent, useCallback, useRef, useState } from "react";
import { BannerLogin, InfoLogin  } from "./styles";
import moneybaglogo from '../../assets/moneybaglogo.png';
import { useAuth } from "../../hooks/auth";
import { Link, useNavigate } from 'react-router-dom';
import { MenssagemErro } from "../../hooks/toast";

const Login: React.FC = () => {
    const { signIn } = useAuth();
    const navigate = useNavigate()

    const handleSendLogin = useCallback(async(event: FormEvent) => {
        try {
            event.preventDefault()
            
            const getEmail = (document.getElementById("email") as HTMLInputElement).value;
            const getPassword = (document.getElementById("password") as HTMLInputElement).value

            console.log(getEmail)
            if (getEmail.trim() === '') {
                return
            }
    
            if (getPassword.trim() === '') {
                return
            }

            await signIn({
                email: getEmail,
                senha: getPassword
            })

            navigate("/home")
    
        } catch(err) {
            MenssagemErro("Erro, email ou senha inválido");
            (document.getElementById('email') as HTMLInputElement).value='';
            (document.getElementById('password') as HTMLInputElement).value='';
        }
    }, [])

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
                <form onSubmit={handleSendLogin}>
                    <input type="email" id="email" placeholder="Insira seu email, telefone, nome de usuário"/>
                    <input type="password" id="password" placeholder="Insira sua senha, chave de acesso"/>
                    <button type="submit"> Entrar </button>
                </form>
                <h1 className="esqueceusenha"> Esqueceu sua senha?</h1>
                <h1 className="cadastrese" onClick={() => navigate("/cadastrar")}> Não tem uma conta? Cadastre-se</h1>
            </InfoLogin>
        </>
    )
}

export default Login