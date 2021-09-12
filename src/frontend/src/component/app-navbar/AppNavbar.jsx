import {Container, Nav, Navbar} from "react-bootstrap";
import {Link} from "react-router-dom";

const AppNavbar = () => {
    return (
        <Navbar bg="dark" variant="dark">
            <Container>
                <Navbar.Brand href="">Student-Teacher</Navbar.Brand>
                <Nav className="me-right">
                    <Nav.Link><Link to={"/"}
                                    style={{color: 'inherit', textDecoration: 'inherit'}}>Home
                    </Link></Nav.Link>
                    <Nav.Link>
                        <Link to={"/about"}
                              style={{color: 'inherit', textDecoration: 'inherit'}}>About
                        </Link>
                    </Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    )
}
export {AppNavbar};