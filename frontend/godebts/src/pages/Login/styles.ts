import styled from "styled-components";

export const BannerLogin = styled.div`
    background-color: #478CD1;
    height: 657px;
    width: 850px;
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
            font-weight: bold;
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