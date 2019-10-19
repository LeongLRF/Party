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
.ant-tabs-bar {
  border-bottom: none !important;
}
.ant-tabs.ant-tabs-card .ant-tabs-card-bar .ant-tabs-tab {
  color: #ffff;
  background: #eb4048;
  /* background: blue; */
  border: none;
  margin-top: 0px;
  margin-bottom: 0px;
  margin-left: 2px;
  border-radius: 7px 7px 0px 0px;
}
.ant-tabs.ant-tabs-card .ant-tabs-card-bar .ant-tabs-tab-active {
  color: rgb(12, 12, 12) !important;
  background: #fff !important;
}
.table .ant-input:focus {
  border-color: #fff;
  outline: 0;
  box-shadow: 0 0 0 0 rgba(11, 12, 12, 0.2);
  border-right-width: 0px !important;
}
</style>
