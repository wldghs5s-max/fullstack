import api from "../../../app/api/axios";

export async function insert(vo) {
    return await api.post(`/user/board`, vo);
}
export async function selectList(pno, condition) {
    const { title, content, nick } = condition;
    return await api.get(`/public/board`, {
        params: {
            title,
            content,
            nick,
            pno
        }
    })

}
export async function selectOne(id) {
    return await api.get(`/public/board/${id}`);
}
export async function update(vo) {
    return await api.put(`/user/board/${vo.id}`, vo);
}
export async function del(id) {
    return await api.delete(`/user/board/${id}`);
}