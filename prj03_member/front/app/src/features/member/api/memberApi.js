import api from '../../../app/api/axios';

export async function join(vo) {
  return api.post('/member/join', vo);
}

export async function login(vo) {
  return api.post('/login', vo);
}
