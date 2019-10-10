import React, { useState, useEffect } from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink
} from "reactstrap";
import Octicon, { Plus, Organization } from "@githubprimer/octicons-react";
import { Link } from "@reach/router";
import "./Navigation.css";
import { useStateValue } from "../../state";
import { getMe } from "../../Api";

export const Navigation = () => {
  const [isOpen, setisOpen] = useState(false);
  const [{ auth }, dispatch] = useStateValue();
  const [profileImage, setPorfileImage] = useState();

  const toggleNavbar = () => {
    setisOpen(!isOpen);
  };

  const handleSignout = () => {
    localStorage.removeItem("auth_token");
    dispatch({
      type: "logout"
    });
    return false;
  };

  useEffect(() => {
    if (auth) {
      getMe()
        .then(v => setPorfileImage(v.profileImageUrl))
        .catch(alert);
    }
  }, []);

  return (
    <Navbar fixed="true" color="blue" dark expand="md" sticky="top">
      <Link to="/">
        <NavbarBrand tag="span" className="mr-auto">
          <img src="/img/bi-symbol-light.png" alt="프로그래머스 로고"></img>
        </NavbarBrand>
      </Link>
      <NavbarToggler onClick={toggleNavbar} className="mr-2" />
      <Collapse isOpen={isOpen} navbar>
        <Nav navbar className="mr-auto">
          {auth && (
            <NavItem>
              <NavLink onClick={() => dispatch({ type: "openPostModal" })}>
                <Octicon icon={Plus} size="small" /> 공유하기
              </NavLink>
            </NavItem>
          )}
          {auth && (
            <NavItem>
              <Link to="/friends">
                <NavLink tag="span">
                  <Octicon icon={Organization} size="small" /> 친구
                </NavLink>
              </Link>
            </NavItem>
          )}
          {/* <NavItem>
            <NavLink href="#">
              <Octicon icon={Bell} size='small' /> 알림
            </NavLink>
          </NavItem> */}
        </Nav>
        {auth != null ? (
          <Nav navbar>
            <NavItem>
              <NavLink tag="span">
                {profileImage && <img src={profileImage}></img>}
                {auth.name ? auth.name : auth.email}
              </NavLink>
            </NavItem>

            <NavItem>
              <NavLink onClick={handleSignout}>로그아웃</NavLink>
            </NavItem>
          </Nav>
        ) : (
          <Nav navbar>
            <NavItem>
              <Link to="/login">
                <NavLink tag="span">로그인</NavLink>
              </Link>
            </NavItem>

            <NavItem>
              <Link to="/signup">
                <NavLink tag="span">회원가입</NavLink>
              </Link>
            </NavItem>
          </Nav>
        )}
      </Collapse>
    </Navbar>
  );
};
