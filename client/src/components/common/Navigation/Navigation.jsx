import React from 'react'
import Login from "../../../pages/Login/Login";

const Navigation = () => {
  return (
    <header className='header'>
      <a href='/' className='thumbnail-link'>
        <img className='thumbnail-logo' src='logo' alt=''/>
      </a>
      <ul>
        {/* Dung map list */}
      </ul>
      <div className='search-area'>
          <input type="text" className='input-search' placeholder='Search...' />

      </div>
      <div className='user-choice'>

      </div>
    </header>
  )
}

export default Navigation
