import api from "../../../app/api/axios";

export async function insert(vo) {
    return await api.post(`book`, vo);
}


export function selectAll() {

    return api.get(`book`);
}

export function selectOne(id) {

    return api.get(`book/${id}`);
}
