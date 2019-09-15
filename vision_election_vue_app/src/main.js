import Vue from 'vue'

import App from './App.vue'
import router from './router'
//import master from './components/layouts.master.vue'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './assets/css/styles.css'
import VueLogger from 'vuejs-logger'


Vue.config.productionTip = false

Vue.use(BootstrapVue)

Vue.use(VueLogger, options)


const options = {
  isEnabled: true,
  logLevel : 'debug',
  stringifyArgument : false,
  showLogLevel : true,
  showMethodName : false,
  separator: '|',
  showConsoleColors: true
}

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')



export default router;