<template>
  <div id="app">
    <div class="top">
      <span class="left" @click="go('/index')" style="font-family: FangSong,sans-serif"><img src="../assets/123.png"
          alt="" width="60" />党员管理系统 </span>
      <span class="center">
        <top-tab></top-tab>
      </span>
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
      <a-collapse :bordered="false">
        <a-collapse-panel key="1" :showArrow="false" style="border-bottom: 0; margin-top: 0">
          <div class="Mtop" style="margin:10px 30px 0 20px" slot="header">
            <a-avatar size="large" icon="user" />
            <span style="float:right">
              <div class="name">liang</div>
              <div class="txt">Normal</div>
            </span>
          </div>
          <a-menu>
            <a-menu-item @click="go('/logout')">
              <a-icon type="logout" />退出</a-menu-item>
            <a-menu-item @click="go('/logout')">
              <a-icon type="setting" />设置</a-menu-item>
          </a-menu>
        </a-collapse-panel>
      </a-collapse>
      <a-menu mode="inline" v-model="selectMenu" v-for="(item) in menus" :key="item.id" style="width: 15%"
        @openChange="onOpenChange" :openKeys="openKeys">
        <a-sub-menu :key="item.parent.name">
          <span slot="title">
            <a-icon :type="item.parent.icon" />
            <span>{{item.parent.name}}</span>
          </span>
          <a-menu-item v-for="(items,index) in item.children" :key="index" @click="add(items)">
            {{items.name}}
          </a-menu-item>
        </a-sub-menu>
      </a-menu>
    </div>

  </div>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex'
export default {
  name: 'menu',
  data () {
    return {
      rootSubmenuKeys: [],
      openKeys: [],
      menus: [],
      myheight: window.innerHeight,
      mywidth: window.innerWidth,
      selectMenu: []
    }
  },
  components: {
    topTab: () => import('@/components/topTab')
  },
  computed: {
    ...mapGetters('tab', ['getselectTab'])
  },
  watch: {
    getselectTab: {
      handler (Val) {
        this.selectMenu = [Val.content]
        this.$router.push(Val.content)
        this.Menu = ['/' + Val.content.split('/')[1]]
      },
      deep: true
    },
    '$route.path': {
      handler (Val) {
        console.log('val', Val)
        if (Val === '/index') {
          this.MenuList2 = []
        }
      }
    }
  },
  methods: {
    ...mapMutations('tab', ['addTabList', 'setSelectTab']),
    add (e) {
      this.addTabList(e)
    },
    onOpenChange (openKeys) {
      console.log(123, openKeys)
      const latestOpenKey = openKeys.find(key => this.openKeys.indexOf(key) === -1)
      console.log(latestOpenKey)
      if (this.rootSubmenuKeys.indexOf(latestOpenKey) === -1) {
        this.openKeys = openKeys
      } else {
        this.openKeys = latestOpenKey ? [latestOpenKey] : []
      }
    },
    go (path) {
      this.$router.push(path)
    }
  },
  mounted () {
    this.$my_get('/sys/menu_list').then(res => {
      this.menus = res.data
      this.menus.forEach(item => this.rootSubmenuKeys.push(item.parent.name))
      console.log(this.rootSubmenuKeys)
      console.log('进来菜单啦')
    })
    console.log(this.menus)
    console.log(123, this.$router.options.routes)
    // 刷新清空Tab,回到主页
    this.addTabList()
    this.$router.push('/index')
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
.center {
  position: absolute;
  left: 255px;
  bottom: -16px;
  width: 720px;
}
.right {
  position: absolute;
  right: 8%;
  top: 15px;
  font-size: 16px;
}
.right > span {
  margin-left: 10px;
}
.menu {
  float: left;
  width: 15%;
  /*min-width: 160px;*/
  border-right: 1px solid #ccc;
}
</style>
