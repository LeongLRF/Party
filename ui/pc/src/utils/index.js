import axios from 'axios'
import vue from 'vue'
import QS from 'qs'
import {Message} from 'ant-design-vue'

axios.defaults.withCredentials = true

axios.interceptors.response.use(
  response => {
    return Promise.resolve(response)
  }
)
