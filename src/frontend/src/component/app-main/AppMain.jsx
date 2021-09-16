import {Link} from "react-router-dom";
import {StudentTable} from "./student-table/StudentTable";
import {Button} from "react-bootstrap";
import {Plus} from "react-bootstrap-icons";
import "./AppMain.css"


const AppMain = () => {

    return (
        <div className={"app-main"}>
            <StudentTable/>
            <Link to={"/create-student-form"}><Button variant={"primary"}><Plus size={24}/></Button></Link>
        </div>
    );
}
export {AppMain};