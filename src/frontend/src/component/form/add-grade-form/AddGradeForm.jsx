import "../AppForm.css";
import {useHistory, useParams} from "react-router-dom";
import {Button, Col, Form, FormLabel} from "react-bootstrap";
import {useRef, useState} from "react";

const AddGradeForm = () => {

    let sentRequest = false;

    let {studentId} = useParams();
    const history = useHistory();

    const creationForm = useRef();


    const [valueInput, setValueInput] = useState(0);
    const [weightInput, setWeightInput] = useState(0);
    const [descriptionInput, setDescriptionInput] = useState("");

    const POST_GRADE_ENDPOINT = process.env.REACT_APP_API_BASE_URL + process.env.REACT_APP_API_STUDENTS
        + `${studentId}/` + process.env.REACT_APP_API_GRADES;

    const addGrade = (event) => {
        if (creationForm.current.reportValidity() && !sentRequest) {
            sentRequest=true;
            event.preventDefault();
            const requestOptions = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    value: valueInput,
                    weight: weightInput,
                    description: descriptionInput
                })

            }
            fetch(POST_GRADE_ENDPOINT, requestOptions).then(
                (res) => {
                    if (res.ok) {
                        history.push("/")
                    }
                }
            ).catch(()=>{
                sentRequest=false;
            })
        }

    }

    return (
        <div className={"form-container"}>
            <Col>
                <Form className={"mb-3"} ref={creationForm}>
                    <Form.Group className="mb-3 form-number-field">
                        <FormLabel>Value</FormLabel>
                        <Form.Control min={0} max={100} required type={"number"}
                                      placeholder={0}
                                      value={valueInput}
                                      onChange={(event => {
                                          setValueInput(parseInt(event.target.value));
                                      })}
                        />
                    </Form.Group>
                    <Form.Group className="mb-3 form-number-field">
                        <FormLabel>Weight</FormLabel>
                        <Form.Control min={0} max={100} required type={"number"}
                                      placeholder={0}
                                      value={weightInput}
                                      onChange={(event => {
                                          setWeightInput(parseInt(event.target.value));
                                      })}/>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <FormLabel>Description</FormLabel>
                        <Form.Control className={"non-resizable"} as="textarea" maxLength={255}
                                      type={"text"}
                                      placeholder={"Grade's description"}
                                      value={descriptionInput}
                                      onChange={(event => {
                                          setDescriptionInput(event.target.value);
                                      })}/>
                    </Form.Group>
                    <Button variant={"primary"} type={"submit"} onClick={addGrade}>Add</Button>
                </Form>
            </Col>
        </div>
    );
}
export {AddGradeForm}