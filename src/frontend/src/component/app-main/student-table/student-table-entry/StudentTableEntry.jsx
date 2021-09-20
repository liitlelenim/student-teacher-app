import "./StudentTableEntry.css";
import {Grade} from "./grade-entries/grade/Grade.jsx";
import {AddGradeButton} from "./grade-entries/add-grade-button/AddGradeButton";
import {useHistory} from "react-router-dom";

const StudentTableEntry = ({student}) => {
    const history = useHistory();
    const navigateToChosenStudentEditForm=()=>{
        history.push(`/edit-student-form/${student.id}`)
    }
    return <tr className={"student-table-row"} onClick={navigateToChosenStudentEditForm}>
            <td valign={"middle"}>
                {student.id}
            </td>
            <td valign={"middle"}>
                {student.firstName}
            </td>
            <td valign={"middle"}>
                {student.lastName}
            </td>
            <td>
                {student.grades.map(grade =>
                    <Grade
                        grade={grade}
                        key={grade.id}/>)}
                <AddGradeButton studentId={student.id}/>
            </td>

        </tr>;
}
export {StudentTableEntry};