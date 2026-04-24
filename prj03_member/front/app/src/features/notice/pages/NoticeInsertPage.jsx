import React from 'react';
import userNotice from '../hooks/useNotice';

function NoticeInsertPage() {
  const { handleInsertNotice } = userNotice();

  async function handleClick() {
    const result = await handleInsertNotice();
    alert(result);
  }

  return (
    <>
      <h1>NoticeInsertPage</h1>
      <button onClick={handleClick}>INSERT NOTICE</button>
    </>
  );
}

export default NoticeInsertPage;
