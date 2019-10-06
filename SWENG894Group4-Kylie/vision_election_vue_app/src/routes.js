import landing from './components/marketing/landing.vue'
import aboutPage from './components/marketing/aboutPage.vue'
import login from './components/auth/login.vue'
import register from './components/auth/register.vue'
import home from './components/mainApp/home.vue'
import Auth from "@okta/okta-vue";  
import Vue from 'vue'  
import Router from 'vue-router' 



const routes = [
    {
        path: '/',
        component: landing
    },
    {
        path: '/about',
        component: aboutPage},
    {
        path: '/login',
        component: login},
    {
        path: '/register',
        component: register},
    {
        path: '/home',
        component: home,
        meta: {
            requiresAuth: true}},
    {
        path: 'implicit/callback',
        component: Auth.handleCallback()
    },
  ]

 

  export default routes