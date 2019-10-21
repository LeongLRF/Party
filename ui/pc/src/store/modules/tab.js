const tab = {
  namespaced: true,
  state: {
    tabList: [],
    selectTab: {
      title: '首页',
      content: '/index'
    }
  },
  getters: {
    getTabList: state => {
      return state.tabList
    },
    getselectTab: state => {
      return state.selectTab
    }
  },
  mutations: {
    addTabList (state, list) {
      if (!list) {
        state.tabList = []
        state.selectTab = {
          title: '首页',
          content: '/index'
        }
      } else {
        if (!state.tabList.length) {
          state.selectTab = {
            title: list.name,
            content: list.url
          }
          state.tabList.push({
            title: list.name,
            content: list.url
          })
        } else {
          state.selectTab = {
            title: list.name,
            content: list.url
          }
          if (state.tabList.every(res => res.content !== list.url)) {
            state.tabList.push({
              title: list.name,
              content: list.url
            })
          }
        }
      }
    },
    removeTabList (state, data) {
      if (state.selectTab.content === data) {
        let i = state.tabList.length
        while (i--) {
          if (state.tabList[i].content === data) {
            if (state.tabList.length === 1) {
              state.selectTab = {
                title: '首页',
                content: '/index'
              }
            } else {
              if (i === 0) {
                state.selectTab = state.tabList[i + 1]
              } else {
                state.selectTab = state.tabList[i - 1]
              }
            }
            state.tabList = state.tabList.filter(res => res.content !== data)
          }
        }
      } else {
        state.tabList = state.tabList.filter(res => res.content !== data)
      }
    },
    setSelectTab (state, data) {
      if (data === '/index') {
        state.selectTab = {
          title: '首页',
          content: '/index'
        }
      } else {
        state.selectTab = state.tabList.filter(res => res.content === data)[0]
      }
    }
  },
  actions: {}
}
export default tab
