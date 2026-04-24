import { boardInsert } from '../api/boardApi';

function useBoard() {
  async function handleBoardInsert(vo) {
    const resp = await boardInsert(vo);
    return resp.status;
  }

  return { handleBoardInsert };
}

export default useBoard;
