import React from 'react';

function BoardInsertForm({ handleChange, handleSubmit, formData }) {
  return (
    <>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="title"
          placeholder="제목을 입력하세요"
          value={formData.title}
          onChange={handleChange}
        />
        <br />
        <textarea
          name="content"
          placeholder="내용을 입력하세요"
          value={formData.content}
          onChange={handleChange}
        ></textarea>
        <br />
        <input type="submit" value={'작성하기'} />
      </form>
    </>
  );
}

export default BoardInsertForm;
