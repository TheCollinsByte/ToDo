import {AddTask} from "./AddTask";
import {TaskList} from "./TaskList";

function App () {
    return (
       <div>
           <h1>TO-Do Web App</h1>
           <AddTask />
           <TaskList />
       </div>
    )
}

export default App