import React, { createContext, useCallback, useState } from "react";
import { useContext } from "react";
import api from "../service/api"


interface AuthState {
  jwt: string;
  usuario: object;
}

interface SignInCredentials {
  email: string;
  senha: string;
}

interface AuthContextData {
  signIn(credentials: SignInCredentials): Promise<void>;
  usuario: object;
  signOut(): void
}

export const AuthContext = createContext<AuthContextData>(
  {} as AuthContextData
);

export const AuthProvider: React.FC = ({children}) => {
  const [data, setData] = useState<AuthState>(() => {
    const jwt = localStorage.getItem("@Godebts:token");
    const usuario = localStorage.getItem("@Godebts:usuario")

    if (jwt && usuario) {
      return { jwt , usuario: JSON.parse(usuario)};
    }

    return {} as AuthState;
  });

  const signIn = useCallback( async ({email, senha}) => {
    const response = await api.post("login", {
      email,
      senha
    });

    const { jwt, usuario } = response.data;

    localStorage.setItem("@Godebts:token", jwt);
    localStorage.setItem("@Godebts:usuario", JSON.stringify(usuario))
    setData({ jwt, usuario });
  }, []);

  const signOut = useCallback(() => {
    localStorage.removeItem("@Godebts:token");
    localStorage.removeItem("@Godebts:usuario");

    setData({} as AuthState);

  }, [])

  return (
    <AuthContext.Provider value={{usuario: data.usuario, signIn, signOut}}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth(): AuthContextData {
  const context = useContext(AuthContext);

  if(!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }

  return context;
}