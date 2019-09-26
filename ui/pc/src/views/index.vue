<template>
  <div>
    <Menu></Menu>
    <div class="view"
         :style="{height: myH+'px'}">
      <router-view />
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
      myH: window.innerHeight
    }
  },
  mounted () {
    // this.$my_get('/sys/current_user').then(res => {
    //   console.log(res.data)
    // })
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
  margin: 0 0 0 257px;
  padding: 15px;
  background: #f0efef;
}
</style>
