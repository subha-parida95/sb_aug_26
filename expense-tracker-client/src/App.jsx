import React, { useEffect, useState } from 'react'
import Header from './components/Header'
import ExpenceForm from './components/ExpenceForm'
import Summary from './components/Summary';
import Footer from './components/Footer';


import ExpenseList from './components/ExpenseList'
import axios from 'axios';
import expenseService from './Services/expenseService';

function App() {
  const [expenses, setExpenses] = useState([]);
  const [editingExpense, setEditingExpense] = useState(null)

  const getExpenses = async () => {
    try {

        const response = await expenseService.getExpense();

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
      <ExpenceForm
       getExpenses={getExpenses}
       editingExpense={editingExpense}
       setEditingExpense = {setEditingExpense}
      />

       <Summary expenses = {expenses}/>

       <ExpenseList
          expenses = {expenses}
          getExpenses = {getExpenses}
          setEditingExpense = {setEditingExpense}
        />
      
    </main>
    <Footer/>
     </div>
  )
}

export default App