import Vue from 'vue'
import VueRouter from 'vue-router'
import {
  routes
} from './routes'

Vue.use(VueRouter)

//  路由配置
const RouterConfig = {
  routes: routes
}
export const router = new VueRouter(RouterConfig)
router.beforeEach((to, from, next) => {
  next()
})
