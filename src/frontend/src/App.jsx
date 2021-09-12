import {AppNavbar} from "./component/app-navbar/AppNavbar";
import {Col} from "react-bootstrap";
import {AppMain} from "./component/app-main/AppMain";
import {BrowserRouter,Switch,Route} from "react-router-dom";


const App = () => {
  return (<Col>
    <BrowserRouter>
      <AppNavbar/>
      <Switch>
        <Route path={'/'} exact component={AppMain} />
      </Switch>
    </BrowserRouter>
  </Col>) ;
}

export default App;
