import React, { useState } from 'react'
import { navigate } from '@reach/router';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import { sendPost } from '../../api';
import { useStateValue } from '../../state'

function PostModal() {
  const [contents, setContents] = useState("");
  const [{ postModalOpened, auth }, dispatch] = useStateValue();

  const toggle = () => {
    dispatch({ 
      type: 'togglePostModal',
      postModalOpened: !postModalOpened
    });
  }

  const post = () => {
    if (contents.length > 0) {
      sendPost(contents)
        .then(v => {
          try {
            navigate('/');
          } catch (e) {
            console.log(e);
            console.dir(e);
          }        
          return v;
        })
        // .then(v => getPost(auth.userKey, query))
        .then(post => {
          dispatch({
            type: 'newPostCreated',
            post,
            postUesrId: auth.userKey
          });
          setContents('')
          toggle();
        })
        .catch(e => {
          if (e.response) {
            alert(e.response.data.message);
          }
          console.dir(e);
        });
    }
  }
  return (
    <Modal isOpen={postModalOpened} toggle={toggle} className='post-modal'>
      <ModalHeader toggle={toggle}>게시물 작성</ModalHeader>
      <ModalBody>
        <form>
          <textarea className="form-control input-lg" 
            autoFocus={true} placeholder="무슨 생각을 하고 계신가요?" spellCheck={false} 
            value={contents} onChange={e => setContents(e.target.value)}>
          </textarea>
        </form>
      </ModalBody>
      <ModalFooter>
        <Button color="primary" onClick={post}>공유하기</Button>
      </ModalFooter>
    </Modal>
  )
}

export default PostModal
