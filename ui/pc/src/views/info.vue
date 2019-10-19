<template>
  <div style="background-color:#eee;">
    <a-row>
      <a-col span="7"
        style="background-color:#fff;margin-right: 35px;padding-left: 20px;padding-right: 20px;box-shadow: 3px 3px 3px #ccc;">
        <div class="header">
          <a-avatar :size="100" icon="user" />
          <p class="position" style="font-weight: bold;margin-top: 20px;">PROFESSOR</p>
          <p class="name">Mr`Leong</p>
        </div>
        <a-divider type="horizontal" :dashed="true" style="margin-bottom: 20px; "></a-divider>
        <div class="info">
          <p>
            <a-icon type="user" />&nbsp;123456</p>
          <p>
            <a-icon type="key" />&nbsp; ******* <a href="">
              <a-icon type="edit" /></a></p>
        </div>
      </a-col>
      <a-col span="16" style="background-color:#fff;padding: 20px;box-shadow: 3px 3px 3px #ccc;">
        <a-tabs defaultActiveKey="1" @change="callback">
          <a-tab-pane tab="最新通知" key="1">Content of Tab Pane 1</a-tab-pane>
          <a-tab-pane tab="发送记录" key="2" forceRender>Content of Tab Pane 2</a-tab-pane>
          <a-tab-pane tab="任务提醒" key="3">Content of Tab Pane 3</a-tab-pane>
        </a-tabs>
      </a-col>
    </a-row>
  </div>
</template>

<script>
export default {
  name: 'info',
  data () {
    return {
    }
  },
  methods: {
    callback () { }
  }
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}
.header {
  text-align: center;
  padding-top: 20px;
  padding-bottom: 20px;
}
.position {
  font-weight: bold;
  font-size: 20px;
}
.info {
  font-size: 18px;
  margin-bottom: 20px;
}
</style>
