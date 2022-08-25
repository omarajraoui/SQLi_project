import axios from "axios";
import Login from "../Infos/Login";


const API_URL = "http://localhost:8080/api/";



const register = (username, email, password) => {
  return axios.post(API_URL + "signup", {
    username,
    email,
    password,
  });
};

const getToken =() =>{
  return localStorage.getItem("token");
}

const isTokenExpired =(token) => {
  let token1 = JSON.stringify(token);
  const expiry = (JSON.parse(atob(token1.split('.')[1]))).exp;
  return (Math.floor((new Date).getTime() / 1000)) >= expiry;
}





const login = (username, password) => {
  const params = new URLSearchParams();
  params.append('username', username);
  params.append('password', password);
   axios.post(API_URL+ "login", params)
  .then((response) => {
      console.log(response);
      console.log(response.data);
      if(!isTokenExpired(getToken())){ return(window.location.href = "http://localhost:3000/")}
     
          
  
      // console.log(isTokenExpired(token));

      
      if (response.data) {
        localStorage.setItem("token", response.data["access_token"].replace(/[\"]+/g,''));
      }
      return response.data;
    });
};

const logout = () => {
  localStorage.removeItem("token");
  return axios.post(API_URL + "signout").then((response) => {
    return response.data;
  });
};

const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem("user"));
};

const AuthService = {
  register,
  login,
  logout,
  getCurrentUser,
}

export default AuthService;
