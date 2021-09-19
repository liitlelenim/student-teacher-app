import {Grade} from "./grade-entries/grade/Grade.jsx";
import {AddGradeButton} from "./grade-entries/add-grade-button/AddGradeButton";
const StudentTableEntry = ({student}) =>{
    return <tr>
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