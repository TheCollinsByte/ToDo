import React, {useState} from "react";
export const TaskList = () => {

    const [tasks, setTasks] = useState([]);

    const fetchTasks = async () => {
        try {
            const response = await fetch('http://localhost:8080/v1/todo/tasks');
            const data = await response.json();
            setTasks(data);
        } catch (error) {
            console.error('Error fetching tasks:', error);
        }
    };


    return (
        <div>
            <h1>Tasks</h1>
            {tasks.map((e) => {
                console.log(e)
            })}
        </div>
    )
}