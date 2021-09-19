import React, { useState } from 'react';
import ReactDOM from 'react-dom';

function InputComponent(props) {
  const [inputValue, setInputValue] = useState('');

  const addNewElement = (newElementName) => {
    var axios = require('axios');
    var data = JSON.stringify({
      name: newElementName,
    });

    var config = {
      method: 'post',
      url: 'http://localhost:8080/addnewinventoryitem',
      headers: {
        'Content-Type': 'application/json',
      },
      data: data,
    };

    axios(config)
      .then(function (response) {
        props.refreshPage();
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div key={1}>
      <div className="ui input">
        <input type="text" placeholder="Search..." value={inputValue} onChange={(e) => setInputValue(e.target.value)} />
      </div>
      <button
        className="ui button"
        onClick={() => {
          addNewElement(inputValue);
        }}
      >
        add
      </button>
    </div>
  );
}

export default InputComponent;
