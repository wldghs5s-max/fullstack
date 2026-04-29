import React from 'react';
import styled from 'styled-components';

const StyledH1 = styled.h1`
  background-color: black;
  color: white;
`;

function AwesomeText({ children }) {
  return (
    <>
      <StyledH1>{children}</StyledH1>
    </>
  );
}

export default AwesomeText;
