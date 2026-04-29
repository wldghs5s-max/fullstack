import React, { useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import BoardDetailMain from '../components/BoardDetailMain';
import useBoardDetail from '../hooks/useBoardDetail';
import Spinner from '../components/Spiner';

function BoardDetailPage() {
  const { id } = useParams();
  const navi = useNavigate();
  const { vo, selectBoardOne } = useBoardDetail();

  useEffect(() => {
    selectBoardOne(id);
  }, [id]);

  if (!vo) return <Spinner />;

  return (
    <BoardDetailMain
      vo={vo}
      onBack={() => {
        navi(`/board/list/1`);
      }}
    />
  );
}

export default BoardDetailPage;
