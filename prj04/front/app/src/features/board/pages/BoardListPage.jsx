import React, { useEffect, useState } from 'react';
import { selectList } from '../api/boardApi';
import { useNavigate, useParams, useSearchParams } from 'react-router-dom';
import useBoardList from '../hooks/useBoardList';
import AwesomeText from '../components/AwesomeText';
import BoardListTable from '../components/BoardListTable';
import PageArea from '../components/PageArea';
import BoardSearchArea from '../components/BoardSearchArea';

function BoardListPage() {
  const { asyncSelectList, voList, pageVo, pno } = useBoardList();
  const [data, setData] = useSearchParams();
  const title = data.get('title');
  const content = data.get('content');
  const nick = data.get('nick');
  const condition = { title, content, nick };

  useEffect(() => {
    asyncSelectList(condition);
  }, [pno, data]);
  return (
    <>
      <AwesomeText>BoardListPage</AwesomeText>
      <BoardListTable voList={voList} />
      <PageArea pageVo={pageVo} />
      <BoardSearchArea />
    </>
  );
}

export default BoardListPage;
