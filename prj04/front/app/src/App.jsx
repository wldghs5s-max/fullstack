import { useState } from 'react';
import reactLogo from './assets/react.svg';
import viteLogo from './assets/vite.svg';
import heroImg from './assets/hero.png';
import './App.css';
import { Link, Route, Routes } from 'react-router-dom';
import MemberJoinPage from './features/member/pages/MemberJoinPage';
import MemberLoginPage from './features/member/pages/MemberLoginPage';
import BoardListPage from './features/board/pages/BoardListPage';
import BoardInsertPage from './features/board/pages/BoardInsertPage';
import BoardDetailPage from './features/board/pages/BoardDetailPage';

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <header>
        <h1>Welcome</h1>
      </header>
      <nav>
        <Link to={`/member/join`}>회원가입</Link>
        <Link to={`/member/login`}>로그인</Link>
        <Link to={`/board/insert`}>게시글 작성</Link>
        <Link to={`/board/list/1`}>게시글 목록</Link>
      </nav>
      <Routes>
        <Route path="/member/login" element={<MemberLoginPage />} />
        <Route path="/member/join" element={<MemberJoinPage />} />
        <Route path="/board/insert" element={<BoardInsertPage />} />
        <Route path="/board/list/:pno" element={<BoardListPage />} />
        <Route path="/board/detail/:id" element={<BoardDetailPage />} />

        <Route path="*" element={<h1>잘못된 경로입니다.</h1>} />
      </Routes>
    </>
  );
}

export default App;
