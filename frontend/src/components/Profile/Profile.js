import React from 'react';
import {Link} from 'react-router-dom';

const Profile = (props) => {
    return (
        <div>
            <header className="jumbotron my-4">
                <p className="lead"><b>Profile username</b></p>
            </header>


            <div className="row">
                <div className="breadcrumb col-md-3 ml-3" style={{height: 15 + 'em'}}>
                    <p className="lead">Profile info</p>
                </div>

                <div className="breadcrumb col-md-8 ml-5">
                    <div className="btn-group-vertical col-md-12" style={{height: 10 + 'em', margin: 'auto'}}>
                        <button type="button" className="btn btn-secondary m-2">Add new restaurant</button>
                        <button type="button" className="btn btn-secondary m-2">Write a review</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Profile;