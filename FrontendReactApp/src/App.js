import React, { useState, useEffect } from 'react';
import ReactDOM from 'react-dom';
import InputComponent from './InputComponent/InputComponent';

import InventoryElement from './InventoryElements/InventoryElement';

const mockSrcFile = [
  { name: 'sample object 1', count: 4, id: 1 },
  { name: 'sample object 2', count: 1, id: 2 },
  { name: 'sample object 3', count: 2, id: 3 },
  { name: 'sample object 4', count: 11, id: 4 },
  { name: 'sample object 1', count: 4, id: 5 },
  { name: 'sample object 2', count: 1, id: 6 },
  { name: 'sample object 3', count: 2, id: 7 },
  { name: 'sample object 4', count: 11, id: 8 },
];

/*
var axios = require('axios');
var data = JSON.stringify({
  "title": "faszomat már",
  "value": 20
});

var config = {
  method: 'get',
  url: 'http://localhost:3005/api/getinventorylist',
  headers: { 
    'Content-Type': 'application/json'
  },
  data : data
};

axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
})
.catch(function (error) {
  console.log(error);
});


*/
function App() {
  const [apiResult, setApiResult] = useState([]);

  const getInventoryList = () => {
    fetch('http://localhost:8080/getinventorylist')
      .then((response) => response.text())
      .then((result) => {
        return setApiResult(JSON.parse(result)[0]);
      })
      .catch((error) => console.log('error', error));
  };

  useEffect(() => {
    getInventoryList();
  }, []);

  return (
    <div className="ui piled segment">
      <InputComponent refreshPage={() => getInventoryList()} />
      <div className="ui grid" id="mainContainer">
        {apiResult.map((a, b) => (
          <InventoryElement id={a.id} name={a.name} count={a.count} refreshPage={() => getInventoryList()} />
        ))}
      </div>
    </div>
  );
}

export default App;
