import api from '../../../app/api/axios';

export async function noticeInsert() {
  return await api.get(`/notice/insert`);
}
