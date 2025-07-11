import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

function Register() {
  const navigate = useNavigate();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleRegister = async (e) => {
    e.preventDefault();

    try {
      await axios.post("http://localhost:9002/api/auth/register", { username, password });
      alert("Registration successful!");
      navigate("/");
    } catch (error) {
      console.error(error);
      alert("Registration failed. Try again");
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100 bg-light">
      <div className="card p-4 shadow" style={{ width: "400px" }}>
        <h3 className="mb-3 text-center">Register</h3>

        <form onSubmit={handleRegister}>
          
          <label>Username</label>
          <input
            type="text"
            className="form-control mb-3"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />

          
          <label>Password</label>
          <input
            type="password"
            className="form-control mb-3"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          
          <button type="submit" className="btn btn-primary w-100">Register</button>
        </form>

        <p className="mt-3 text-center">
          Already registered? <Link to="/">Login here</Link>
        </p>
      </div>
    </div>
  );
}

export default Register;
