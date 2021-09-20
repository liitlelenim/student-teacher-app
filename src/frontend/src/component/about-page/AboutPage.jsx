import {Col, Container, Row} from "react-bootstrap";
import "./AboutPage.css";

const AboutPage = () => {
    return (
        <Container>
            <Row>
                <Col className={"about-column"}>
                    <h1>About</h1>

                    <p>
                        This website was made for learning purposes.
                        If you would like to learn more about the project check it out <a target={"_blank"}
                                                                                          href={"https://github.com/liitlelenim"}>here</a>.
                    </p>
                    <p>
                        Site created by Jakub Błaszczyk, 2021
                    </p>
                </Col>
                <Col/>

            </Row>
        </Container>)
    //#TODO Change placeholder link
}
export {AboutPage};