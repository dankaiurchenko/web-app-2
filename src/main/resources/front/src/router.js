import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";
import Login from "./views/Login.vue";
import Courses from "./views/Courses.vue";
import Lecturers from "./views/Lecturers.vue";
import Students from "./views/Students.vue";
import Archive from "./views/Archive.vue";
import CoursePage from "./views/CoursePage.vue";
import UserPage from "./views/UserPage.vue";
import UsersPage from "./views/UsersPage.vue";
import NotFound from "./views/NotFound.vue";
import RealizedCoursePage from "./views/RealizedCoursePage.vue";

import store from './store.js';

Vue.use(Router);

const router = new Router({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        {
            path: "/",
            name: "home",
            component: Home,
            meta: {nonRequiresAuth: true}
        },
        {
            path: "/about",
            name: "about",
            component: () =>
                import(/* webpackChunkName: "about" */ "./views/About.vue")
        },
        {path: "/login", name: "login", component: Login,  meta: {loginPage: true, nonRequiresAuth: true}},
        {path: "/courses", component: Courses},
        {path: "/courses/:id", component: CoursePage},
        {path: "/realized-courses/:id", component: RealizedCoursePage},
        {path: "/lecturers", component: Lecturers},
        {path: "/students", component: Students},
        {path: "/archive", component: Archive},
        {path: "/users/:id", component: UserPage},
        {path: "/users", component: UsersPage},
        {path: '/404', component: NotFound},
        {path: '*', redirect: '/404'}
    ]
});


router.beforeEach((to, from, next) => {
    const requiresAuth = !to.matched.some(record => record.meta.nonRequiresAuth);
    const isLoginPage = to.matched.some(record => record.meta.loginPage);
    const isAuthenticated = store.state.authenticated;
    if (requiresAuth && !isAuthenticated) {
        next('/login')
    } else if (isLoginPage && isAuthenticated) {
        router.push('/home')
    }
    next()
});

export default router
