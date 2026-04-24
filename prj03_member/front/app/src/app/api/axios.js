import axios from 'axios';

const api = axios.create({
  timeout: 5000,
  baseURL: `http://127.0.0.1:80/api`,
});

api.interceptors.request.use(
  (conf) => {
    const token = localStorage.getItem('token');
    if (token) {
      conf.headers['Authorization'] = `Bearer ` + token;
    }
    return conf;
  }, // 성공함수
  () => {} // 실패함수
);

api.interceptors.response.use(
  (resp) => {
    return resp;
  }, // 성공함수
  (err) => {
    return Promise.reject(err);
  } // 실패함수
);

export default api;
