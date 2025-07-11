import React, { useEffect, useState } from 'react';
import API from '../AxiosConfig';
import { useParams, useNavigate } from 'react-router-dom';
import { Container, Form, Button } from 'react-bootstrap';

function UpdateBook() {
  const { isbn } = useParams();
  const [book, setBook] = useState({ title: '', author: '', publicationYear: '' });
  const navigate = useNavigate();

  useEffect(() => {
    API.get(`/books/${isbn}`).then(res => setBook(res.data));
  }, [isbn]);

  const handleSubmit = async e => {
    e.preventDefault();
    await API.put(`/books/${isbn}`, book);
    navigate('/books');
  };

  return (
    <Container className="mt-5 col-md-6">
      <h2>Update Book</h2>
      <Form onSubmit={handleSubmit}>
        <Form.Control placeholder="Title" className="mb-2" required
          value={book.title} onChange={e => setBook({ ...book, title: e.target.value })} />
        <Form.Control placeholder="Author" className="mb-2" required
          value={book.author} onChange={e => setBook({ ...book, author: e.target.value })} />
        <Form.Control placeholder="Year" type="number" className="mb-2" required
          value={book.publicationYear} onChange={e => setBook({ ...book, publicationYear: e.target.value })} />
        <Button type="submit">Update</Button>
      </Form>
    </Container>
  );
}

export default UpdateBook;
