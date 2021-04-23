import React from 'react';
import {Link} from 'react-router-dom';

const Register = (props) => {
    return (
        <div>
            <form className="form-signin mt-xl-5">
                <h2 className="form-signin-heading">Register</h2> <br/>
                <p>
                    <label htmlFor="username" className="sr-only">Username</label>
                    <input type="text" id="username" name="username" className="form-control" placeholder="Username"
                           required
                           autoFocus=""/>
                </p>
                <p>
                    <label htmlFor="password" className="sr-only">Password</label>
                    <input type="password" id="password" name="password" className="form-control" placeholder="Password"
                           required/>
                </p>
                <p>
                    <label htmlFor="repeatedPassword" className="sr-only">Repeat Password</label>
                    <input type="password" id="repeatedPassword" name="repeatedPassword" className="form-control"
                           placeholder="Repeat Password"
                           required/>
                </p>
                <p>
                    <label htmlFor="name" className="sr-only">First Name</label>
                    <input type="text" id="name" name="name" className="form-control" placeholder="Name"
                           required/>
                </p>
                <p>
                    <label htmlFor="lastName" className="sr-only">Last Name</label>
                    <input type="text" id="lastName" name="lastName" className="form-control" placeholder="Last Name"
                           required/>
                </p>
                <p>
                    <label htmlFor="city" className="sr-only">City</label>
                    <input type="text" id="city" name="city" className="form-control" placeholder="City"
                           required=""/>
                </p>
                <p>
                    <label htmlFor="country" className="sr-only">Country</label>
                    <input type="text" id="country" name="country" className="form-control" placeholder="Country"
                           required=""/>
                </p>


                <button id="submit" className="btn btn-lg btn-primary btn-block" type="submit">Register</button>
            </form>
            <Link to="/login" className="btn btn-block btn-light">Already have an account? Sign in here</Link>
        </div>
    )
}

export default Register;