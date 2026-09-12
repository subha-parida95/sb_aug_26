import React from 'react'
import Header from './components/Header'
import ExpenceForm from './components/ExpenceForm'
import Summary from './components/Summary';
import Footer from './components/Footer';


import ExpenseList from './components/ExpenseList'

function App() {
  return (
    <div className="min-h-screen bg-gray-100">
      <Header />
   
    <main className="max-w-4xl mx-auto py-4 mt-4">
      <ExpenceForm/>
       <Summary />
       <ExpenseList />
      
    </main>
    <Footer/>
     </div>
  )
}

export default App