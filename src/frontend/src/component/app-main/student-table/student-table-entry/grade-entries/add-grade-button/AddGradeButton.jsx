import {Link} from "react-router-dom";
import "../GradeEntry.css"
import {Plus} from "react-bootstrap-icons";

const AddGradeButton = ({studentId}) => {
    return <Link to={`/add-grade-form/${studentId}`}>
        <div className={"grade-entry"}>
            <Plus size={24}/>
        </div>
    </Link>
}
export {AddGradeButton}