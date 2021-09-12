import {Grade} from "./grade/Grade.jsx"

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
        </td>

    </tr>;
}
export {StudentTableEntry};