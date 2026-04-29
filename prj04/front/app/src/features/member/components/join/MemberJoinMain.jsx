import React from 'react';

function MemberJoinMain({ handleChange, handleSubmit, formData }) {
  return (
    <main>
      <h1>MemberJoinPage</h1>
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
        />
        <br />
        <input
          type="password"
          name="password"
          placeholder="비밀번호입력"
          onChange={handleChange}
        />
        <br />
        <input
          type="text"
          name="nick"
          placeholder="닉네임"
          onChange={handleChange}
        />
        <br />
        <input type="submit" value={'회원가입'} />
      </form>
    </main>
  );
}

export default MemberJoinMain;
