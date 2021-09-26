import "../AppForm.css";
import {useHistory, useParams} from "react-router-dom";
import {Button, Col, Form, FormLabel} from "react-bootstrap";
import {useEffect, useRef, useState} from "react";

const EditStudentForm = () => {


    let {studentId} = useParams();
    const history = useHistory();

    const editionForm = useRef();

    const [studentData, setStudentData] = useState(undefined);
    const [firstNameInput, setFirstNameInput] = useState("");
    const [lastNameInput, setLastNameInput] = useState("");

    const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;
    const API_STUDENT_URL = process.env.REACT_APP_API_STUDENTS;

    const STUDENTS_ENDPOINT = API_BASE_URL + API_STUDENT_URL
        + `${studentId}/`;


    useEffect(() => {
        const requestOptions = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        };
        fetch(STUDENTS_ENDPOINT, requestOptions)
            .then((res) => {
                if (res.ok) {
                    return res.json();
                }
            }).then((json) => {
            setStudentData(json);
        })
    }, [STUDENTS_ENDPOINT]);

    useEffect(() => {
        if (studentData !== undefined) {
            setFirstNameInput(studentData.firstName);
            setLastNameInput(studentData.lastName);
        }
    }, [studentData])

    const editStudent = (event) => {
        if (editionForm.current.reportValidity()) {
            event.preventDefault();
            const patchBody = {};
            let edited = false;
            if (firstNameInput !== studentData.firstName) {
                edited = true;
                patchBody.firstName = firstNameInput;
            }
            if (lastNameInput !== studentData.lastName) {
                edited = true;
                patchBody.lastName = lastNameInput;
            }
            if (edited) {
                const requestOptions = {
                    method: 'PATCH',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({...patchBody})
                }
                fetch(STUDENTS_ENDPOINT, requestOptions).then(
                    (res) => {
                        if (res.ok) {
                            history.push("/")
                        }
                    }
                )
            }

        }

    }
    const deleteStudent = () => {
        const requestOptions = {
            method: 'DELETE',
        }
        fetch(STUDENTS_ENDPOINT, requestOptions).then(
            (res) => {
                if (res.ok) {
                    history.push("/")
                }
            }
        )
    }
    if (studentData !== undefined) {
        return (
            <div className={"form-container"}>
                <Col>
                    <Form className={"mb-3"} ref={editionForm}>
                        <Form.Group>
                            <FormLabel>First name</FormLabel>
                            <Form.Control minLength={2} maxLength={35} required type={"text"}
                                          placeholder={"Student's first name"}
                                          value={firstNameInput}
                                          onChange={(event => {
                                              setFirstNameInput(event.target.value);
                                          })}
                            />
                        </Form.Group>
                        <Form.Group className="mb-3">
                            <FormLabel>Last name</FormLabel>
                            <Form.Control minLength={2} maxLength={35} required type={"text"}
                                          placeholder={"Student's last name"}
                                          value={lastNameInput}
                                          onChange={(event => {
                                              setLastNameInput(event.target.value);
                                          })}/>


                        </Form.Group>
                        <Button variant={"primary"} type={"submit"} onClick={editStudent}>Edit</Button>
                        <Button className={"secondary-form-button"} variant={"danger"}
                                onClick={deleteStudent}>Delete</Button>

                    </Form>

                </Col>
            </div>
        );
    } else {
        return <></>
    }
}
export {EditStudentForm}