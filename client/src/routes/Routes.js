import React from 'react'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import Home from '../pages/Home/Home'
import Login from '../pages/Login/Login'
import Player from '../pages/Player/Player'
import Playlist from '../pages/Playlist/Playlist'
import PrivateRoute from './PrivateRoute'

const AppRoutes = () => {
    return (
        <Router>
            <Routes>
                <Route path='/' element={<Home/>} />
                <Route path='/login' element={<Login/>} />
                <Route path='/player' element={<Player/>} />
                <Route path='/playlist' element={<Playlist/>} />

                {/* Bao ve cac route can dang nhap */}
                <Route path="/player" element={<PrivateRoute><Player /></PrivateRoute>} />
                <Route path="/playlist" element={<PrivateRoute><Playlist /></PrivateRoute>} />
            </Routes>
        </Router>
    )
}

export default AppRoutes;