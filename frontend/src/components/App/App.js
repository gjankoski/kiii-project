import './App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom';
import Header from '../Header/header';
import Footer from '../Footer/footer';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {

        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className={"container"}>
                        <Route />
                    </div>
                </main>
                <Footer/>
            </Router>
        );
    }

    componentDidMount() {
    }
}

export default App;
