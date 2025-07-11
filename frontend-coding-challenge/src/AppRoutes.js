import React from 'react'
import { Route, Routes} from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import BookList from './components/BookList';
import AddBook from './components/AddBook';
import UpdateBook from './components/UpdateBook';



const AppRoutes=()=> {
  return (


    <Routes>
        <Route path='/' element={<Login />} />
        <Route path='/register' element={<Register />} />
        <Route path='/books' element={<BookList />} />
        <Route path='/add-book' element={<AddBook />} />
        <Route path='/update-book/:isbn' element={<UpdateBook />} />
        
        

    </Routes>



  )
}

export default AppRoutes
