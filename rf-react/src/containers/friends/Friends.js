import React, { useEffect } from "react";
import { Button } from "reactstrap";
import "./Friends.css";
import Octicon, { Person } from "@githubprimer/octicons-react";
import { getFreinds } from "../../Api";
import { useStateValue } from "../../state";
import { Link } from "@reach/router";

const Friend = props => {
  return (
    <li>
      <div className="user-thumb">
        {
          // <img src="https://s3.ap-northeast-2.amazonaws.com/grepp-cloudfront/programmers_imgs/learn/instructor_img/instructor_yunkiMoon_circle.png" alt="author"/>
        }
      </div>
      <div className="noti-text">
        <Link to={`./${props.seq}`} className="h6 noti-account">
          {props.name ? props.name : props.email.address}
        </Link>
      </div>
      <span className="noti-icon">
        <Button color="danger">
          <Octicon icon={Person} size="small" /> 친구 제거
        </Button>
        {/* <a href="#" className="btn btn-sm btn-primary"><i class="fas fa-user-plus"></i>친구 추가</a> */}
      </span>
    </li>
  );
};

const Friends = () => {
  const [{ friends }, dispatch] = useStateValue();

  useEffect(() => {
    getFreinds().then(friends => {
      dispatch({
        type: "getFriedns",
        friends
      });
    });
  }, [friends.length]);

  return (
    <div className="row">
      <div className="ui-box">
        <div className="dropdown-title">
          <h6 className="title">친구목록</h6>
        </div>
        <ul className="noti-list friend-requests">
          {friends.length > 0 ? (
            friends.map(v => <Friend key={v.seq} {...v} />)
          ) : (
            <li>친구가 없습니다.</li>
          )}
        </ul>
      </div>
    </div>
  );
};

export default Friends;
