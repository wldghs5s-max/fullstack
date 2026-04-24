import api from '../../../app/api/axios';

export async function boardInsert(vo) {
  return await api.get(`/board/insert`);
}
