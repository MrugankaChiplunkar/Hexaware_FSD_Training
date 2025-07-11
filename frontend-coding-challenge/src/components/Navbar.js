import React from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';

function Navbar() {
  const token = localStorage.getItem('token');
  const loggedIn = !!token;
  const location = useLocation();
  const navigate = useNavigate();

  const handleNavClick = (e, path) => {
    if (!loggedIn && (location.pathname === '/' || location.pathname === '/register')) {
      e.preventDefault();
      alert('Please login first');
      return;
    }
    navigate(path);
  };

  const handleLogout = () => {
    localStorage.removeItem('token');
    navigate('/');
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-4">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/"><b><i>Book App</i></b></Link>

        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent">
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse justify-content-center" id="navbarContent">
          
          <ul className="navbar-nav d-flex flex-row gap-4">
            <li className="nav-item">
              <Link
                className="nav-link text-white"
                to="/books"
                onClick={(e) => handleNavClick(e, '/books')}
              >
                Books
              </Link>
            </li>
            <li className="nav-item">
              <Link
                className="nav-link text-white"
                to="/add-book"
                onClick={(e) => handleNavClick(e, '/add-book')}
              >
                Add Book
              </Link>
            </li>
          </ul>
        </div>

        {loggedIn && (
          <button
            className="btn btn-outline-light"
            onClick={handleLogout}
          >
            Logout
          </button>
        )}
      </div>
    </nav>
  );
}

export default Navbar;
