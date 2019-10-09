import React, { useState, useEffect, useRef } from 'react'
import Post from '../../components/post/Post'
import './Posts.css';
import { useStateValue } from '../../state';
import { getPost, likePost } from '../../api';
import { Redirect } from '@reach/router';

const pageCount = 5

export const Posts = ( { friendId }) => {  
  const [{ posts, auth,  }, dispatch] = useStateValue();
  const [error, setError] = useState(null);  
  const [query, setQuery] = useState({
    offset: 0,
    limit: pageCount
  });
  const latestQuery = useRef(query);
  const latestPosts = useRef(posts);

  useEffect(() => {
    latestQuery.current = {
      offset: query.offset,
      limit: query.limit
    };
  });

  useEffect(() => {
    latestPosts.current = posts;
  });

  const handleResult = posts => {
    setError(null);
    dispatch({
      type: (query.offset === 0) ? 'getPosts' : 'appendPosts',
      posts,
      query,
      postUesrId: friendId || auth.userKey
    });
  };

  const handleError = e => {
    console.error(e);
    if (e.response.status === 404) {
      setError('사용자를 찾을 수 없습니다.');
    }
  }

  const handleScroll = (e) => {
    var d = document.documentElement;
    var offset = Math.max(window.pageYOffset, d.scrollTop, document.body.scrollTop) + window.innerHeight;
    var height = d.offsetHeight;
    // console.log(Math.round(offset), height)
    // console.log(latestQuery.current.length, latestQuery.current.offset + pageCount)
    if (Math.round(offset) == height && latestPosts.current.length == latestQuery.current.offset + pageCount) {
      setQuery({
        offset: latestQuery.current.offset + pageCount,
        limit: pageCount
      });
    } 
  }

  useEffect(() => {
    window.addEventListener('scroll', handleScroll);
    return () => {      
      window.addEventListener('scroll', handleScroll);
    }
  }, [])

  useEffect(() => {
    if (friendId || auth) {
      getPost(friendId || auth.userKey, query)
        .then(handleResult)
        .catch(handleError); 
    }
  }, [friendId, query])
  
  const likeThisPost = v => {  
    likePost(friendId || auth.userKey, v.seq)
      .then(post => {
        console.log(v);
        dispatch({
          type: 'updatePost',
          post
        });
      })
  }

  return (
    <div className="row">
      {
        (error) ? <div className="col-12 text-center mt-5"><h1>{error}</h1> </div> :
        (friendId) ? posts.map(v => {          
          return <Post key={v.seq} {...v}
            username={(v.writer) ? v.writer.name : v.writer.email.address}
            onLikeClick={e => {likeThisPost(v); e.preventDefault();}}></Post>
        }) : 
        (auth) ? posts.map(v => {
          return <Post key={v.seq} {...v} username={(auth.name) ? auth.name : auth.email}
            onLikeClick={e => { likeThisPost(v); e.preventDefault(); }}></Post>
        }) : <Redirect to='/login' noThrow></Redirect>
      }
    </div>
  )
}
