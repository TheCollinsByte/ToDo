import {AddTask} from "./AddTask";
import {TaskList} from "./TaskList";

function App () {
    return (
       <div>
           <h1 style={{textAlign: "center", color: "blue"}}>TO-Do Web App</h1>
           <AddTask />
           <TaskList />
       </div>
    )
}

export default App