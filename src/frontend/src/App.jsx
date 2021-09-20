import {AppNavbar} from "./component/app-navbar/AppNavbar";
import {Col} from "react-bootstrap";
import {AppMain} from "./component/app-main/AppMain";
import {BrowserRouter,Switch,Route} from "react-router-dom";
import {CreateStudentForm} from "./component/form/create-student-form/CreateStudentForm";
import {AddGradeForm} from "./component/form/add-grade-form/AddGradeForm";
import {EditGradeForm} from "./component/form/edit-grade-form/EditGradeForm";
import {EditStudentForm} from "./component/form/edit-student-form/EditStudentForm";
import {AboutPage} from "./component/about-page/AboutPage";


const App = () => {
  return (<Col>
    <BrowserRouter>
      <AppNavbar/>
      <Switch>
        <Route path={'/'} exact component={AppMain} />
        <Route path={'/about'} exact component={AboutPage} />\
        <Route path={"/create-student-form"} exact component={CreateStudentForm}/>
        <Route path={"/add-grade-form/:studentId"} exact component={AddGradeForm}/>
        <Route path={"/edit-grade-form/:gradeId"} exact component={EditGradeForm}/>
        <Route path={"/edit-student-form/:studentId"} exact component={EditStudentForm} />
      </Switch>
    </BrowserRouter>
  </Col>) ;
}

export default App;
