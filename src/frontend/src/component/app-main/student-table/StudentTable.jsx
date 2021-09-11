import {Table} from "react-bootstrap";

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
            <tr>

            </tr>
            </tbody>
        </Table>
    )
}
export {StudentTable}