import React from 'react';
import {Link} from 'react-router-dom';

const RestaurantPage = (props) => {
    return (
        <div>
            <header className="breadcrumb my-4">
                <p className="lead">@Restaurant Name</p>
            </header>

            <div className="row">
                <div className="col-md-3">
                    <button type="button" className="btn btn-light">Write a review...</button>
                </div>
            </div>
            <br/>

            <div className="row">
                <p>Rating: </p>
            </div>

            <div className="row">
                <p>Location: </p>
            </div>

            <div className="row">
                <p>Description</p>
            </div>

            <div className="row">
                <img className="card-img-top" style={{height: 30 + 'em'}} src="http://placehold.it/500x325" alt=""/>
            </div>

            <div className="row">
                <p className="mt-5">User reviews</p>
            </div>

            <div className="row">
                <ul className="list-group list-group-flush">
                    <li className="list-group-item">Rating | Review1</li>
                    <li className="list-group-item">Rating | Review2</li>
                    <li className="list-group-item">Rating | Review3</li>
                    <li className="list-group-item">Rating | Review4</li>
                    <li className="list-group-item">Rating | Review5</li>
                </ul>
            </div>
        </div>
    )
}

export default RestaurantPage;