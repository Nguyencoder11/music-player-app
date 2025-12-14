import React from 'react'
import Navigation from '../../components/common/Navigation/Navigation'
import Footer from '../../components/common/Footer/Footer'
import Sidebar from '../../components/common/Sidebar/Sidebar'

const Home = () => {
  return (
    <div className='container'>
      <Navigation />
      <Sidebar />
      <Footer />
    </div>
  )
}

export default Home
