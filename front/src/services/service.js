import http from '../services/http.js'
export default new class Service{
    getUser() {
        const token = localStorage.getItem('token');
        return http.get('/api/user', {
            // headers: {
            //     'Authorization': 'Bearer ' + token
            // }
        }).then(function (response) {
            return response.data;
        }).catch(function (error) {
            console.log(error);
        });
    }
    getUserTasks() {
        const token = localStorage.getItem('token');
        return http.get('/api/user/task', {
            // headers: {
            //     'Authorization': 'Bearer ' + token
            // }
        }).then(response => {
            return response;
        }).catch(function (error) {
            console.log(error);
        });
    }
    get currentUser() {
        return this.getUser();
    }
}