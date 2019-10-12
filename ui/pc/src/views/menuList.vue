<template>
  <div>
    <div class="nav">
      <a-button><a-icon type="plus"/>添加菜单</a-button>
    </div>
    <div style="background-color:#fff;margin-top: 20px">
      <a-table bordered :columns="columns" :dataSource="dataSource" :pagination="pagination" size="small">
        <span slot="operation">
          <a href="#"><a-icon type="edit" class="font-default" /></a>
        <a-divider type="vertical"></a-divider>
          <a href="#"><a-icon type="close-circle" class="font-danger" /></a>
           <a-divider type="vertical"></a-divider>
          <a-switch checked size="small"></a-switch>
      </span>
      <span slot="icon" slot-scope="text,record">
        <a-icon :type="text" class="font-default"></a-icon>
      </span>
        <span slot="valid" slot-scope="text,record">
          {{record.valid ? '是' : '否'}}
        </span>
      </a-table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'menuList',
  data () {
    return {
      columns: [
        {title: '序号', dataIndex: 'index', align: 'center', width: '50px'},
        {title: '编号', dataIndex: 'code', key: 'code', align: 'center', width: '50px'},
        {title: '菜单名', dataIndex: 'name', key: 'name', width: '110px', align: 'center'},
        {title: '路径', dataIndex: 'url', key: 'url', width: '100px', align: 'left'},
        {title: '使用权限', dataIndex: 'permission', key: 'permission', width: '200px', align: 'center'},
        {title: '父菜单', dataIndex: 'parent', key: 'parent', width: '250px', align: 'center', scopedSlots: {customRender: 'parent'}},
        {title: '图标', dataIndex: 'icon', key: 'icon', width: '50px', align: 'center', scopedSlots: {customRender: 'icon'}},
        {title: '启用', dataIndex: 'valid', key: 'valid', width: '50px', align: 'center', scopedSlots: {customRender: 'valid'}},
        {title: '操作', dataIndex: 'operation', key: 'operation', scopedSlots: {customRender: 'operation'}}
      ],
      dataSource: []
    }
  },
  methods: {
  },
  mounted () {
    this.$my_get('/sys/all_menu').then(res => {
      this.dataSource = res.data
    })
  }
}
</script>

<style scoped>
  *{
    margin: 0;
  }
  .nav {
    background-color: #fff;
    padding: 10px;
    box-shadow: 3px 3px 3px #ccc;
    border-radius: 5px;
  }
</style>
