import React, { useEffect, useState } from 'react';
import API from '../AxiosConfig';
import { Link } from 'react-router-dom';
import { Container, Table, Button } from 'react-bootstrap';



const BookList=()=> {

const[books, setBooks] = useState([]);

const fetchBooks = async () => {

  const res = await API.get('/books');

  setBooks(res.data);

}

const handleDelete = async isbn =>{

  await API.delete(`/books/${isbn}`);
  fetchBooks();
}

useEffect(()=>{

  fetchBooks()

},[])

  return (
  
    <Container className='mt-5'>
      <h2>All Books:</h2>
       <Link to='/add-book' >

       <Button className='mb-3'>Add Book</Button>

       </Link>

       <Table striped bordered hover>
         <thead>

            <tr>
              <th>ISBN</th>
              <th>Title</th>
              <th>Author</th>
              <th>Year</th>
              <th>Actions</th>
            </tr>

         </thead>

         <tbody>
          {books.map(book =>(

          <tr key={book.isbn}>
            <td>{book.isbn}</td>
            <td>{book.title}</td>
            <td>{book.author}</td>
            <td>{book.publicationYear}</td>

            <td>
          <Link to={`/update-book/${book.isbn}`}>
          
             <Button variant='warning' size='sm' className='me-2'>Update</Button>

          </Link>

          <Button variant='danger' size='sm' onClick={()=> handleDelete(book.isbn)}>Delete</Button>


           </td>
          </tr>

          ))}
         </tbody>

       </Table>





    </Container>


  )
}

export default BookList
