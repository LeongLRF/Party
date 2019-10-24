<template>
  <div>
    <div class="nav">
      <a-button type='primary' @click="open">
        <a-icon type="plus" />新增</a-button>
    </div>
    <div class="bar">
      <a-table :dataSource="dataSource"  :columns="columns" style="width: 30%;background-color:#fff;" size="small" :loading="loading">
      <span slot="details" slot-scope="text,record">
        <span v-for="(item, index) in record.details" :key="index">
          {{item.name &nbsp;}}
        </span>
      </span>
        <span slot="operation" slot-scope="text,record">
          <a>
            <a-icon type="edit" style="font-weight: bold;font-size: 20px" /></a>
          <a-divider type="vertical"></a-divider>
          <a-popconfirm title="确定删除吗?">
            <a>
              <a-icon type="close-circle" style="font-weight: bold;font-size: 20px;color: red" /></a>
          </a-popconfirm>
        </span>
      </a-table>
    </div>
    <add-type ref="addType" @refresh="getType"></add-type>
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
        {title: '名称', dataIndex: 'name', key: 'name', align: 'center', width: '80px'},
        {title: '主题', dataIndex: 'details', key: 'details', align: 'center', width: '250px', scopedSlots: {customRender: 'details'}},
        {title: '操作', key: 'operation', scopedSlots: {customRender: 'operation'}}
      ],
      dataSource: [],
      loading: false
    }
  },
  methods: {
    open () {
      this.$refs.addType.open()
    },
    getType () {
      this.loading = true
      this.$my_get('/sys/type_list').then(res => {
        this.dataSource = res.data
        this.loading = false
      })
    }
  },
  mounted () {
    this.getType()
  }
}
</script>

<style scoped>
  * {
    margin: 0;
  }
  .nav {
    background-color: #fff;
    padding: 10px;
    box-shadow: 3px 3px 3px #ccc;
    border-radius: 5px;
    margin-bottom: 20px;
  }
  .bar {
    background-color: #fff;
    margin-top: 20px;
    padding: 0 5px;
    text-align: left !important;
  }
</style>
