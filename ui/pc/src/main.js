// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import './assets/main.css'
import {
  router
} from './router'
import myUtils from './utils/index'
import store from './store/index'
Vue.config.productionTip = false
Vue.use(Antd)
Vue.use(myUtils, {
  domaintest: 'http://59.110.171.118:8080'
  // domaintest: 'http://127.0.0.1:8089'
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: {
    App
  },
  template: '<App/>'
})
