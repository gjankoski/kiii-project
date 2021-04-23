import React from 'react';
import {Link} from 'react-router-dom';

const LoggedIn = (props) => {
    return (
        <div>
            <header className="jumbotron my-4">
                <div className="row col-md-6 mt-4">
                    <p className="lead"><b>Search a restaurant</b></p>
                </div>

                <div className="row">
                    <form className="form-inline col-md-6 mb-5">
                        <div className="input-group mt-4">
                            <input type="email" className="form-control" size="50" placeholder="Write a name..." required/>
                                <div className="input-group-btn">
                                    <button type="button" className="btn btn-primary">Search</button>
                                </div>
                        </div>
                    </form>
                </div>
            </header>
            <div className="row mt-5">
                <div className="col-md-2">
                    <p className="lead">Search by location:</p>
                </div>
                <div className="col-md-6">
                    <form className="form-inline">
                        <div className="input-group">
                            <input type="email" className="form-control" size="50" placeholder="Location..." required/>
                                <div className="input-group-btn">
                                    <button type="button" className="btn btn-primary">Search</button>
                                </div>
                        </div>
                    </form>
                </div>
            </div>
            <div className="row col-md-6 mt-5">
                <p className="lead">Top-rated restaurants in your neighborhood</p>
            </div>
            <div className="row text-center">

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

            </div>

            <div className="row col-md-6 mt-5">
                <p className="lead">Search results:</p>
            </div>
            <div className="row text-center">

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

            </div>

            <div className="row text-center">

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

                <div className="col-lg-3 col-md-6 mb-4">
                    <div className="card h-100">
                        <img className="card-img-top" src="http://placehold.it/500x325" alt=""/>
                            <div className="card-body">
                                <h4 className="card-title">Restaurant name</h4>
                                <p className="card-text">Location and description</p>
                            </div>
                            <div className="card-footer">
                                <p className="card-text">Rating: </p>
                            </div>
                    </div>
                </div>

            </div>
        </div>

    )
}

export default LoggedIn;