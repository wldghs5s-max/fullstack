import React from 'react';

function Spinner({ size = 40, color = '#3498db' }) {
  const style = {
    width: size,
    height: size,
    border: `${size * 0.1}px solid #f3f3f3`,
    borderTop: `${size * 0.1}px solid ${color}`,
    borderRadius: '50%',
    animation: 'spin 1s linear infinite',
  };

  return (
    <>
      <div style={style}></div>

      <style>
        {`
          @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
          }
        `}
      </style>
    </>
  );
}

export default Spinner;
