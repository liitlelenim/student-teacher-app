import "../AppForm.css";
import {Button, Col, Form, FormLabel} from "react-bootstrap";
import {useRef, useState} from "react";
import {useHistory} from 'react-router-dom'

const CreateStudentForm = () => {


    let sentRequest = false;

    const POST_STUDENT_ENDPOINT = process.env.REACT_APP_API_BASE_URL + process.env.REACT_APP_API_STUDENTS;
    const history = useHistory();

    const [firstNameInput, setFirstNameInput] = useState("");
    const [lastNameInput, setLastNameInput] = useState("");

    const creationForm = useRef();

    const createStudent = (event) => {
        if (creationForm.current.reportValidity() && !sentRequest) {
            sentRequest=true;
            event.preventDefault();
            const requestOptions = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    firstName: firstNameInput,
                    lastName: lastNameInput
                })
            }
            fetch(POST_STUDENT_ENDPOINT, requestOptions)
                .then((res) => {
                    if (res.ok) {
                        history.push("/");
                    }
                })
                .catch(()=>{
                    sentRequest=false;
                })

        }
    }

    return (
        <div className={"form-container"}>
            <Col>
                <Form className={"mb-3"} ref={creationForm}>
                    <Form.Group className="mb-3">
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
                    <Button variant={"primary"} type={"submit"} onClick={createStudent}>Create</Button>
                </Form>
            </Col>
        </div>
    );
}
export {CreateStudentForm};