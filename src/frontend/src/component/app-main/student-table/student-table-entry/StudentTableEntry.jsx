import {Grade} from "./grade/Grade.jsx"
import {AddGradeButton} from "./add-grade-button/AddGradeButton";

const StudentTableEntry = ({student}) =>{
    return <tr>
        <td>
            {student.id}
        </td>
        <td>
            {student.firstName}
        </td>
        <td>
            {student.lastName}
        </td>
        <td>
            {student.grades.map(grade =>
            <Grade
            grade={grade}
            key={grade.id}/>)}
            <AddGradeButton/>
        </td>

    </tr>;
}
export {StudentTableEntry};