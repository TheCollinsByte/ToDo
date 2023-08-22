import React, {useState} from "react";

export const TaskForm = () => {

    const [newTask, setNewTask] = useState({ title: '', description: '' });

    return (
        <div style={{textAlign: "center"}}>
                <div>
                    <input
                        type="text"
                        placeholder="Task Title"
                        value={newTask.title}
                        onChange={(e) => setNewTask({ ...newTask, title: e.target.value })}
                    />
                    <br />
                    <br />
                    <input
                        type="text"
                        placeholder="Task Description"
                        value={newTask.description}
                        onChange={(e) => setNewTask({ ...newTask, description: e.target.value })}
                    />
                </div>
                <br />
                <br />
                <div>
                    <button onClick={async () => {
                        if (newTask.title.trim() !== '' && newTask.description.trim() !== '') {
                            try {
                                const response = await fetch('http://localhost:8080/v1/todo/task', {
                                    method: 'POST',
                                    headers : {
                                        'Content-Type': 'application/json'
                                    },
                                    body: JSON.stringify(newTask),
                                });

                                if (response.ok) {
                                    setNewTask({title: '', description: ''})
                                }
                            } catch (error) {
                                console.error('Error adding TaskForm', error);
                            }
                        } else {
                            alert("Enter a Task");
                        }
                    }}>Add Task</button>
                </div>
        </div>
    )
}