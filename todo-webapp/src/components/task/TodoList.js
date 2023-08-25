import {useEffect, useState} from "react";
import {TaskList} from "./TaskList";
import {TaskForm} from "./TaskForm";

export const TodoList = () => {
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        fetchTasks().then((data) => {
            if (!data) {
                setTasks([]);
            } else {
                setTasks(data);
            }
        });
    }, [tasks]);

    const fetchTasks = async () => {
        try {
            const response = await fetch('http://localhost:8080/v1/todo/tasks');
            return await response.json();
        } catch (error) {
            console.error('Error Fetching tasks: ', error);
        }
    };

    const toggleTask = async (taskId) => {
        try {
            const taskToUpdate = tasks.find(task => task.id === taskId);
            const response = await fetch(`http://localhost:8080/v1/todo/task/${taskId}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ ...taskToUpdate, completed: !taskToUpdate.completed }),
            });

            if (response.ok) {
                await fetchTasks();
            }
        } catch (error) {
            console.error('Error toggling task:', error);
        }
    };

    const deleteTask = async (taskId) => {
        try {
            const response = await fetch(`http://localhost:8080/v1/todo/task/${taskId}`, {
                method: 'DELETE',
            });

            if (response.ok) {
                await fetchTasks();
            }
        } catch (error) {
            console.error('Error deleting task:', error);
        }
    };


    return (
        <div>
            <TaskForm />
            <TaskList tasks={tasks} toggleTask={toggleTask} deleteTask={deleteTask} />
        </div>
    )
}