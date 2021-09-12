import {Table} from "react-bootstrap";
import {StudentTableEntry} from "./student-table-entry/StudentTableEntry";

const StudentTable = () => {
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
            </tbody>
        </Table>
    )
}
export {StudentTable}