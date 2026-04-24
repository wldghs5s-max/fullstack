import React from 'react';
import useMember from '../hooks/userMember';

function MemberLoginPage() {
  const { handleLogin } = useMember();

  async function handleClick() {
    const vo = {
      username: 'user01',
      password: '1234',
    };

    const result = await handleLogin(vo);
    alert(result);
  }

  return (
    <>
      <h1>MemberLoginPage</h1>
      <button onClick={handleClick}>LOGIN</button>
    </>
  );
}

export default MemberLoginPage;
