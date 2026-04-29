import api from "../../../app/api/axios";

export async function join(vo) {
    const resp = await api.post(`/auth/join`, vo);
    return resp;
}

export async function login(vo) {
    const resp = await api.post(`/auth/login`, vo);
    return resp;
}

