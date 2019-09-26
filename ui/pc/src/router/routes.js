export const allRouter = [
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/login')
  },
  {
    path: '/',
    redirect: '/index',
    name: 'index',
    component: () => import('@/views/index'),
    children: [
      {path: '/index', name: 'HelloWorld', component: () => import('@/views/HelloWorld')},
      {path: '/information', name: 'information', component: () => import('@/views/information')}
    ]
  }
]

export const routes = [
  ...allRouter
]
