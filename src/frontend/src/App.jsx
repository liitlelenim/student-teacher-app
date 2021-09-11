import {AppNavbar} from "./component/app-navbar/AppNavbar";
import {Col} from "react-bootstrap";
import {AppMain} from "./component/app-main/AppMain";

const App = () => {
  return (<Col>
    <AppNavbar/>
    <AppMain/>
  </Col>) ;
}

export default App;
