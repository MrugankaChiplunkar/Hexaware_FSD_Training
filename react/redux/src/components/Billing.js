import React from 'react'
import { useSelector } from 'react-redux'
import '../App.css'

const Billing=()=> {

    const {cartItems} = useSelector((state)=>state.cart);
    const total=cartItems.reduce((sum,item)=> sum+item.price * item.quantity,0);

  return (
    <div className='cont'>
      
      <h2>Bill: </h2>

      {cartItems.length==0 ? 
     
        <p>cart is empty</p>

        :

        <div>

          {cartItems.map((item)=>(

            <div key={item.id}>
              <p>Item: {item.name}   Price: {item.price}   Quantity: {item.quantity}</p>
              
            </div>

          ))}

          <h3>Total Bill: {total}</h3>

        </div>
      }

    </div>
  )
}

export default Billing
