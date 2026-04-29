import React from 'react';

function MemberLoginMain({ formData, handleSubmit, handleChange }) {
  return (
    <main>
      <h1>MemberLoginPage</h1>

      <form
        onSubmit={async (evt) => {
          const statusCode = await handleSubmit(evt);
          alert(statusCode);
        }}
      >
        <input
          type="text"
          name="username"
          placeholder="아이디입력"
          onChange={handleChange}
          value={formData.username}
        />
        <br />
        <input
          type="password"
          name="password"
          placeholder="비밀번호입력"
          onChange={handleChange}
          value={formData.password}
        />
        <br />

        <br />
        <input type="submit" value={`로그인`} />
      </form>
    </main>
  );
}

export default MemberLoginMain;
