import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from 'vuex-persistedstate';
import Cookies from 'js-cookie';
import  axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        // token : '',
        // user : {},
        // authenticated : false
        token : '',
        user : {
            email : 'danarossa14@gmail.com',
            name: 'dana',
            surname : 'yurchenko',
            userId : 1
        },
        authenticated : true
    },
    mutations: {
        token (state, token) {
            state.token = token
        },
        user(state, user) {
            state.user = user
        },
        authenticated(state, authenticated) {
            state.authenticated = authenticated
        },
    },
    actions: {
    },
    plugins: [createPersistedState({
        storage: {
            getItem: key => Cookies.get(key),
            setItem: (key, value) => Cookies.set(key, value, {expires: 3}),
            removeItem: key => Cookies.remove(key)
        }
    })]
});
