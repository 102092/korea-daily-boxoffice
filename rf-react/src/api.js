import axios from "axios";
import { getAuthToken } from "./services/auth";

const url = "/api";

axios.defaults.headers.post["Content-Type"] = "application/json";

export function login({ email, passwd }) {
  return axios
    .post(`${url}/auth`, {
      principal: email,
      credentials: passwd
    })
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error();
      }
      return v.response;
    });
}

export function getPost(userId, { offset, limit }) {
  return axios
    .get(`${url}/user/${userId}/post/list`, {
      ...getApiKeyHeader(),
      params: {
        offset,
        limit
      }
    })
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error(v.error.message);
      }
      return v.response;
    });
}

export function getComments(userId, postId) {
  return axios
    .get(`${url}/user/${userId}/post/${postId}/comment/list`, {
      ...getApiKeyHeader()
    })
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error(v.error.message);
      }
      return v.response;
    });
}

export function getFreinds() {
  return axios
    .get(`${url}/user/connections`, getApiKeyHeader())
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error(v.error.message);
      }
      return v.response;
    });
}

export function sendPost(contents) {
  return axios
    .post(`${url}/post`, { contents }, getApiKeyHeader())
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error();
      }
      return v.response;
    });
}

export function writeComment(userId, postId, contents) {
  return axios
    .post(
      `${url}/user/${userId}/post/${postId}/comment`,
      { contents },
      getApiKeyHeader()
    )
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error();
      }
      return v.response;
    });
}

export function likePost(userId, postId) {
  return axios
    .patch(`${url}/user/${userId}/post/${postId}/like`, {}, getApiKeyHeader())
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error();
      }
      return v.response;
    });
}

export function signup(principal, name, credentials, file) {
  const formData = new FormData();
  formData.append("principal", principal);
  formData.append("name", name);
  formData.append("credentials", credentials);
  formData.append("file", file);

  return axios
    .post(`${url}/user/join`, formData, {
      headers: { "content-type": "multipart/form-data" }
    })
    .then(v => v.data)
    .then(v => {
      console.log("???", v);
      if (!v.success) {
        throw new Error();
      }
      return v.response;
    });
}

export function userExists(address) {
  return axios
    .post(`${url}/user/exists`, { address })
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error();
      }
      return v.response;
    });
}

export function getMe() {
  return axios
    .get(`${url}/user/me`, getApiKeyHeader())
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error();
      }
      return v.response;
    });
}

export function sendSubscription(subscription) {
  return axios
    .post(`${url}/subscribe`, subscription, getApiKeyHeader())
    .then(v => v.data)
    .then(v => {
      if (!v.success) {
        throw new Error();
      }
      return v.response;
    });
}

function getApiKeyHeader() {
  const token = getAuthToken();
  if (token) {
    return {
      headers: {
        api_key: "Bearer " + getAuthToken()
      }
    };
  } else {
    return {};
  }
}
