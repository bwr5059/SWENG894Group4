import Auth from "@okta/okta-vue";  
import Vue from 'vue'  
import Router from 'vue-router'  
import landing from './components/marketing/landing.vue'
import aboutPage from './components/marketing/aboutPage.vue'
import login from './components/auth/login.vue'
import register from './components/auth/register.vue'
import home from './components/mainApp/home.vue' 
import profile from './components/profile/profile.vue'
import homeLayout from './components/layouts/homeLayout.vue'
import createElection from './components/election/createElection.vue'
import viewElection from './components/election/viewElection.vue'
import electionDetails from './components/election/electionDetails.vue'
import help from './components/marketing/help.vue'
import accountHelp from './components/marketing/help/accountHelp.vue'
import ballotHelp from './components/marketing/help/ballotHelp.vue'
import registrationHelp from './components/marketing/help/registrationHelp.vue'
import electionHelp from './components/marketing/help/electionHelp.vue'
import electionSettingsHelp from './components/marketing/help/electionSettingsHelp.vue'
import candidateHelp from './components/marketing/help/candidateHelp.vue'
import votersHelp from './components/marketing/help/votersHelp.vue'

import elections from './components/election/elections.vue'
  
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
        path: '/help',
        component: help,
        children: [
          {
              path: "account",
              component: accountHelp
          },
          {
            path: "ballot",
            component: ballotHelp
        },
          {
            path: "registration",
            component: registrationHelp
        },
        {
          path: "election",
          component: electionHelp
      },
      {
        path: "election_settings",
        component: electionSettingsHelp
    },
      {
        path: "candidates",
        component: candidateHelp
    },
    {
      path: "voters",
      component: votersHelp
  },
      ]
      },
     
       
    {
        path: '/app/:id',
        component: homeLayout,
        children: [{
          path: 'home',
          component: home
        },
        {
          path: 'createElection',
          component: createElection

        },
        {
          path: 'election/:eID',
          component: viewElection,
          children: [{
            path:'details',
            component: electionDetails
          }],
        },
        {
          path: 'elections',
          component: elections
        }
      
      ],
        meta: {
            requiresAuth: true}}, 
    {
      path: '/profile',
      component: profile,
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