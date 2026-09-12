import React, { useEffect, useState } from 'react'
import Header from './components/Header'
import ExpenceForm from './components/ExpenceForm'
import Summary from './components/Summary';
import Footer from './components/Footer';


import ExpenseList from './components/ExpenseList'
import axios from 'axios';

function App() {
  
  const [expenses, setExpenses] = useState([]);
  const getExpenses = async () => {
    try {

        const response = await axios.get("http://localhost:8080/expenses");

        console.log("data is:", response.data);
        setExpenses(response.data);
          } catch (err) {
            console.log("error is:", err);
          }
    };

    
    useEffect(() => {
      getExpenses();
    }, []);
     

  return (
    <div className="min-h-screen bg-gray-100">
      <Header />
   
    <main className="max-w-4xl mx-auto py-4 mt-4">
      <ExpenceForm/>
       <Summary expenses = {expenses}/>
       <ExpenseList expenses = {expenses}/>
      
    </main>
    <Footer/>
     </div>
  )
}

export default App