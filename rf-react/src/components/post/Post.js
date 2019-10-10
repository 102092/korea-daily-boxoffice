import React from "react";
import "./Post.css";
import Octicon, {
  KebabHorizontal,
  Thumbsup,
  Comment
} from "@githubprimer/octicons-react";
import Comments from "../../containers/comments/Comments";
import Moment from "react-moment";

export default function Post(props) {
  // const onLikeClick = e => { props.onLikeClick(); false; };
  return (
    <div className="ui-box">
      <article className="contents">
        <div className="contents-accounts inline-items">
          {/* <img src="https://s3.ap-northeast-2.amazonaws.com/grepp-cloudfront/programmers_imgs/learn/instructor_img/instructor_yunkiMoon_circle.png"
                alt="author"/> */}
          <div className="contents-date">
            <a className="h6 contents-accounts-name">{props.username}</a>
            <div className="published-date">
              <Moment fromNow ago>
                {props.createAt}
              </Moment>
            </div>
          </div>
          <div className="more">
            <Octicon icon={KebabHorizontal} size="small"></Octicon>
            <ul className="featured-dropdown">
              <li>
                <a href="#">게시물 수정</a>
              </li>
              <li>
                <a href="#">게시물 삭제</a>
              </li>
            </ul>
          </div>
        </div>
        <p>{props.contents}</p>
        <div className="contents-info inline-items">
          <a href="#" onClick={props.onLikeClick}>
            <div
              className={
                "contents-icon inline-items" +
                (props.likesOfMe ? " likesOfMe" : "")
              }
            >
              <Octicon icon={Thumbsup} size="small"></Octicon>
              <span>{props.likes}개</span>
            </div>
          </a>
          <a href="">
            <div className="reply">
              <Octicon icon={Comment} size="small"></Octicon>
              <span>{props.comments}개</span>
            </div>
          </a>
        </div>
      </article>
      <Comments postId={props.seq} userId={props.userId}></Comments>
    </div>
  );
}
