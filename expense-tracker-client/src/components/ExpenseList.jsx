
import React, { useEffect, useState } from "react";
import axios from "axios";

const ExpenseList = () => {

    const [expenses, setExpenses] = useState([]);

    useEffect(() => {
        getExpenses();
    }, []);
     
    const handelDelete =async (expensesId)=>{
        try{
            const response = await axios.delete('http://localhost:8080/expenses/'+expensesId)
            if(response.status===204){
                getExpenses();
            }else{
                console.log("something went wrong")
            }

        }catch(err){

        };
        
    }

    const getExpenses = async () => {
        try {

            const response = await axios.get("http://localhost:8080/expenses");
            console.log("data is:", response.data);
            setExpenses(response.data);
             } catch (err) {
            console.log("error is:", err);
                 }
    };
     return (
        <div className="bg-white rounded-2xl shadow-md p-6">

            <h2 className="text-2xl font-semibold text-gray-700 mb-4">
                Expense List
            </h2>
            <div className="overflow-x-auto">
            <table className="w-full text-sm text-left">

                <thead>
                    <tr className="bg-gray-100 text-gray-500 uppercase text-xs font-semibold">

                        <th className="px-4 py-3">#</th>
                        <th className="px-4 py-3">Title</th>
                        <th className="px-4 py-3">Category</th>
                        <th className="px-4 py-3">Price</th>
                        <th className="px-4 py-3">Date</th>
                        <th className="px-4 py-3">Action</th>

                    </tr>
                </thead>

                <tbody>
                    {expenses.map((expense, index) => (
                         <tr key={expense.id}className="border-b border-gray-200 hover:bg-gray-50">
                            <td className="px-4 py-3">
                                {index + 1}
                            </td> 
                             <td className="px-4 py-3">
                                {expense.title}
                            </td>
                             <td className="px-4 py-3">
                                {expense.category}
                            </td>
                            <td className="px-4 py-3">
                                {expense.price}
                            </td>

                            <td className="px-4 py-3">
                                {expense.date}
                            </td>

                            <td className="px-4 py-3">

                                <div className="flex gap-2">

                                    <button
                                        className="bg-yellow-400 hover:bg-yellow-500 text-white px-3 py-1.5 rounded-lg">
                                    
                                        Edit
                                    </button>

                                    <button
                                        className="bg-red-500 hover:bg-red-600 text-white px-3 py-1.5 rounded-lg"
                                    onClick={()=>handelDelete(expense.id)}>
                                        Delete
                                    </button>

                                </div>

                            </td>

                        </tr>

                    ))}

                </tbody>

            </table>
</div>
        </div>
    );
};

export default ExpenseList;


   
                

            

       

   

                            
                        

                           

                           

                           


                    

                       
                            