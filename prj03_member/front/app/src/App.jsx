import { useState } from 'react';
import reactLogo from './assets/react.svg';
import viteLogo from './assets/vite.svg';
import heroImg from './assets/hero.png';
import './App.css';
import { Link, Route, Routes } from 'react-router-dom';
import MemberJoinPage from './features/member/pages/MemberJoinPage';
import MemberLoginPage from './features/member/pages/MemberLoginPage';
import Header from './shared/components/header/Header';
import BoardInsertPage from './features/board/pages/BoardInsertPage';
import NoticeInsertPage from './features/notice/pages/NoticeInsertPage';

function App() {
  return (
    <>
      <Header />
      <hr />
      <Routes>
        <Route path="/member/join" element={<MemberJoinPage />} />
        <Route path="/member/login" element={<MemberLoginPage />} />
        <Route path="/board/insert" element={<BoardInsertPage />} />
        <Route path="/notice/insert" element={<NoticeInsertPage />} />
        <Route path="*" element={<h1>home</h1>} />
      </Routes>
    </>
  );
}

export default App;
