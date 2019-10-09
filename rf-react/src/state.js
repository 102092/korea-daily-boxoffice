
import React, { createContext, useContext, useReducer } from 'react';
import { getAuth } from './services/auth';

export const initialState = {
  postUesrId: null,
  auth: getAuth(),
  posts: [],
  friends: [],
  query: {},
  comments: {},
  postModalOpened: false
};

export const StateContext = createContext();

export const reducer = (state, action) => {
  switch (action.type) {
    case 'login':
      return {
        ...state,
        auth: action.auth
      };
    case 'logout':      
      return {
        ...initialState,
        auth: null
      };
    case 'newPostCreated': 
      return {
        ...state,
        posts: [action.post, ...state.posts]
      }
    case 'appendPosts':
      return {
        ...state,
        posts:
          (action.query.offset != state.query.offset) ?
            [...state.posts, ...action.posts] : state.posts,
        query: action.query,
        postUesrId: action.postUesrId
      }
    case 'getPosts':
      return {
        ...state,
        posts: action.posts,
        query: action.query,
        postUesrId: action.postUesrId
      }
    case 'getComments':
      return {
        ...state,
        comments: {
          ...state.comments,
          [action.postId]: action.comments
        }
      }
    case 'getFriedns': 
      return {
        ...state,
        friends: action.friends
      }
    case 'updatePost': 
      return {
        ...state,
        posts: state.posts.map(v => {
          if (v.seq === action.post.seq) {
            return action.post;
          } else {
            return v;
          }
        })
      }
    case 'openPostModal':
      return {
        ...state,
        postModalOpened: true
      }
    case 'togglePostModal':
      return {
        ...state,
        postModalOpened: action.postModalOpened
      }
    default:
      return state;
  }
};

export const StateProvider = ({reducer, initialState, children}) =>(
  <StateContext.Provider value={useReducer(reducer, initialState)}>
    {children}
  </StateContext.Provider>
);

export const useStateValue = () => useContext(StateContext);
