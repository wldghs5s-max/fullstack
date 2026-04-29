import styled from 'styled-components';

function BoardDetailMain({ vo, onBack }) {
  return (
    <Container>
      <Header>
        <Title>{vo.title}</Title>
        <Meta>
          <span>작성자 : {vo.writerNick}</span>
          <span>작성일 : {formatDate(vo.createdAt)}</span>
          <span>수정일 : {formatDate(vo.modifiedAt)}</span>
        </Meta>
      </Header>

      <Divider />

      <Content>{vo.content}</Content>

      <ButtonGroup>
        <Button onClick={onBack}>목록</Button>
      </ButtonGroup>
    </Container>
  );
}

function formatDate(dateTime) {
  if (!dateTime) return '-';
  return new Date(dateTime).toLocaleDateString('ko-KR');
}

const Container = styled.div`
  max-width: 800px;
  margin: 40px auto;
  padding: 0 20px;
`;

const Header = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;
`;

const Title = styled.h2`
  font-size: 24px;
  font-weight: bold;
  margin: 0;
`;

const Meta = styled.div`
  display: flex;
  gap: 20px;
  color: #888;
  font-size: 14px;
`;

const Divider = styled.hr`
  border: none;
  border-top: 1px solid #e0e0e0;
  margin: 20px 0;
`;

const Content = styled.div`
  min-height: 300px;
  line-height: 1.8;
  font-size: 16px;
  white-space: pre-wrap; /* 줄바꿈 유지 */
`;

const ButtonGroup = styled.div`
  display: flex;
  justify-content: flex-end;
  gap: 8px;
  margin-top: 40px;
`;

const Button = styled.button`
  padding: 8px 20px;
  border: 1px solid #ccc;
  border-radius: 4px;
  cursor: pointer;
  background-color: #fff;
  transition: background-color 0.2s ease;

  &:hover {
    background-color: #f5f5f5;
  }
`;

export default BoardDetailMain;
