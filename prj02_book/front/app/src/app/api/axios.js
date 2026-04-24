import axios from "axios";

const api = axios.create({
    baseURL: 'http://54.180.116.136:8001/api',
    timeout: 5000
});

// const api = axios.create({
//     baseURL: 'http://15.164.103.135:8001/api',
//     timeout: 5000
// });

export default api;