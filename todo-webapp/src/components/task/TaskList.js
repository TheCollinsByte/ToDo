export const TaskList = ({ tasks, toggleTask, deleteTask }) => {

    return (
        <div>
            <ul>
                {tasks.map((task) => (
                    <li key={task.title}>
                        <input
                            type="checkbox"
                            checked={false}
                            onChange={() => toggleTask}
                        />
                        <span>
                          {task.title} - {task.description}
                        </span>
                        <button onClick={() => deleteTask}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    )
}