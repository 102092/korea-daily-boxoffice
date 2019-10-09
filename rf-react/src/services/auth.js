import jwtDecode from 'jwt-decode';

const getAuthToken = () => {
  return localStorage.getItem("auth_token");
};

const getAuth= () => {
  const authToken = localStorage.getItem("auth_token");
    if (authToken) {
      return jwtDecode(authToken);
    }
    return null;
};

export { getAuthToken, getAuth };