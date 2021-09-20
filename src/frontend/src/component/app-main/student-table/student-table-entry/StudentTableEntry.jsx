import "./StudentTableEntry.css";
import {Grade} from "./grade-entries/grade/Grade.jsx";
import {AddGradeButton} from "./grade-entries/add-grade-button/AddGradeButton";
import {useHistory} from "react-router-dom";

const StudentTableEntry = ({student}) => {
    const history = useHistory();
    const navigateToChosenStudentEditForm=()=>{
        history.push(`/edit-student-form/${student.id}`)
    }
    return <tr className={"student-table-row"}>
            <td valign={"middle"}  onClick={navigateToChosenStudentEditForm}>
                {student.id}
            </td>
            <td valign={"middle"}  onClick={navigateToChosenStudentEditForm}>
                {student.firstName}
            </td>
            <td valign={"middle"} onClick={navigateToChosenStudentEditForm}>
                {student.lastName}
            </td>
            <td className={"student-table-row-grade-area"}>
                {student.grades.map(grade =>
                    <Grade
                        grade={grade}
                        key={grade.id}/>)}
                <AddGradeButton studentId={student.id}/>
            </td>

        </tr>;
}
export {StudentTableEntry};