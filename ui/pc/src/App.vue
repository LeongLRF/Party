<template>
  <a-locale-provider :locale="zhCN">
    <div id="app">
      <router-view />
    </div>
  </a-locale-provider>
</template>

<script>
import zhCN from 'ant-design-vue/lib/locale-provider/zh_CN'
export default {
  name: 'App',
  data () {
    return {
      zhCN
    }
  }
}
</script>

<style >
.ant-table .ant-table-thead > tr > th {
  background: #eb4048 !important;
  border: 1px solid #ccc !important;
}
.ant-table-small > .ant-table-content > .ant-table-body {
  margin: 0 !important;
}
</style>
