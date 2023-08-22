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
            <ul>
                {tasks.map((task) => (
                    <li key={task.id}>
                        <input
                            type="checkbox"
                            checked={false}
                            onChange={() => console.log("Input Checkbox")}
                        />
                        <span>
                          {task.title} - {task.description}
                        </span>
                        <button onClick={() => console.log("Delete Button")}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    )
}