import React, { useState } from 'react';
import { selectList } from '../api/boardApi';
import { useNavigate, useParams } from 'react-router-dom';

function BoardSearchArea() {
  const navi = useNavigate();
  const [formData, setFormData] = useState({
    title: '',
    content: '',
    nick: '',
  });
  function handleClick() {
    navi(
      `/board/list/1?title=${formData.title}&content=${formData.content}&nick=${formData.nick}`
    );
  }
  function handleChange(e) {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  }
  return (
    <div>
      <span>제목</span>
      <input
        type="text"
        name="title"
        placeholder="제목"
        onChange={handleChange}
        value={formData.title}
      />
      <br />
      <span>내용</span>
      <input
        type="text"
        name="content"
        placeholder="내용"
        value={formData.content}
        onChange={handleChange}
      />
      <br />
      <span>작성자</span>
      <input
        type="text"
        name="nick"
        placeholder="작성자"
        onChange={handleChange}
        value={formData.nick}
      />
      <br />
      <button onClick={handleClick}>검색</button>
    </div>
  );
}

export default BoardSearchArea;
