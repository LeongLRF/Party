<template>
  <div>
    <Menu></Menu>
    <div class="view" :style="{height: (myH-60)+'px'}">
      <keep-alive>
        <router-view />
      </keep-alive>
    </div>
  </div>
</template>
<script>
export default {
  name: 'index',
  components: {
    Menu: () => import('@/components/menu')
  },
  data () {
    return {
      myH: window.innerHeight,
      myW: window.innerWidth,
      user: {}
    }
  },
  mounted () {
    this.$my_get('/sys/current_user').then(res => {
      console.log(res.data)
      this.user = res.data
    })
    // if (this.user) {
    //   this.$my_get('/sys/menu_list').then(res => {
    //     console.log(res)
    //   })
    // }
  }
}
</script>
<style>
#components-layout-demo-custom-trigger .trigger {
  font-size: 18px;
  line-height: 64px;
  padding: 0 24px;
  cursor: pointer;
  transition: color 0.3s;
}

#components-layout-demo-custom-trigger .trigger:hover {
  color: #1890ff;
}

#components-layout-demo-custom-trigger .logo {
  height: 32px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px;
}
.view {
  width: 85%;
  margin: 0 15%;
  padding:10px 0 0 10px;
  background: #f0efef;
  overflow: hidden;
}
.ant-table {
  clear: none;
}
</style>
