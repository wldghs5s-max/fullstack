import React from "react";
import styled from "styled-components";

const StyledButton = styled.button`
  background-color: skyblue;
  border: 2px solid black;
  border-radius: 3px;
`;

function AwesomeBtn({ children }) {
  return <StyledButton>{children}</StyledButton>;
}

export default AwesomeBtn;
