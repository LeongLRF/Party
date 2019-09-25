import login from '@/views/login'
import index from '@/views/index'
import information from '@/views/information'

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
  },
  {
    path: '/information',
    redirect: '/information',
    component: index,
    children: [
      { path: '/information', name: 'information', component: information }
    ]
  }
]

export const routes = [
  ...allRouter
]
