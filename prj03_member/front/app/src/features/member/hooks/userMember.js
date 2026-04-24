import { join, login } from '../api/memberApi';

function useMember() {
  async function handleJoin(vo) {
    const resp = await join(vo);
    return resp.status;
  }

  async function handleLogin(vo) {
    const resp = await login(vo);
    const token = resp.headers.authorization.replace('Bearer ', '');
    localStorage.setItem('token', token);
    console.log(resp);
    return resp.status;
  }

  return { handleJoin, handleLogin };
}

export default useMember;
