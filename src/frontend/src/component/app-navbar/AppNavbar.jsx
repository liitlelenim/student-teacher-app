import {Container, Nav, Navbar} from "react-bootstrap";

const AppNavbar = () => {
    return (
        <Navbar bg="dark" variant="dark">
            <Container>
                <Navbar.Brand href="">Student-Teacher</Navbar.Brand>
                <Nav className="me-right">
                    <Nav.Link href="#home">Home</Nav.Link>
                    <Nav.Link href="#about">About</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    )
}
export {AppNavbar};