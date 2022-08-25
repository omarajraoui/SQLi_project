import React from 'react'
import { Redirect } from 'react-router-dom'
import { useLocation } from 'react-router';


 const Auth = () => {



  const isTokenExpired = () =>{
    const dateJour = new Date();
    const payload = parseJwt(getToken());
    const exp = payload["exp"]; 
    const dExpiration = new Date(0);
    dExpiration.setUTCSeconds(parseInt(exp));
    return (dExpiration<dateJour);
}

function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
    return JSON.parse(jsonPayload);
};

    const location = useLocation();
    console.log("location.pathname",location.pathname);
        if(isTokenExpired()){
          localStorage.removeItem('token');
          return <Redirect to={{ pathname: '/login' }} />;
        }
    else {
        if(location.pathname=='/'){
            return <Redirect to={{ pathname: '/' }} />;
        }
    }
  }
    


export default Auth