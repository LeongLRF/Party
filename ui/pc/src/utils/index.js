import axios from 'axios'
import QS from 'qs'
import vue from 'vue'
import {router} from '../router/index'
import Message from 'ant-design-vue/lib/message'
const myUtils = {}

axios.defaults.withCredentials = true

axios.interceptors.response.use(
  response => {
    if (response.headers.authorization) {
      vue.prototype.$setCookie('Token', response.headers.authorization, 1000 * 60 * 60 * 24)
    }
    if (response.data.success) {
      return Promise.resolve(response)
    } else if (response.data.message === '未登录') {
      Message.error(response.data.message)
      router.replace({
        path: '/login'
      })
      return Promise.reject(response)
    } else {
      Message.error(response.data.message)
    }
  },
  error => {
    Message.error('服务器异常')
    return Promise.reject(error.response)
  }
)

myUtils.install = (Vue, options) => {
  // 根据环境判断用哪个url
  let host = process.env.NODE_ENV === 'development' ? options.domaintest : window.location.origin
  axios.defaults.baseURL = host
  console.log(host)
  Vue.prototype.$post = (api, params) => {
    return new Promise((resolve, reject) => {
      axios.post(api, QS.stringify(params))
        .then(response => {
          resolve(response.data)
        })
        .catch(err => {
          reject(err.data)
        })
    })
  }
  // get请求(Request Payload)
  Vue.prototype.$my_get = (url, params = {}) => {
    return new Promise((resolve, reject) => {
      axios.get(url, {
        params: params
      })
        .then(response => {
          resolve(response.data)
        })
        .catch(err => {
          reject(err)
        })
    })
  }
  // 设置cookie
  Vue.prototype.$setCookie = (name, value, expire) => {
    var date = new Date()
    date.setSeconds(date.getSeconds() + expire)
    document.cookie = name + '=' + escape(value) + '; expires=' + date.toGMTString()
  }
  // 获取cookie
  Vue.prototype.$getCookie = (name) => {
    if (document.cookie.length > 0) {
      let start = document.cookie.indexOf(name + '=')
      if (start !== -1) {
        start = start + name.length + 1
        let end = document.cookie.indexOf(';', start)
        if (end === -1) end = document.cookie.length
        return unescape(document.cookie.substring(start, end))
      }
    }
    return ''
  }
  Vue.prototype.$message = Message
}
export default myUtils
