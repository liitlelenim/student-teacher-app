import {Container, Nav, Navbar} from "react-bootstrap";
import {Link} from "react-router-dom";

const AppNavbar = () => {
    return (
        <Navbar bg="dark" variant="dark">
            <Container>
                <Navbar.Brand href="">Student-Teacher</Navbar.Brand>
                <Nav className="me-right">
                    <Nav.Link as={Link} to={"/"}>
                        Home
                    </Nav.Link>
                    <Nav.Link as={Link} to={"/about"}>
                        About
                    </Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    )
}
export {AppNavbar};