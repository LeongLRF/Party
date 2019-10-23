<template>
  <div>
    <div class="nav">
      <a-button type='primary' @click="open">
        <a-icon type="plus" />新增</a-button>
    </div>
    <a-table :dateSource="dataSource"  :columns="columns" style="width: 30%;" size="small"></a-table>
    <add-type ref="addType"></add-type>
  </div>
</template>

<script>
export default {
  name: 'activityType',
  components: {
    addType: () => import('@/components/addType')
  },
  data () {
    return {
      columns: [
        {title: '名称', dataIndex: 'name', key: 'name', align: 'center', width: '50px'},
        {title: '主题', dataIndex: 'details', key: 'details', align: 'center', width: '150px'},
        {title: '操作', key: 'operation', scopedSlots: {customRender: 'operation'}}
      ]
    }
  },
  methods: {
    open () {
      this.$refs.addType.open()
    }
  }
}
</script>

<style scoped>
  .nav {
    background-color: #fff;
    padding: 10px;
    box-shadow: 3px 3px 3px #ccc;
    border-radius: 5px;
    margin-bottom: 20px;
  }
</style>
