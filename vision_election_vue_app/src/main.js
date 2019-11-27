import Vue from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './assets/css/styles.css'
import VueLogger from 'vuejs-logger'
import VueFusionCharts from 'vue-fusioncharts';
import FusionCharts from 'fusioncharts';
import Column2D from 'fusioncharts/fusioncharts.charts';
import FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion';
import Charts from 'fusioncharts/fusioncharts.charts';

Vue.config.productionTip = false
Vue.use(BootstrapVue)
Vue.use(VueLogger, options)
Vue.use(VueFusionCharts, FusionCharts, Column2D, FusionTheme, Charts);

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