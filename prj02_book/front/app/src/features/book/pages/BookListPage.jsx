import React, { useEffect } from 'react';
import useBook from '../hooks/useBook';
import { useNavigate } from 'react-router-dom';

function BookListPage() {
  const { voList, fetchVoList, loading, error } = useBook();
  const navigate = useNavigate();
  useEffect(() => {
    fetchVoList();
  }, []);
  if (loading) {
    return <h1>loading~~</h1>;
  }
  if (error) {
    return <h1>{error}</h1>;
  }
  return (
    <>
      <h1>BookListPage</h1>
      <table>
        <thead>
          <tr>
            <th>도서 번호</th>
            <th>도서 제목</th>
          </tr>
        </thead>
        <tbody>
          {voList.map((vo) => {
            return (
              <tr
                key={vo.id}
                onClick={() => {
                  navigate(`/book/detail/${vo.id}`);
                }}
              >
                <td>{vo.id}</td>
                <td>{vo.title}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </>
  );
}

export default BookListPage;
