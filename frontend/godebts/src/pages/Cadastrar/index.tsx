import React, { FormEvent, useCallback } from "react";
import { BannerLogin } from "../Login/styles";
import { InfoCadastro } from "./styles";
import moneybaglogo from '../../assets/moneybaglogo.png';
import { useNavigate } from "react-router-dom";
import { NOMEM } from "dns";
import { MenssagemErro, MenssagemInfo, MenssagemSucesso } from "../../hooks/toast";
import api from "../../service/api";



const Cadastrar: React.FC = () => {
    const navigate = useNavigate();   
    var isError = "";     

    const handleSendCadastro = useCallback(async(event: FormEvent) => {
            try {
                event.preventDefault()

                const getNome = (document.getElementById("nome") as HTMLInputElement).value;
                if (getNome.trim() === "") {
                    MenssagemInfo("Insira o nome")
                    return
                }

                const getData = (document.getElementById("data") as HTMLInputElement).value;

                const getTelefone = (document.getElementById("telefone") as HTMLInputElement).value;
                if (getTelefone.trim() === "") {
                    MenssagemInfo("Insira o telefone")
                    return
                }

                const getEmail = (document.getElementById("email") as HTMLInputElement).value;
                if (getEmail.trim() === "") {
                    MenssagemInfo("Insira o email")
                    return
                }

                const getSenha = (document.getElementById("senha") as HTMLInputElement).value;
                if (getSenha.trim() === "") {
                    MenssagemInfo("Insira a senha")
                    return
                }

                const getConfirmarSenha = (document.getElementById("confirmarsenha") as HTMLInputElement).value;
                if (getConfirmarSenha.trim() === "") {
                    MenssagemInfo("Insira o campo de confirmar senha")
                    return
                }

                if (getConfirmarSenha.trim() !== getSenha.trim()) {
                    MenssagemErro("As senhas nao concidem")
                    return
                }

                await api.post("/usuarios/cadastrar", {nome: getNome, dataNascimento: getData, telefone: getTelefone, email: getEmail, senha: getSenha}).catch
                ((error ) => {isError = (error.response.data.titulo)})

                if (isError.trim() !== '') {
                    MenssagemErro(isError)
                    return
                }

                MenssagemSucesso("Cadastro realizado com sucesso")

                navigate("/")
            } catch (err) {
                console.log(err)
                return
            }
    }, [navigate])
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
                <form onSubmit={handleSendCadastro}>
                    <input id="nome" type="text" placeholder="Insira seu nome completo" />
                    <input id="telefone" type="tel" placeholder="Insira seu telefone"/>
                    <input id="data" type="date" placeholder="Insira sua data de nascimento" />
                    <input id="email" type="email" placeholder="Insira seu email" />
                    <input id="senha" type="password" placeholder="Insira sua senha" />
                    <input id="confirmarsenha" type="password" placeholder="Confirme sua senha" />
                    <button type="submit"> Cadastrar </button>
                </form>
                <h1 className="backtologin"> Já tem uma conta? Faça login</h1>
            </InfoCadastro>
        </>

    )
}

export default Cadastrar;