import {Table} from "react-bootstrap";
import {StudentTableEntry} from "./student-table-entry/StudentTableEntry";
import {useEffect, useState} from "react";

const StudentTable = () => {

    const GET_ALL_STUDENTS_ENDPOINT = process.env.REACT_APP_API_BASE_URL + process.env.REACT_APP_API_ALL_STUDENTS_ENDOPOINT;
    const [students, setStudents] = useState([]);

    useEffect(() => {
            fetch(GET_ALL_STUDENTS_ENDPOINT, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            )
                .then(r => r.json())
                .then(json =>
                    setStudents(json)
                )
                .catch(err => {
                    console.error(err);
                });
        }
        , [GET_ALL_STUDENTS_ENDPOINT])

    return (
        <Table
            className={"app-main-table"}
            responsive="sm"
            bordered
            striped>
            <thead>
            <tr>
                <th>#</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Grades</th>
            </tr>
            </thead>
            <tbody>
            {students.map(student =>
                <StudentTableEntry student={student} key={student.id}/>
            )}
            </tbody>
        </Table>
    )
}
export {StudentTable}