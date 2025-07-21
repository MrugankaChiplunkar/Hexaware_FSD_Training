import React from 'react'
import { useDispatch } from 'react-redux';
import ProductCard from './ProductCard';
import { addToCart } from '../redux/cartSlice';
import '../App.css'


const watches = [
  {
    id: 1,
    name: "Classic Leather Watch",
    price: 1500,
    image: "https://source.unsplash.com/200x200/?leather-watch"
  },
  {
    id: 2,
    name: "Digital Sport Watch",
    price: 900,
    image: "https://source.unsplash.com/200x200/?digital-watch"
  },
  {
    id: 3,
    name: "Luxury Gold Watch",
    price: 3500,
    image: "https://source.unsplash.com/200x200/?gold-watch"
  },
  {
    id: 4,
    name: "Smartwatch",
    price: 2500,
    image: "https://source.unsplash.com/200x200/?smartwatch"
  },
  {
    id: 5,
    name: "Analog Wrist Watch",
    price: 1200,
    image: "https://source.unsplash.com/200x200/?analog-watch"
  },
  {
    id: 6,
    name: "Stainless Steel Watch",
    price: 1800,
    image: "https://source.unsplash.com/200x200/?steel-watch"
  },
  {
    id: 7,
    name: "Chronograph Watch",
    price: 2200,
    image: "https://source.unsplash.com/200x200/?chronograph-watch"
  },
  {
    id: 8,
    name: "Minimalist Watch",
    price: 1000,
    image: "https://source.unsplash.com/200x200/?minimalist-watch"
  },
  {
    id: 9,
    name: "Digital LED Watch",
    price: 800,
    image: "https://source.unsplash.com/200x200/?led-watch"
  },
  {
    id: 10,
    name: "Military Tactical Watch",
    price: 2000,
    image: "https://source.unsplash.com/200x200/?military-watch"
  }
];





const WatchList=()=> {


    const dispatch = useDispatch();


  return (
    <div className='cont'>

        <h2>Watch List: </h2>

        {watches.map(watches=>(<ProductCard
        
        key= {watches.id}  name={watches.name}  price={watches.price} image={watches.image}


        onAdd={()=>dispatch(addToCart(watches))}
        
        
        
        />))}
      
    </div>
  )
}

export default WatchList
