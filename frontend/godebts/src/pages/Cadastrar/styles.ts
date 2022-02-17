import styled from "styled-components";
import { shade } from "polished";

export const InfoCadastro = styled.div`
    background-color: #DBDBDB;
    height: 657px;
    width: 516px;
    float: left;
    display: flex;
    flex-direction: column;
    text-align: center;

    p {
        font-family: 'Roboto', sans-serif;
        color: #071454;
        font-size: 40px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 50px;
        font-weight: bold;
    }

    input {
        margin-top: 30px;
        margin-left: auto;
        margin-right: auto;
        height: 35px;
        border: 1px solid;
        width: 350px;
        color: #071454;
        outline: 0;
        font-weight: bold;
        border-style: solid;
        font-size: 16px;
        border-radius: 10px;
        text-align: center;

        :focus::placeholder {
            color:transparent;
        }

        ::placeholder {
            margin-top: 1px;
            color: #2C3333;
            font-size: 16px;
        }
    }

    button {
        cursor: pointer;
        font-weight: bold;
        font-size: 24px;
        background-color: #478CD1;
        width: 230px;
        height: 45px;
        color: #FFF;
        margin-top: 30px;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
        border: 0 none;
        border-radius: 10px;

        transition: background-color 0.4s;

        &:hover {
            background: ${shade(0.4, '#2666CF')};
        }
    }

    .backtologin {
        margin-top: 20px;
        cursor: pointer;
        width: 200px;
        margin-left: auto;
        margin-right: auto;
        font-family: 'Roboto', sans-serif;
        font-size: 20px;
        color: #2C3333;
        font-weight: 600;

        transition: background-color 0.4s;

        &:hover {
            color: ${shade(0.4, '#222426')};
        }
    }
`