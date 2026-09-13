import React from 'react'

const Summary=({expenses})=>{
    const totalExpense = expenses.reduce((accum, exp) => exp.price + accum, 0)


    return(
        <div className="bg-white rounded-2xl shadow-md p-6">
                <h2 className="text-2xl font-semibold text-grey-700 mb-4">Summary</h2>
       


       <div className='grid grid-cols-1 md:grid-cols-2  gap-4'>
{/* Total Expenses */}
       <div className='bg-blue-50 border-blue-200 rounded-xl p-4 flex items-center gap-4'>
        <div className='text-3xl'>💰</div>
        <div>
        <p className='font-medium text-gray-500'>Total expenses</p>
        <p className='text-2xl text-blue-600 font-bold'>{totalExpense.toFixed(2)}</p>
        </div>
        
       </div>

       
       {/* total entries */}
      
        <div className='bg-green-50 border-blue-200 rounded-xl p-4 flex items-center gap-4'>
            <div className='text-3xl'>🗒️</div>
            <div>
        <p className='font-medium text-gray-500'>Total entries</p>
        <p className='text-2xl text-blue-600 font-bold'>{expenses.length}</p>
            </div>
       
       </div>

       </div>

    
                </div>
                
    )
}
export default Summary