import axios from 'axios'
import QS from 'qs'
import Message from 'ant-design-vue/lib/message'
const myUtils = {}

axios.defaults.withCredentials = true

axios.interceptors.response.use(
  response => {
    if (response.data.success) {
      return Promise.resolve(response)
    } else {
      Message.error(response.date.message)
      return Promise.reject(response)
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
  Vue.$post = (api, params) => {
    return new Promise((resolve, reject) => {
      axios.post(api, QS.stringify(params)
        .then(response => {
          resolve(response.data)
        })
        .catch(err => {
          reject(err.data)
        }))
    })
  }
  // get请求(Request Payload)
  Vue.$my_get = (url, params = {}) => {
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
}
export default myUtils
