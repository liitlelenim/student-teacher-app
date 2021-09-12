import {Table} from "react-bootstrap";
import {StudentTableEntry} from "./student-table-entry/StudentTableEntry";
import {useEffect, useState} from "react";

const StudentTable = () => {

    const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;
    const API_ALL_STUDENTS_ENDPOINT = process.env.REACT_APP_API_ALL_STUDENTS_ENDOPOINT;

    const GET_ALL_STUDENTS_ENDPOINT = API_BASE_URL + API_ALL_STUDENTS_ENDPOINT;
    const [students, setStudents] = useState([]);


    useEffect(() => {
            console.log(GET_ALL_STUDENTS_ENDPOINT);
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
        , [])

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