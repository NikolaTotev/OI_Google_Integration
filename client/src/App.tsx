import React from 'react';
import logo from './logo.svg';
import './App.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { solid, regular, brands, icon } from '@fortawesome/fontawesome-svg-core/import.macro'
import Button from '@mui/material/Button';
import { GoogleOAuthProvider } from '@react-oauth/google';
import client_id from './secrets';
import Login from './components/login';
import { GoogleLogin } from "@react-oauth/google";
import { useEffect } from 'react';
import { gapi } from 'gapi-script';

function App() {

  const clientID: string = client_id();


  const testBackend = async () => {

    console.log("PRESSING THE BUTTON!!!")
    const response = await fetch("http://localhost:8080/users/user", {
      method: 'GET',
      credentials: 'include',
      headers: {
        'Content-Type': 'application/json'
      },
      
    });

    if (response.status == 200) {
      console.log("GET Successful!")
      console.log(response.text())
      return response.json();

    }
    

    if (response.status != 200) {
      console.log("GET FAILED")
      console.log(response.text())
      return { token: "invalid" }
    }

  }




  return (
    <GoogleOAuthProvider clientId={clientID}>
      <div className="App">
        <header className="App-header">
          <p style={{ color: "#424242" }}>
            Font awesome icons test:
          </p>
          <FontAwesomeIcon icon={solid('check')} color="#4caf50" />

          <p style={{ color: "#424242" }}>
            MUI Component test:
          </p>
          <Button onClick={() => testBackend()}>
            This is a button
          </Button>

          <p>
            Everthing is working!
          </p>
          <a style={{ color: "#4caf50" }}
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Good Job :D
          </a>
          <GoogleLogin
            onSuccess={credentialResponse => {
              console.log(credentialResponse);

            }}
            onError={() => {
              console.log('Login Failed');
            }}
            useOneTap
          />
        </header>


      </div>
    </GoogleOAuthProvider>


  );
}

export default App;
