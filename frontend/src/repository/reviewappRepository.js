import axios from '../custom-axios/axios';

const appService = {
    loginUser: (username, password) => {
        return axios.post("/login", {
            "username" : username,
            "password" : password,
        });
    }
}

export default appService;