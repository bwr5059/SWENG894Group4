import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import routes from './routes'
//import master from './components/layouts.master.vue'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './assets/css/styles.css'

Vue.use(BootstrapVue)
Vue.config.productionTip = false
Vue.use(VueRouter)



const router = new VueRouter({
  routes,
  mode: 'history'
})

new Vue({
  router: router,
  render: h => h(App),
}).$mount('#app')
