<template>
  <div>
    <div class="nav">
      <a-button><a-icon type="plus"/>添加角色</a-button>
    </div>
    <div class="bar">
      <a-table :dataSource="roles" bordered :columns="columns" style="width: 50%" size="small" :loading="loading">
        <template slot="operator" slot-scope="text,record">
        </template>
      </a-table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'role',
  data () {
    return {
      columns: [
        {title: '序号', dataIndex: 'index', key: 'index', width: '50px', align: 'center'},
        {title: '角色名称', dataIndex: 'name', key: 'name', width: '100px', align: 'center'},
        {title: '启用', dataIndex: 'valid', key: 'valid', width: '50px', scopedSlots: {customRender: 'valid'}, align: 'center'},
        {title: '操作', key: 'operation', scopedSlots: {customRender: 'operation'}}
      ],
      roles: [],
      loading: false
    }
  },
  methods: {
    getRoles () {
      this.loading = true
      this.$my_get('/sys/role_list').then(res => {
        this.roles = res.data
        this.loading = false
      })
    }
  },
  mounted () {
    this.getRoles()
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
  .bar {
    background-color: #fff;
    margin-top: 20px;
    padding: 0 5px;
    text-align: left !important;
  }
</style>
