import "./AppMain.css"
import {StudentTable} from "./student-table/StudentTable";

const AppMain = () => {

    return (
        <div className={"app-main"}>
            <StudentTable/>
        </div>
    );
}
export {AppMain};