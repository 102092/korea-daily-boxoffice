import React, { useState } from './node_modules/react'
import './Signup.css';
import { Link } from './node_modules/@reach/router';
import { signup, userExists } from '../../api';
import { navigate } from './node_modules/@reach/router';

const Signup = () => {
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [rePassword, setRePassword] = useState("");
  const [file, setFile] = useState("");

  const onChange = e => setFile(e.target.files[0]);

  const join = (e) => {
    e.preventDefault();

    if (password !== rePassword) {
      alert('패스워드가 동일하지 않습니다.');
      return;
    }
    userExists(email)
      .then(v => {
        if (v === true) {
          throw new Error(`${email} 해당 이메일은 이미 존재 합니다.`);
        }
        return true;
      })
      .then(v => signup(email, name, password, file))
      .then(v => {
        console.log("!!!", v)
        alert(`${email}로 가입이 완료되었습니다.`);
        navigate('/login')
      })
      .catch(e => {
        if (e.response) {
          alert(e.response.data.message);
        }
        if (e.message) {
          alert(e.message);
        }
        console.dir(e);

      })

    return false;
  }

  return (
    <>
      <h1 className="text-center signup-title">계정 만들기</h1>
      <div className="account-wall">
        <form className="form-signup" onSubmit={join}>
          <div className="form-group">
            <input type="text" className="form-input" name="email" id="email" placeholder="Your Email"
              value={email} onChange={v => setEmail(v.target.value)} />
          </div>
          <div className="form-group">
            <input type="text" className="form-input" name="name" id="name" placeholder="Your Name"
              value={name} onChange={v => setName(v.target.value)} />
          </div>
          <div className="form-group">
            <input type="file" className="form-input" name="file" id="file" placeholder="사진" onChange={onChange} />
          </div>

          <div className="form-group">
            <input type="password" className="form-input" name="password" id="password" placeholder="Password"
              value={password} onChange={v => setPassword(v.target.value)} />
          </div>
          <div className="form-group">
            <input type="password" className="form-input" name="re_password" id="re_password" placeholder="Repeat your password"
              value={rePassword} onChange={v => setRePassword(v.target.value)} />
          </div>
          <button className="btn btn-lg btn-primary btn-block" type="submit">가입하기</button>
        </form>
      </div>
      <p className="text-help text-center">
        이미 계정이 있으신가요?
        {" "}
        <Link to="/login" className="text-center login-here">로그인 하기</Link>
      </p>
    </>
  )
}

export default Signup;