import React from 'react';
import ReactDOM from 'react-dom';
var axios = require('axios');

function InventoryElement(props) {
  const modifyCount = (id, movement) => {
    var data = JSON.stringify({
      id: id,
      direction: movement,
    });

    var config = {
      method: 'post',
      url: 'http://localhost:8080/modifycount',
      headers: {
        'Content-Type': 'application/json',
      },
      data: data,
    };
    axios(config)
      .then(function (response) {
        console.log(JSON.stringify(response.data));
        props.refreshPage();
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  const deleteItem = (id) => {
    var data = JSON.stringify({
      id: id,
    });

    var config = {
      method: 'post',
      url: 'http://localhost:8080/deleteinventoryitem',
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
  const countPlus = (id) => {
    modifyCount(id, '+');
  };
  const countMinus = (id) => {
    modifyCount(id, '-');
  };
  const itemDelete = (id) => {
    deleteItem(id);
  };

  return (
    <div key={props.id} className="four wide column">
      <div className="ui segment">
        <h4 className="ui right floated header">
          {props.name} <span>Count:{props.count}</span>{' '}
          <div className="buttonContainer">
            <button className="ui button" onClick={() => countPlus(props.id)}>
              +
            </button>{' '}
            <button className="ui button" onClick={() => countMinus(props.id)}>
              -
            </button>
            <button className="ui button" onClick={() => itemDelete(props.id)}>
              Delete
            </button>
          </div>
        </h4>
        <div className="ui clearing divider"></div>
      </div>
    </div>
  );
}

export default InventoryElement;
