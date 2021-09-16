import {AppNavbar} from "./component/app-navbar/AppNavbar";
import {Col} from "react-bootstrap";
import {AppMain} from "./component/app-main/AppMain";
import {BrowserRouter,Switch,Route} from "react-router-dom";
import {CreateStudentForm} from "./component/create-student-form/CreateStudentForm";


const App = () => {
  return (<Col>
    <BrowserRouter>
      <AppNavbar/>
      <Switch>
        <Route path={'/'} exact component={AppMain} />
        <Route path={"/create-student-form"} exact component={CreateStudentForm}/>
      </Switch>
    </BrowserRouter>
  </Col>) ;
}

export default App;
