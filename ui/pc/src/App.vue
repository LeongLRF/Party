<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App'
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
