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
.ant-table-pagination.ant-pagination {
  margin: 16px 0;
  float: left;
}
.ant-input:focus {
  border-color: #fff;
  outline: 0;
  -webkit-box-shadow: 0 0 0 2px black;
  box-shadow: 0 0 0 0 rgba(24, 144, 255, 0.2);
  border-right-width: 0px !important;
}
</style>
