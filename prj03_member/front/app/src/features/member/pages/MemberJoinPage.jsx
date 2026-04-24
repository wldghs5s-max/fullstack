import React from 'react';
import useMember from '../hooks/userMember';

function MemberJoinPage() {
  const { handleJoin } = useMember();

  async function handleClick() {
    const vo = {
      username: 'user01',
      password: '1234',
      nick: 'nick01',
      role: 'user',
    };

    const result = await handleJoin(vo);
    alert(result);
  }

  return (
    <>
      <h1>MemberJoinPage</h1>
      <button onClick={handleClick}>JOIN</button>
    </>
  );
}

export default MemberJoinPage;
