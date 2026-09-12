import React from "react";
const ExpenceForm  = ()=>{
    return(
       <div className="bg-white rounded-2xl shadow-md p-6">
                <h2 className="text-2xl font-semibold text-grey-700 mb-4">Add Expense</h2>

       <form action="#" className="grid grid-cols-1 md:grid-cols-2 gap-4">
        {/* title */}
        <div>
            <label htmlFor="" className="block font-medium text-gray-600">Title</label>
            <input type="text" className="border w-full border-grey-300 rounded-lg px-3 py-2 focus:outline-none  focus:border-blue-500"/>
        </div>
        {/* category */}
        <div>
            <label htmlFor="" className="block font-medium text-gray-600">Title</label>
            <select name="" id="" className="border w-full border-grey-300 rounded-lg px-3 py-2 focus:outline-none  focus:border-blue-500">
            <option value="" selected>---Select category---</option>
            <option value="food">Food</option>
            <option value="travel">Travel</option>
            <option value="utilities">Utilities</option>
            <option value="shopping">Shopping</option>
            <option value="entertainment">EntertainMent</option>
            <option value="health">Health</option>
            <option value="education">Education</option>
            <option value="others">Others</option>
            </select>
        </div>
        {/* price */}
         <div>
            <label htmlFor="" className="block font-medium text-gray-600">Price</label>
            <input type="text" className="border w-full border-grey-300 rounded-lg px-3 py-2 focus:outline-none  focus:border-blue-500"/>
        </div>
        {/* date */}
         <div>
            <label htmlFor="" className="block font-medium text-gray-600">Date</label>
            <input type="date" className="border w-full border-grey-300 rounded-lg px-3 py-2 focus:outline-none  focus:border-blue-500"/>
        </div>
        {/* Add button expense button */}
        <div className="mt-5">
            <button className="bg-green-600 hover:bg-green-700 px-6 py-4 rounded-lg font-medium transition-colors duration-200">Add Exense</button>
        </div>

       </form>
       </div> 
    )
}
export default ExpenceForm