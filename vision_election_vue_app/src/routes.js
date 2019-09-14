import landing from './components/marketing/landing.vue'
import aboutPage from './components/marketing/aboutPage.vue'
import login from './components/auth/login.vue'
import register from './components/auth/register.vue'

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
        component: register}
  ]

  export default routes