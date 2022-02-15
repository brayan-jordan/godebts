import styled from "styled-components";

export const BannerLogin = styled.div`
    background-color: #478CD1;
    height: 657px;
    width: 850px;
    float: left;
    display: block;
    flex-direction: column;

    .segura {
        width: 300px;
        height: 130px;
        position: relative;
        top: 35%;
        transform: translateY(-50%); 
        margin: auto;
        display: flex;
        justify-content: space-between;

        p {
            font-family: 'Rum Raisin', sans-serif;
            font-size: 130px;
            color: #FFF;
            font-weight: 550;
            margin-left: 30px;
        }

        img {
            width: 128px;
            height: 128px;
            margin-top: 20px;
            margin-right: 10px;
        }
    }
`

export const InfoLogin = styled.div`
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
        margin-top: 160px;
        font-weight: bold;
    }

    input {
        margin-top: 30px;
        margin-left: auto;
        margin-right: auto;
        height: 35px;
        border: 1px solid;
        width: 350px;
        outline: 0;
        border-style: solid;
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
        width: 200px;
        height: 45px;
        color: #FFF;
        margin-top: 30px;
        margin-left: auto;
        margin-right: auto;
        text-align: center;
        border: 0 none;
        border-radius: 10px;
    }

`