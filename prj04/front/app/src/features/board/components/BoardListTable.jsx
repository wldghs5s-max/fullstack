import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;

  th,
  td {
    padding: 12px 16px;
    border-bottom: 1px solid #e0e0e0;
    text-align: left;
  }

  th {
    background-color: #f5f5f5;
    font-weight: bold;
  }
`;

const TableRow = styled.tr`
  cursor: pointer;
  transition: background-color 0.2s ease;

  &:hover {
    background-color: #f0f4ff;
  }
`;

function BoardListTable({ voList }) {
  const navi = useNavigate();
  return (
    <>
      <Table>
        <thead>
          <tr>
            <th>글 번호</th>
            <th>글 제목</th>
            <th>작성자</th>
          </tr>
        </thead>
        <tbody>
          {voList.map((vo) => {
            return (
              <tr
                key={vo.id}
                onClick={() => {
                  navi(`/board/detail/${vo.id}`);
                }}
              >
                <td>{vo.id}</td>
                <td>{vo.title}</td>
                <td>{vo.writerNick}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </>
  );
}

export default BoardListTable;
