import React, { useEffect, useState } from "react";
import { Button } from "reactstrap";
import "./Comments.css";
import { useStateValue } from "../../state";
import { getComments, writeComment } from "../../Api";
import Moment from "react-moment";

const Comment = props => {
  return (
    <>
      <div className="contents-accounts inline-items">
        {/* <img
          src="https://s3.ap-northeast-2.amazonaws.com/grepp-cloudfront/programmers_imgs/learn/instructor_img/instructor_yunkiMoon_circle.png"
          alt="author" /> */}
        <div className="contents-date">
          <a className="h6 post__author-name" href="#">
            {props.writer.name}
          </a>
          <div className="published-date">
            <Moment fromNow ago>
              {props.createAt}
            </Moment>
          </div>
        </div>
      </div>
      <p>{props.contents}</p>
    </>
  );
};

export default function Comments(props) {
  const [{ postUesrId, comments }, dispatch] = useStateValue();
  const [text, setText] = useState("");

  const handleResults = comments => {
    dispatch({
      type: "getComments",
      postId: props.postId,
      comments
    });
  };
  useEffect(() => {
    getComments(postUesrId, props.postId).then(handleResults);
  }, []);

  const sendPost = e => {
    if (text.length === 0) {
      return false;
    }
    writeComment(postUesrId, props.postId, text)
      .then(_ => getComments(postUesrId, props.postId))
      .then(handleResults)
      .then(_ => setText(""))
      .catch(alert);
  };

  const postCommests = comments[props.postId] || [];

  return (
    <ul className="comments">
      {postCommests.map(v => (
        <li className="comment" key={v.seq}>
          <Comment {...v}></Comment>
        </li>
      ))}
      <form className="comment-form inline-items">
        <div className="contents-accounts inline-items">
          {/* <img src="https://s3.ap-northeast-2.amazonaws.com/grepp-cloudfront/programmers_imgs/learn/instructor_img/instructor_yunkiMoon_circle.png"
            alt="author" /> */}
          <div className="form-group">
            <textarea
              value={text}
              onChange={e => setText(e.target.value)}
              className="form-control"
              placeholder=""
            ></textarea>
          </div>
        </div>
        <Button color="primary" onClick={sendPost}>
          공유하기
        </Button>
      </form>
    </ul>
  );
}
