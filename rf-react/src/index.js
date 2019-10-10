import React from "react";
import ReactDOM from "react-dom";
import "bootstrap/dist/css/bootstrap.min.css";

import "./index.css";
import App from "./App";
import * as serviceWorker from "./serviceWorker";

askPermission().then(status => {
  if (status === "denied") {
    console.log(
      "[Notification.requestPermission] The user has blocked notifications."
    );
  } else if (status === "granted") {
    console.log(
      "[Notification.requestPermission] Initializing service worker."
    );
  }
});

ReactDOM.render(<App />, document.getElementById("root"));

function askPermission() {
  return new Promise(function(resolve, reject) {
    const permissionResult = Notification.requestPermission(function(result) {
      resolve(result);
    });

    if (permissionResult) {
      permissionResult.then(resolve, reject);
    }
  }).then(permissionResult => {
    if (permissionResult !== "granted") {
      console.error("We weren't granted permission.");
    }
    return permissionResult;
  });
}

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.register();
