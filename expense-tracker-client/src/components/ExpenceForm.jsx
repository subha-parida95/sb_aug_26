import axios from "axios";
import React, { useEffect, useState } from "react";
import expenseService from "../Services/expenseService";

const ExpenceForm  = ({getExpenses, editingExpense, setEditingExpense})=>{
    const [title, setTitle] = useState('')
    const [category, setCategory] = useState('')
    const [price, setPrice] = useState('')
    const [date, setDate] = useState('')
    const [errors, setErrors] = useState({})

    useEffect(() =>{
        if(editingExpense){
            setErrors({})

            setTitle(editingExpense.title)
            setCategory(editingExpense.category)
            setPrice(editingExpense.price)
            setDate(editingExpense.date)

            window.scrollTo({top:0, behavior: 'smooth'})
        }
    }, [editingExpense])

    const handelSubmit = async (e) => {
        e.preventDefault();

        if(!validate()) return

        const expense = {
            id: editingExpense ? editingExpense.id : 0,
            title,
            price,
            category,
            date
        }

        if(editingExpense){
            await updateExpense(expense)
        }else{
            await createExpense(expense)        
        }
    }

    async function updateExpense(expense) {
        try{
            const response = await expenseService.updateExpense(expense);

            if(response.status === 202){
                getExpenses();
                clearForm();
                setEditingExpense(null)
            }else{
                alert("Something went wrong !!!")
            }
        }catch(err){
            console.log("Some Error Occured:-", err)
        }
    }

    async function createExpense(expense){
        try{
            const response = await expenseService.createExpense(expense);

            if(response.status === 201){
                getExpenses();
                clearForm();
            }else{
                alert("Somthing went wrong !!!")
            }
        }catch(err){
            console.log("Some Error occured:-", err)
        }
    }

    const validate = () =>{
        const newErrors = {}

        if(!title){
            newErrors.title = 'Title is Missing.'
        }else if(title.length <= 3){
            newErrors.title = 'Title must have atleast 3 characters.'
        }

        if(!category){
            newErrors.category = 'Please choose a valid category.'
        }

        if(!price || isNaN(price) || price <= 0){
            newErrors.price = 'Price must be grater than 0.'
        }

        if(!date){
            newErrors.date = 'Date is required.'
        }

        setErrors(newErrors)

        return Object.keys(newErrors).length === 0
    }

    const clearForm = () =>{
        setTitle('')
        setCategory('')
        setPrice('')
        setDate('')
    }

    // const handelTitileChange = (e) => {
    //     console.log("handle Title Change")
    //     setTitle(e.target.value)
    // }
    // const handelategoryChange = (e) => {
    //     console.log("handle ategory Change")
    //     setTitle(e.target.value)
    // }

    const handelChange = (e) =>{
        const {name, value} = e.target

        switch (name){
            case 'title':
                setTitle(value)
                setErrors(prev => ({...prev, title: ''}))
                break;
            
            case 'category':
                setCategory(value)           
                setErrors(prev => ({...prev, category: ''}))
                break;

            case 'price':
                setPrice(value)           
                setErrors(prev => ({...prev, price: ''}))
                break;
            
            case 'date':
                setDate(value)           
                setErrors(prev => ({...prev, date: ''}))
                break;
        }
    }

    const handelCancel = (e) => {
        setEditingExpense(null)
        clearForm()
    }

    return(
       <div className="bg-white rounded-2xl shadow-md p-6">
                <h2 className="text-2xl font-semibold text-grey-700 mb-4">{editingExpense ? 'Edit' : 'Add'} Expense</h2>

       <form action={"#"} onSubmit={handelSubmit} className="grid grid-cols-1 md:grid-cols-2 gap-4">
        {/* title */}
        <div>
            <label htmlFor="" className="block font-medium text-gray-600">Title</label>
            <input placeholder="e.g; House Rent" type="text" className="border w-full border-grey-300 rounded-lg px-3 py-2 
                focus:outline-none  focus:border-blue-500" onChange={handelChange} name="title" value={title}/>

            {
                errors.title && (
                    <p className="text-red-500 mt-1 text-sm">{errors.title}</p>
                )
            }
        </div>
        {/* category */}
        <div>
            <label htmlFor="" className="block font-medium text-gray-600">Title</label>
            <select id="" className="border w-full border-grey-300 rounded-lg px-3 py-2 
             focus:outline-none  focus:border-blue-500" onChange={handelChange} name="category" value={category}>
            <option value="">---Select category---</option>
            <option value="food">Food</option>
            <option value="travel">Travel</option>
            <option value="utilities">Utilities</option>
            <option value="shopping">Shopping</option>
            <option value="entertainment">EntertainMent</option>
            <option value="health">Health</option>
            <option value="education">Education</option>
            <option value="others">Others</option>
            </select>

            {
                errors.category && (
                    <p className="text-red-500 mt-1 text-sm">{errors.category}</p>
                )
            }
        </div>
        {/* price */}
         <div>
            <label htmlFor="" className="block font-medium text-gray-600">Price</label>
            <input placeholder="e.g; 5000.99" type="text" className="border w-full border-grey-300 rounded-lg px-3 py-2 
            focus:outline-none  focus:border-blue-500" onChange={handelChange} name="price" value={price}/>

            {
                errors.price && (
                    <p className="text-red-500 mt-1 text-sm">{errors.price}</p>
                )
            }
        </div>
        {/* date */}
         <div>
            <label htmlFor="" className="block font-medium text-gray-600">Date</label>
            <input type="date" className="border w-full border-grey-300 rounded-lg px-3 py-2
             focus:outline-none  focus:border-blue-500" onChange={handelChange} name="date" value={date}/>

            {
                errors.date && (
                    <p className="text-red-500 mt-1 text-sm">{errors.date}</p>
                )
            }
            
        </div>
        {/* Add button expense button */}
        <div className="mt-5">
            {
                editingExpense ? 
                <div className="flex gap-2">
                    <button className="bg-green-600 hover:bg-green-700 px-6 py-4 rounded-lg font-medium transition-colors duration-200">
                    Updatae Expense</button>

                    <button onClick={handelCancel} className="bg-yellow-600 hover:bg-yellow-700 px-6 py-4 rounded-lg font-medium transition-colors duration-200">
                    Cancel</button>
                </div>:
    
                <button className="bg-green-600 hover:bg-green-700 px-6 py-4 rounded-lg font-medium transition-colors duration-200">
                    Add Exense</button>
            }
        </div>

       </form>
       </div> 
    )
}
export default ExpenceForm