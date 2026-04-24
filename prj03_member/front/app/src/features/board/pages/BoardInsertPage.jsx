import React from 'react';
import useBoard from '../hooks/userBoard';

function BoardInsertPage() {
  const { handleBoardInsert } = useBoard();

  async function handleClick() {
    const title = 'ttt';
    const content = 'ccc';

    const vo = { title, content };
    const result = await handleBoardInsert(vo);
    alert(result);
  }

  return (
    <>
      <h1>BoardInsertPage</h1>
      <button onClick={handleClick}>INSERT</button>
    </>
  );
}

export default BoardInsertPage;
