import React from './node_modules/react'
import './Login.css';
import { Redirect, Link } from './node_modules/@reach/router'
import { useStateValue } from '../../state';
import { login } from '../../api';
import jwtDecode from './node_modules/jwt-decode';

export const Login = () => {
  const [email, setEmail] = React.useState("");
  const [passwd, setPasswd] = React.useState("");
  const [{ auth }, dispatch] = useStateValue()

  const changeEmail = e => {
    setEmail(e.currentTarget.value);
  };
  const changePasswd = e => {
    setPasswd(e.currentTarget.value);
  };

  if (auth) {
    return (<Redirect to="/" noThrow />);
  }

  const handleSubmit = async () => {
    try {
      const rep = await login({ email, passwd });
      const auth = jwtDecode(rep.apiToken);

      localStorage.setItem('auth_token', rep.apiToken);
      dispatch({
        type: 'login',
        auth
      });
    } catch (error) {
      alert(error);
    }
    return false;
  };

  return (
    <>
      <h1 className="text-center login-title">웹 트랙 로그인</h1>
      <div className="account-wall">
        <form className="form-signin">
          <input type="email" value={email} onChange={changeEmail} className="form-control" placeholder="Email" required autoFocus />
          <input type="password" value={passwd} onChange={changePasswd} className="form-control" placeholder="Password" required />
          <button onClick={() => { handleSubmit(); return false; }} className="btn btn-lg btn-primary btn-block" type="button">로그인</button>
        </form>
      </div>
      <p className="text-help text-center">
        계정이 필요하신가요?
        {" "}<Link to="/signup" className="text-center new-account">계정 만들기</Link>
      </p>
    </>
  )
}