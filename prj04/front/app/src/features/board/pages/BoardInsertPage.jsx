import useBoardInsert from '../hooks/useBoardInsert';
import AwesomeText from '../components/AwesomeText';
import BoardInsertForm from '../components/BoardInsertForm';

function BoardInsertPage() {
  const { handleChange, handleSubmit, formData } = useBoardInsert();
  return (
    <>
      <AwesomeText>BoardInsertPage</AwesomeText>
      <BoardInsertForm
        handleChange={handleChange}
        handleSubmit={handleSubmit}
        formData={formData}
      />
    </>
  );
}

export default BoardInsertPage;
