import React from 'react';
import './App.css';
import { Navigation } from './components/navigation/Navigation';
import { Posts } from './containers/posts/Posts'
import { Router } from "@reach/router"
import Friends from './containers/friends/Friends'
import { Login } from './components/login/Login'
import Signup from './components/signup/Signup'
import { StateProvider, reducer, initialState } from './state';
import PostModal from './components/postModal/PostModal';
import Moment from 'react-moment';
import 'moment/locale/ko';

Moment.globalLocale = 'ko';

const App = () => {
  return (
    <StateProvider initialState={initialState} reducer={reducer}>    
      <Navigation></Navigation>

      <div className="container">
        <Router>
          <Posts path="/" />
          <Friends path="/friends" />
          <Posts path="/friends/:friendId"/>
          <Login path='/login' />
          <Signup path='/signup' />
        </Router> 
      </div>
      
      <PostModal></PostModal>

    </StateProvider>
  );
}

export default App;
