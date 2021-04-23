import React from 'react';
import {Link} from 'react-router-dom';
import {useHistory} from 'react-router-dom';

const Login = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        username: "",
        password: ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const username = formData.username;
        const password = formData.password;

        props.onLogin(username, password);
        history.push("/loggedIn");

    }


    return (
        <div>
            <form className="form-signin mt-xl-5" onSubmit={onFormSubmit}>
                <h2 className="form-signin-heading">Sign in</h2>
                <p>
                    <label htmlFor="username" className="sr-only">Username</label>
                    <input type="text" id="username" name="username" className="form-control" placeholder="Username"
                           required=""
                           autoFocus=""
                           onChange={handleChange}/>
                </p>
                <p>
                    <label htmlFor="password" className="sr-only">Password</label>
                    <input type="password" id="password" name="password" className="form-control" placeholder="Password"
                           required=""
                           onChange={handleChange}/>
                </p>

                <button id="submit" className="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
            <Link to="/register" className="btn btn-block btn-light">Register here</Link>
        </div>
    );
}

export default Login;