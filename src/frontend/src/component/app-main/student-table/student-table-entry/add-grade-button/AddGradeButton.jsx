import {Link} from "react-router-dom";
import {Button} from "react-bootstrap";
import {Plus} from "react-bootstrap-icons";

const AddGradeButton = ({studentId}) => {
    return <Link to={`/add-grade-form/${studentId}`}>
        <Button size={"sm"} variant={"primary"}>
            <Plus size={24}/>
        </Button>
    </Link>
}
export {AddGradeButton}