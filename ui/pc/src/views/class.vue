<template>
  <div>
    <div class="nav">
      <a-button><a-icon type="plus"/>添加班级</a-button>
    </div>
    <div class="bar">
      <a-table :dataSource="dataSource" :columns="columns" style="width: 50%" size="small" :loading="loading"></a-table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'class',
  data () {
    return {
      columns: [
        {title: '序号', dataIndex: 'index', key: 'index', width: '50px'},
        {title: '班级号', dataIndex: 'code', key: 'code', width: '80px'},
        {title: '班级名称', dataIndex: 'name', key: 'name', width: '200px'},
        {title: '班级专业', dataIndex: 'major', key: 'major', width: '200px'},
        {title: '人数', dataIndex: 'total', key: 'total', width: '50px'},
        {title: '班导师', dataIndex: 'teacher', key: 'teacher', width: '80px'},
        {title: '操作', scopedSlots: {customRender: 'operation'}}
      ],
      dataSource: [],
      loading: false
    }
  },
  methods: {
    getClazz () {
      this.loading = true
      this.$my_get('/sys/clazz_list').then(res => {
        this.dataSource = res.data
        this.loading = false
      })
    }
  },
  mounted () {
    this.getClazz()
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
