import Auth from "@okta/okta-vue";  
import Vue from 'vue'  
import Router from 'vue-router'  
import landing from './components/marketing/landing.vue'
import aboutPage from './components/marketing/aboutPage.vue'
import login from './components/auth/login.vue'
import register from './components/auth/register.vue'
import home from './components/mainApp/home.vue' 
  
Vue.use(Auth, {  
  issuer: 'https://dev-208412.okta.com/oauth2/default',  
  client_id: '0oa1cpsqjg5Ru9HSb357',  
  redirect_uri: window.location.origin + '/implicit/callback',  
  scope: 'openid profile email'  
});  
  
Vue.use(Router);  
  
let router = new Router({  
  mode: 'history',  
  routes: [  
    {
        path: '/',
        component: landing,
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
	    path: '/implicit/callback',  
	    component: Auth.handleCallback(),  
	},  
  ]  
});  

router.beforeEach(Vue.prototype.$auth.authRedirectGuard());  
export default router;