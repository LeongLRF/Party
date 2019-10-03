import Vue from 'vue'
import Vuex from 'vuex'
import VuexPersistence from 'vuex-persist'
const vuexLocal = new VuexPersistence({
  storage: window.localStprage
})
Vue.use(Vuex)
export default new Vuex.Store({
  modules: {
    tab: () => import('@/store/tab')
  },
  plugins: [vuexLocal.plugin]
})
