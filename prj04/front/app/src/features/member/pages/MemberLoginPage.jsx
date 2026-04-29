import React from 'react';
import MemberLoginMain from '../components/login/MemberLoginMain';
import useMemberLogin from '../hooks/useMemberLogin';

function MemberLoginPage() {
  const { formData, handleChange, handleSubmit } = useMemberLogin();
  return (
    <>
      <MemberLoginMain
        formData={formData}
        handleChange={handleChange}
        handleSubmit={handleSubmit}
      />
    </>
  );
}

export default MemberLoginPage;
