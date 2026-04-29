import React, { useState } from 'react';
import useMemberJoin from '../hooks/useMemberJoin';
import MemberJoinMain from '../components/join/MemberJoinMain';

function MemberJoinPage() {
  const { handleChange, handleSubmit, formData } = useMemberJoin();
  return (
    <MemberJoinMain
      formData={formData}
      handleChange={handleChange}
      handleSubmit={handleSubmit}
    />
  );
}

export default MemberJoinPage;
