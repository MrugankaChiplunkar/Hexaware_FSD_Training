import React, { useState } from 'react';
import API from '../AxiosConfig';
import { useNavigate } from 'react-router-dom';
import { Container, Form, Button } from 'react-bootstrap';

function AddBook() {
  const [book, setBook] = useState({ isbn: '', title: '', author: '', publicationYear: '' });
  const navigate = useNavigate();

  const handleSubmit = async e => {
    e.preventDefault();
    await API.post('/books/add', book);
    navigate('/books');
  };

  return (
    <Container className="mt-5 col-md-6">
      <h2>Add Book</h2>
      <Form onSubmit={handleSubmit}>
        <Form.Control placeholder="ISBN" className="mb-2" required
          value={book.isbn} onChange={e => setBook({ ...book, isbn: e.target.value })} />
        <Form.Control placeholder="Title" className="mb-2" required
          value={book.title} onChange={e => setBook({ ...book, title: e.target.value })} />
        <Form.Control placeholder="Author" className="mb-2" required
          value={book.author} onChange={e => setBook({ ...book, author: e.target.value })} />
        <Form.Control placeholder="Year" type="number" className="mb-2" required
          value={book.publicationYear} onChange={e => setBook({ ...book, publicationYear: e.target.value })} />
        <Button type="submit">Add</Button>
      </Form>
    </Container>
  );
}

export default AddBook;
