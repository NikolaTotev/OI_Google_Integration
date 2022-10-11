import React from 'react';
import logo from './logo.svg';
import './App.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { solid, regular, brands, icon } from '@fortawesome/fontawesome-svg-core/import.macro'
import Button from '@mui/material/Button';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <p style={{color:"#424242"}}>
          Font awesome icons test:
        </p>
        <FontAwesomeIcon icon={solid('check')} color="#4caf50" />

        <p style={{color:"#424242"}}>
          MUI Component test:
        </p>
        <Button>
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
      </header>
    </div>
  );
}

export default App;
