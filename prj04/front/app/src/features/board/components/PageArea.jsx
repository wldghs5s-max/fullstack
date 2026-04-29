import { useNavigate, useSearchParams } from 'react-router-dom';

function PageArea({ pageVo, onPageChange }) {
  if (!pageVo) return null;
  const navi = useNavigate();
  const arr = [];
  for (let i = pageVo.startPage; i <= pageVo.endPage; ++i) {
    arr.push(i);
  }
  const [data, setData] = useSearchParams();
  const title = data.get('title') ?? '';
  const content = data.get('content') ?? '';
  const nick = data.get('nick') ?? '';

  return (
    <>
      {pageVo.first ? null : (
        <button
          onClick={() => {
            navi(
              `/board/list/${pageVo.currentPage - 1}?title=${title}&content=${content}&nick=${nick}`
            );
          }}
        >
          이전
        </button>
      )}
      {arr.map((num) => (
        <button
          key={num}
          onClick={() => {
            navi(
              `/board/list/${num}?title=${title}&content=${content}&nick=${nick}`
            );
          }}
          style={{
            fontWeight: num === pageVo.currentPage ? 'bold' : 'normal',
          }}
        >
          {num}
        </button>
      ))}
      {pageVo.last ? null : (
        <button
          onClick={() => {
            navi(
              `/board/list/${pageVo.currentPage + 1}?title=${title}&content=${content}&nick=${nick}`
            );
          }}
        >
          다음
        </button>
      )}
    </>
  );
}

export default PageArea;
