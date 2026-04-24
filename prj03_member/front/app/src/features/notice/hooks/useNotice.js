import { noticeInsert } from '../api/noticeApi';

function userNotice() {
  async function handleInsertNotice() {
    const resp = await noticeInsert();
    return resp.status;
  }

  return { handleInsertNotice };
}

export default userNotice;
