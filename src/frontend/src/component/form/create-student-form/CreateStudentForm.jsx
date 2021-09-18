import "../AppForm.css";
import {Button, Col, Form, FormLabel} from "react-bootstrap";
import {useRef, useState} from "react";
import {useHistory} from 'react-router-dom'
const CreateStudentForm = () => {

    const POST_STUDENT_ENDPOINT = process.env.REACT_APP_API_BASE_URL + process.env.REACT_APP_API_CREATE_STUDENT;

    const history = useHistory();

    const [firstNameInput, setFirstNameInput] = useState("");
    const [lastNameInput, setLastNameInput] = useState("");

    const creationForm = useRef();

    const createStudent = (event) => {
        if(creationForm.current.reportValidity()) {
            event.preventDefault();
            const requestOptions = {
                method:'POST',
                headers:{
                    'Content-Type': 'application/json'
                },
                body:JSON.stringify({
                    firstName:firstNameInput,
                    lastName:lastNameInput
                })
            }
            fetch(POST_STUDENT_ENDPOINT,requestOptions)
                .then(()=>{
                    history.push("/");
                })

        }
    }

    return (
        <div className={"form-container"}>
            <Col>
                <Form className={"mb-3"} ref={creationForm}>
                    <Form.Group className="mb-3">
                        <FormLabel>First name</FormLabel>
                        <Form.Control minLength={2} maxLength={100} required type={"text"}
                                      placeholder={"Student's first name"}
                                      onChange={(event => {
                                          setFirstNameInput(event.target.value);
                                      })}
                        />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <FormLabel>Last name</FormLabel>
                        <Form.Control minLength={2} maxLength={100} required type={"text"}
                                      placeholder={"Student's last name"}
                                      onChange={(event => {
                                          setLastNameInput(event.target.value);
                                      })}/>


                    </Form.Group>
                    <Button variant={"primary"} type={"submit"} onClick={createStudent} >Create</Button>
                </Form>
            </Col>
        </div>
    );
}
export {CreateStudentForm};