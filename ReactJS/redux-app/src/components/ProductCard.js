import React from 'react'
import '../App.css'


const ProductCard=({name, price, image, onAdd})=> {
  return (
    <div className='cont'>

        <img src={image} alt={name} width="100%" />
        <h4>{name}</h4>
        <h4>{price}</h4>

        <button onClick={onAdd}>Add To Cart</button>
      
    </div>
  )
}

export default ProductCard
