import login from '@/views/login'
import index from '@/views/index'

export const allRouter = [
  {
    path: '/',
    name: 'index',
    component: index
  },
  {
    path: '/login',
    name: 'login',
    component: login
  }
]

export const routes = [
  ...allRouter
]
