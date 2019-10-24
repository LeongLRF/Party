export const allRouter = [{
  path: '/login',
  name: 'login',
  component: () => import('@/views/login'),
  meta: {
    isView: false
  }
},
{
  path: '/',
  name: 'I',
  redirect: '/index',
  component: () => import('@/views/index'),
  meta: {
    icon: 'team',
    isView: false,
    title: '首页'
  },
  children: [{
    path: '/index',
    name: 'index',
    meta: {
      title: '首页'
    },
    component: () => import('@/views/HelloWorld')
  }]
},
{
  path: '/person',
  name: 'person',
  component: () => import('@/views/index'),
  meta: {
    icon: 'mail',
    isView: true,
    title: '个人信息'
  },
  children: [{
    path: '/information',
    name: 'information',
    meta: {
      title: '我的信息'
    },
    component: () => import('@/views/information')
  }]
},
{
  path: '/TManage',
  name: 'TManage',
  component: () => import('@/views/index'),
  meta: {
    icon: 'appstore',
    isView: true,
    title: '台账管理'
  },
  children: [{
    path: '/taiManage',
    name: 'taiManage',
    meta: {
      title: '台账'
    },
    component: () => import('@/views/tai')
  }]
},
{
  path: '/ZManage',
  name: 'ZManage',
  component: () => import('@/views/index'),
  meta: {
    icon: 'setting',
    isView: true,
    title: '账号管理'
  },
  children: [{
    path: '/mesManage',
    name: 'mesManage',
    meta: {
      title: '信息管理'
    },
    component: () => import('@/views/mesManage')
  }]
},
{
  path: '/logout',
  name: 'logout',
  redirect: '/login'
},
{
  path: '/my',
  name: 'my',
  component: () => import('@/views/index'),
  children: [{
    path: '/info',
    name: 'info',
    component: () => import('@/views/info')
  }]
},
{
  path: '/system',
  name: 'system',
  component: () => import('@/views/index'),
  children: [{
    path: '/menuList',
    name: 'menuList',
    component: () => import('@/views/menuList')
  }, {
    path: '/class',
    name: 'class',
    component: () => import('@/views/class')
  }, {
    path: '/type',
    name: 'type',
    component: () => import('@/views/activityType')
  }]
}
]

export const routes = [
  ...allRouter
]
