import React, {useEffect, useState} from "react";
import {fetchTasks} from "./TaskList";

export const Task = () => {

    const [newTask, setNewTask] = useState({ id: 0, title: '', description: '' });


    return (
        <div>
            <div>
                <div>
                    <input
                        type="number"
                        placeholder="Id"
                        value={newTask.id}
                        onChange={(e) => setNewTask({ ...newTask, id: parseInt(e.target.value) })}
                    />
                    <input
                        type="text"
                        placeholder="Title"
                        value={newTask.title}
                        onChange={(e) => setNewTask({ ...newTask, title: e.target.value })}
                    />
                    <input
                        type="text"
                        placeholder="Title"
                        value={newTask.description}
                        onChange={(e) => setNewTask({ ...newTask, description: e.target.value })}
                    />
                    <button onClick={async () => {
                        if (newTask.title.trim() !== '' && newTask.description.trim() !== '' && newTask.id !== (0.0 && 0)) {
                            try {
                                const response = await fetch('http://localhost:8080/v1/todo/task', {
                                    method: 'POST',
                                    headers : {
                                        'Content-Type': 'application/json'
                                    },
                                    body: JSON.stringify(newTask),
                                });

                                if (response.ok) {
                                    await fetchTasks();
                                    setNewTask({id: 0, title: '', description: ''})
                                }
                            } catch (error) {
                                console.error('Error adding Task', error);
                            }
                        }
                    }}>Add Task</button>
                </div>
            </div>
        </div>
    )
}