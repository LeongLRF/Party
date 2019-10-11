<template>
  <div>
    <div class="nav">
      <a-col style="margin-bottom: 10px">
        <a-button><a-icon type="plus" />党员录入</a-button>
        <a-button><a-icon type="download" />批量导入</a-button>
      </a-col>
      <span>按姓名：</span>
        <a-input-search placeholder="请输入查询名字" style="width:190px;"></a-input-search>
      <span>按日期：</span>
        <a-date-picker placeholder="请选择查询日期" @change="onChange" />
    </div>
    <div class="bar">
      <a-table bordered :dataSource="dataSource" rowKey="id" :columns="columns" size="small" :customRow="row">
        <template slot="other" slot-scope="text, record">
          <a-button type="primary" @click="show(record)" style="background-color:green;">详情</a-button>
          <a-button type="primary" @click="showDialog(record)">编辑</a-button>
          <a-popconfirm title="确定删除吗?" @confirm="() => onDelete(record)">
            <a-button type="primary" style="background:#F56C6C;border:1px solid #F56C6C">删除</a-button>
          </a-popconfirm>
        </template>
      </a-table>
    </div>
    <edit-table :data=data ref="edit"></edit-table>
  </div>
</template>

<script>
export default {
  name: 'information',
  components: {
    editTable: () => import('@/components/editTable')
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
        { title: '名字', dataIndex: 'name', width: '100px', align: 'center' },
        { title: '部门', dataIndex: 'part', width: '100px', align: 'center' },
        { title: '班级', dataIndex: 'class', width: '100px', align: 'center' },
        { title: '职位', dataIndex: 'brief', width: '100px', align: 'center' },
        { title: '操作', dataIndex: 'other', scopedSlots: { customRender: 'other' }, width: '100px', align: 'center' }
      ],
      data: []
    }
  },
  methods: {
    onChange (date, dateString) {
      console.log(date, dateString)
    },
    showDialog (val) {
      console.log('val:', val)
      this.$refs['edit'].showModal()
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
    }
  }
}
</script>

<style  scoped>
.nav {
  background-color: #fff;
  padding: 10px;
  box-shadow: 3px 3px 3px #ccc;
}
.bar {
  background-color: #fff;
  margin-top: 20px;
  padding: 0 5px;
}
</style>
