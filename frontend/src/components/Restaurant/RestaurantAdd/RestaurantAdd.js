import React from 'react';
import {Link} from 'react-router-dom';

const RestaurantAdd = (props) => {
    return (
        <div>
            <header className="breadcrumb my-4">
                <p className="lead"><b>Add new restaurant</b></p>

            </header>


            <form>
                <div className="form-group">
                    <label htmlFor="restaurantName">Restaurant name</label>
                    <input type="text" className="form-control" id="restaurantName" placeholder="Name"/>
                </div>
                <div className="form-group">
                    <label htmlFor="restaurantDescription">Restaurant Description</label>
                    <textarea className="form-control" id="restaurantDescription" rows="3"></textarea>
                </div>
                <div className="form-group">
                    <label htmlFor="restaurantCategory">Category</label>
                    <select className="form-control" id="restaurantCategory">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <div className="form-group">
                    <label htmlFor="restaurantAddress">Address</label>
                    <input type="text" className="form-control" id="restaurantAddress" placeholder="Address"/>
                </div>
                <div className="form-group">
                    <label htmlFor="restaurantCity">City</label>
                    <input type="text" className="form-control" id="restaurantCity" placeholder="City"/>
                </div>
                <div className="form-group">
                    <label htmlFor="restaurantCountry">Country</label>
                    <input type="text" className="form-control" id="restaurantCountry" placeholder="Country"/>
                </div>
                <div className="form-check form-check-inline">
                    <input className="form-check-input" type="radio" name="inlineRadioOptions" id="delivery"
                           value="option1"/>
                        <label className="form-check-label" htmlFor="delivery">Delivery</label>
                </div>
                <div className="form-check form-check-inline">
                    <input className="form-check-input" type="radio" name="inlineRadioOptions" id="noDelivery"
                           value="option2"/>
                        <label className="form-check-label" htmlFor="noDelivery">No delivery</label>
                </div>
                <br/> <br/>
                <button type="submit" className="btn btn-dark">Submit</button>
            </form>

        </div>
    )
}

export default RestaurantAdd;