<template>
  <div>
    <div class="nav">
      <a-col style="margin-bottom: 10px">
        <a-button @click="open">
          <a-icon type="plus" />党员录入</a-button>
        <a-button>
          <a-icon type="download" />批量导入</a-button>
      </a-col>
      <span>按姓名：</span>
      <a-input-search placeholder="请输入查询名字" style="width:190px;"></a-input-search>
      <span>按日期：</span>
      <a-date-picker placeholder="请选择查询日期" @change="onChange" />
    </div>
    <div class="bar">
      <a-table bordered :dataSource="dataSource" rowKey="id" :columns="columns" size="small" :customRow="row" :loading="loading">
        <template slot="other" slot-scope="text, record">
          <a @click="showDialog(record)">
            <a-icon type="search" style="font-weight: bold;font-size: 20px;color: green" /></a>
          <a-divider type="vertical"></a-divider>
          <a @click="showDialog(record, 'edit')">
            <a-icon type="edit" style="font-weight: bold;font-size: 20px" /></a>
          <a-divider type="vertical"></a-divider>
          <a-popconfirm title="确定删除吗?" @confirm="() => onDelete(record)">
            <a>
              <a-icon type="close-circle" style="font-weight: bold;font-size: 20px;color: red" /></a>
          </a-popconfirm>
          <a-divider type="vertical"></a-divider>
          <a-switch defaultChecked size="small" />
        </template>
        <template slot="class" slot-scope="text,record">
          {{record.clazz ? record.clazz.code : ''}}
        </template>
      </a-table>
    </div>
    <edit-table :data=data ref="edit"></edit-table>
    <info-table ref="info" @refresh="getAllUsers"></info-table>
  </div>
</template>

<script>
export default {
  name: 'information',
  components: {
    editTable: () => import('@/components/editTable'),
    infoTable: () => import('@/components/infoTable')
  },
  data () {
    return {
      dataSource: [
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '副书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '书记' },
        { index: '1', name: '张三', part: '调研部', class: '160502', brief: '书记' }
      ],
      columns: [
        { title: '序号', dataIndex: 'index', width: '50px', align: 'center' },
        { title: '学号/教工号', dataIndex: 'userName', key: 'userName', width: '100px', align: 'center' },
        { title: '名字', dataIndex: 'trueName', width: '100px', align: 'center' },
        {title: '籍贯', dataIndex: 'homeTown', key: 'homeTown', width: '80px', align: 'center'},
        {title: '民族', dataIndex: 'nation', key: 'nation', width: '50px', align: 'center'},
        {title: '性别', dataIndex: 'sex', key: 'sex', width: '50px', align: 'center'},
        { title: '部门', dataIndex: 'dept', width: '100px', align: 'center' },
        { title: '班级', dataIndex: 'class', width: '100px', align: 'center', scopedSlots: {customRender: 'class'} },
        { title: '职位', dataIndex: 'currentPosition', width: '100px', align: 'center' },
        {title: '联系电话', dataIndex: 'phone', key: 'phone', width: '120px', align: 'center'},
        {title: 'QQ/微信号', dataIndex: 'account', key: 'account', width: '100px', align: 'center'},
        {title: '冻结', dataIndex: 'valid', key: 'valid', width: '50px', align: 'center'},
        { title: '操作', dataIndex: 'other', scopedSlots: { customRender: 'other' } },
        {}
      ],
      page: {
      },
      data: [],
      loading: false
    }
  },
  methods: {
    onChange (date, dateString) {
      console.log(date, dateString)
    },
    showDialog (val, val2) {
      console.log('val:', val, val2)
      this.$refs['edit'].showModal(val, val2)
    },
    open () {
      console.log(132)
      console.log('点了:', this.$refs['info'])
      this.$refs['info'].open()
    },
    show (data) {
      // todo 将弹框方法写在这里
      alert('123')
    },
    // 双击出弹框
    row: (record) => {
      return {
        on: {
          dblclick: () => {
            this.a.methods.show(record)
          }
        }
      }
    },
    getAllUsers () {
      this.loading = true
      this.$my_get('/user/user_list').then(res => {
        this.dataSource = res.data
      })
      this.loading = false
    },
    onDelete (data) {
      this.$post('/user/delete_user?id=' + data.id).then(res => {
        if (res.success) {
          this.$message.success('删除成功')
          this.getAllUsers()
        } else {
          this.$message.error(res.message)
        }
      })
    }
  },
  mounted () {
    this.getAllUsers()
  }
}
</script>

<style  scoped>
* {
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
