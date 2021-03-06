import "../AppForm.css";
import {useHistory, useParams} from "react-router-dom";
import {Button, Col, Form, FormLabel} from "react-bootstrap";
import {useEffect, useRef, useState} from "react";

const EditGradeForm = () => {


    let {gradeId} = useParams();
    const history = useHistory();

    const editionForm = useRef();

    const [gradeData, setGradeData] = useState(undefined);
    const [valueInput, setValueInput] = useState(0);
    const [weightInput, setWeightInput] = useState(0);
    const [descriptionInput, setDescriptionInput] = useState("");

    const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;
    const API_GRADES_URL = process.env.REACT_APP_API_GRADES;

    const GRADES_ENDPOINT = API_BASE_URL + API_GRADES_URL
        + `${gradeId}/`;
    useEffect(() => {
        const requestOptions = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        };
        fetch(GRADES_ENDPOINT, requestOptions)
            .then((res) => {
                if (res.ok) {
                    return res.json();
                }
            }).then((json) => {
            setGradeData(json);
        })
    }, [GRADES_ENDPOINT]);

    useEffect(() => {
        if (gradeData !== undefined) {
            setValueInput(gradeData.value);
            setWeightInput(gradeData.weight);
            setDescriptionInput(gradeData.description);
        }
    }, [gradeData])

    const editGrade = (event) => {
        if (editionForm.current.reportValidity()) {
            event.preventDefault();
            const patchBody = {};
            let edited = false;
            if (valueInput !== gradeData.value) {
                edited = true;
                patchBody.value = valueInput;
            }
            if (weightInput !== gradeData.weight) {
                edited = true;
                patchBody.weight = weightInput;
            }
            if (descriptionInput !== gradeData.description) {
                edited = true;
                patchBody.description = descriptionInput;
            }
            if (edited) {
                const requestOptions = {
                    method: 'PATCH',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({...patchBody})
                }
                fetch(GRADES_ENDPOINT, requestOptions).then(
                    (res) => {
                        if (res.ok) {
                            history.push("/")
                        }
                    }
                )
            }

        }

    }
    const deleteGrade = () => {
        const requestOptions = {
            method: 'DELETE',
        }
        fetch(GRADES_ENDPOINT, requestOptions).then(
            (res) => {
                if (res.ok) {
                    history.push("/")
                }
            }
        )
    }
    if (gradeData !== undefined) {
        return (
            <div className={"form-container"}>
                <Col>
                    <Form className={"mb-3"} ref={editionForm}>
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
                        <Button variant={"primary"} type={"submit"} onClick={editGrade}>Edit</Button>
                        <Button className={"secondary-form-button"} variant={"danger"}
                                onClick={deleteGrade}>Delete</Button>

                    </Form>

                </Col>
            </div>
        );
    } else {
        return <></>
    }
}
export {EditGradeForm}