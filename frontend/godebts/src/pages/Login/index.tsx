import React, { FormEvent, useCallback, useRef, useState } from "react";
import { BannerLogin, InfoLogin  } from "./styles";
import moneybaglogo from '../../assets/moneybaglogo.png';
import { useAuth } from "../../hooks/auth";
import { Link, useNavigate } from 'react-router-dom';

const Login: React.FC = () => {
    const [inputLogin, setiInputLogin] = useState("")
    const [inputSenha, setInputSenha] = useState("")
    const { signIn } = useAuth();
    
    const navigate = useNavigate()

    const handleSendLogin = useCallback(async(event: FormEvent) => {
        try {
            event.preventDefault()

            if (inputLogin.trim() === "") {
                return
            }
    
            if (inputSenha.trim() === "") {
                return
            }

            await signIn({
                email: inputLogin,
                senha: inputSenha
            })

            navigate("/home")
    
        } catch(err) {

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
                    <input type="text" value={inputLogin} onChange={event => setiInputLogin(event.target.value)} placeholder="Insira seu email, telefone, nome de usuário"/>
                    <input type="password" value={inputSenha} onChange={event => setInputSenha(event.target.value)} placeholder="Insira sua senha, chave de acesso"/>
                    <button type="submit"> Entrar </button>
                </form>
                <h1 className="esqueceusenha"> Esqueceu sua senha?</h1>
                <h1 className="cadastrese"> Não tem uma conta? Cadastre-se</h1>
            </InfoLogin>
        </>
    )
}

export default Login