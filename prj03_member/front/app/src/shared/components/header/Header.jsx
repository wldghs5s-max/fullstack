import React from 'react';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <>
      <header>
        <Link to={'/'}>HOME</Link>
        <br />
        <Link to={'/member/join'}>MEMBER JOIN</Link>
        <br />
        <Link to={'/member/login'}>MEMBER LOGIN</Link>
        <br />
        <Link to={'/board/insert'}>BOARD INSERT</Link>
        <br />
        <Link to={'/notice/insert'}>NOTICE INSERT</Link>
      </header>
    </>
  );
}

export default Header;
