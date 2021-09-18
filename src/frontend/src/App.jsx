import {AppNavbar} from "./component/app-navbar/AppNavbar";
import {Col} from "react-bootstrap";
import {AppMain} from "./component/app-main/AppMain";
import {BrowserRouter,Switch,Route} from "react-router-dom";
import {CreateStudentForm} from "./component/form/create-student-form/CreateStudentForm";
import {AddGradeForm} from "./component/form/add-grade-form/AddGradeForm";


const App = () => {
  return (<Col>
    <BrowserRouter>
      <AppNavbar/>
      <Switch>
        <Route path={'/'} exact component={AppMain} />
        <Route path={"/create-student-form"} exact component={CreateStudentForm}/>
        <Route path={"/add-grade-form/:studentId"} exact component={AddGradeForm}/>

      </Switch>
    </BrowserRouter>
  </Col>) ;
}

export default App;
