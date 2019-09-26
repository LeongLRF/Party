<template>
  <div id="app">
    <div class="top">
      <span class="left"
            @click="go('index')">党员管理系统</span>
      <span class="right">
        <span>
          <a-icon type="bell" />
        </span>
        <span>
          <a-icon type="message" />
        </span>
        <span>
          Logout
          <a-icon type="logout" />
        </span>
      </span>
    </div>
    <div class="menu"
         :style="{height:(myheight-60) + 'px'}">
      <div class="Mtop"
           style="margin:10px 30px 0 20px">
        <a-avatar size="large"
                  icon="user" />
        <span style="float:right">
          <div class="name">liang</div>
          <div class="txt">Normal</div>
        </span>
      </div>
      <a-menu mode="inline"
              :openKeys="openKeys"
              @openChange="onOpenChange"
              style="width: 256px">
        <a-sub-menu key="person">
          <span slot="title">
            <a-icon type="mail" />
            <span>个人信息</span>
          </span>
          <a-menu-item key="1"
                       @click="go('information')">Option 1</a-menu-item>
          <a-menu-item key="2">Option 2</a-menu-item>
          <a-menu-item key="3">Option 3</a-menu-item>
          <a-menu-item key="4">Option 4</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="TManager">
          <span slot="title">
            <a-icon type="appstore" />
            <span>台账管理</span>
          </span>
          <a-menu-item key="5">Option 5</a-menu-item>
          <a-menu-item key="6">Option 6</a-menu-item>
          <a-sub-menu key="sub3"
                      title="Submenu">
            <a-menu-item key="7">Option 7</a-menu-item>
            <a-menu-item key="8">Option 8</a-menu-item>
          </a-sub-menu>
        </a-sub-menu>
        <a-sub-menu key="ZManager">
          <span slot="title">
            <a-icon type="setting" />
            <span>账号管理</span>
          </span>
          <a-menu-item key="9">Option 9</a-menu-item>
          <a-menu-item key="10">Option 10</a-menu-item>
          <a-menu-item key="11">Option 11</a-menu-item>
          <a-menu-item key="12">Option 12</a-menu-item>
        </a-sub-menu>
      </a-menu>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {
      rootSubmenuKeys: ['person', 'TManager', 'ZManager'],
      openKeys: [],
      myheight: window.innerHeight
    }
  },
  methods: {
    onOpenChange (openKeys) {
      const latestOpenKey = openKeys.find(
        key => this.openKeys.indexOf(key) === -1
      )
      if (this.rootSubmenuKeys.indexOf(latestOpenKey) === -1) {
        this.openKeys = openKeys
      } else {
        this.openKeys = latestOpenKey ? [latestOpenKey] : []
      }
    },
    go (title) {
      this.$router.push({ path: '/' + title })
    }
  },
  mounted () {
    console.log('123', this.myheight)
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
