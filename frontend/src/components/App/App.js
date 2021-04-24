import './App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom';
import appService from '../../repository/reviewappRepository';
import Header from '../Header/header';
import Footer from '../Footer/footer';
import Homepage from '../Homepage/homepage';
import Login from '../Login/Login';
import LoggedIn from '../LoggedIn/LoggedIn';
import Profile from '../Profile/Profile';
import Register from '../Register/Register';
import RestaurantPage from '../Restaurant/RestaurantPage/RestaurantPage';
import RestaurantAdd from '../Restaurant/RestaurantAdd/RestaurantAdd';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className={"container"}>
                        <Route path={"/"} exact render={() =>
                            <Homepage />}/>
                        <Route path={"/login"} exact render={() =>
                            <Login onLogin={this.onLogin} />}/>
                        <Route path={"/loggedIn"} exact render={() =>
                            <LoggedIn />}/>
                        <Route path={"/profile"} exact render={() =>
                            <Profile />}/>
                        <Route path={"/register"} exact render={() =>
                            <Register />}/>
                        <Route path={"/restaurant"} exact render={() =>
                            <RestaurantPage />}/>
                        <Route path={"/addRestaurant"} exact render={() =>
                            <RestaurantAdd />}/>
                    </div>
                </main>
                <Footer/>
            </Router>
        );
    }

    componentDidMount() {
    }

    onLogin = (username, password) => {
        appService.loginUser(username, password)
            .then((data) => {
                this.setState({
                    user: data.data
                })
            })
    }


}

export default App;
