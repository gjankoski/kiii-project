import './App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom';
import appService from '../../repository/reviewappRepository';
import Header from '../Header/header';
import Footer from '../Footer/footer';
import Homepage from '../Homepage/homepage'

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user = {}
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
