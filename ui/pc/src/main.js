// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import {router} from './router'
import myUtils from './utils/index'
Vue.config.productionTip = false
Vue.use(Antd)
Vue.use(myUtils, {domaintest: 'http://127.0.0.1:8080'})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
