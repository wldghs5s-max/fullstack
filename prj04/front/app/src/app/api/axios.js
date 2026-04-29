import axios from "axios";

const api = axios.create({
    baseURL: `http://127.0.0.1:80/api`,
    timeout: 5000,
});

// 토큰 재발급 중복 방지
let isRefreshing = false;
let refreshSubscribers = [];

// 재요청 대기열 처리
function onRefreshed(newToken) {
    refreshSubscribers.forEach((callback) => callback(newToken));
    refreshSubscribers = [];
}

function addRefreshSubscriber(callback) {
    refreshSubscribers.push(callback);
}

api.interceptors.request.use(
    (config) => {
        const accessToken = localStorage.getItem("accessToken");

        // public 요청 제외하고만 토큰 붙이기
        if (accessToken && !config.url.includes("/public")) {
            config.headers.Authorization = accessToken;
        }

        return config;
    },
    (error) => Promise.reject(error)
);
api.interceptors.response.use(
    (resp) => {
        return resp;
    },
    (error) => {
        console.log("axios error ~~~");
        const status = error.response?.status;

        if (status >= 401 && status < 500) {
            // 토큰 삭제
            localStorage.removeItem("accessToken");
            // 사용자에게 알림
            alert("로그인이 만료되었습니다. 다시 로그인해주세요.");
            // 로그인 페이지 이동
            location.href = "/member/login";
        }
        return Promise.reject(error);
    },
);

export default api;
