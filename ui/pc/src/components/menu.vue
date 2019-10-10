<template>
  <div id="app">
    <div class="top">
      <span class="left" @click="go('/index')">党员管理系统 </span>
      <!-- <span class="center">
        <my-tab></my-tab>
      </span> -->
      <span class="right">
        <span>
          <a-icon type="bell" />
        </span>
        <span>
          <a-icon type="message" />
        </span>
        <span @click="go('/logout')">Logout
          <a-icon type="logout" /></span>
      </span>
    </div>
    <div class="menu" :style="{height:(myheight-60) + 'px'}">
      <div class="Mtop" style="margin:10px 30px 0 20px">
        <a-avatar size="large" icon="user" />
        <span style="float:right">
          <div class="name">liang</div>
          <div class="txt">Normal</div>
        </span>
      </div>
      <a-menu mode="inline" v-for="(item) in menus" :key="item.id" style="width: 256px">
        <a-sub-menu :key="item.name">
          <span slot="title">
            <a-icon :type="item.parent.icon" />
            <span>{{item.parent.name}}</span>
          </span>
          <a-menu-item v-for="(items,index) in item.children" :key="index" @click="go(items.url)">{{items.name}}
          </a-menu-item>
        </a-sub-menu>
      </a-menu>
    </div>

  </div>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex'
export default {
  name: 'App',
  data () {
    return {
      rootSubmenuKeys: ['person', 'TManager', 'ZManager'],
      openKeys: [],
      menus: [],
      myheight: window.innerHeight,
      mywidth: window.innerWidth,
      MenuList: []
    }
  },
  components: {
  },
  computed: {
    ...mapGetters('tab', ['getTabList', 'getSelectTab'])
  },
  methods: {
    ...mapMutations('tab', ['addTabList', 'setSelectTab']),
    handleMenuList (e) {
      console.log(666, e)
      this.addTabList(this.MenuList2.filter(res => res.path === e.key)[0])
    },
    go (path) {
      console.log(666, path)
      this.$router.push(path)
    }
  },
  mounted () {
    this.$my_get('/sys/menu_list').then(res => {
      this.menus = res.data
      console.log('进来菜单啦')
    })
    console.log(this.menus)
    console.log(123, this.$router.options.routes)
  },
  activated () {
    this.$my_get('/sys/menu_list').then(res => {
      this.menus = res.data
    })
  }
}
</script>

<style>
.top {
  background-color: #e2151f;
  height: 60px;
  padding: 8px;
  position: relative;
}
.left {
  font-size: 24px;
  line-height: 36px;
  position: absolute;
}
.right {
  position: absolute;
  right: 100px;
  top: 15px;
  font-size: 16px;
}
.right > span {
  margin-left: 10px;
}
.menu {
  float: left;
  width: 257px;
  border-right: 1px solid #ccc;
}
</style>
