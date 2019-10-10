<template>
  <div>
    <div class="nav">
      <a-button type='primary'>
        <a-icon type="plus" />新增</a-button>
    </div>
    <div class="bar">
      <a-table bordered :dataSource="dataSource" rowKey="id" :columns="columns" size="small">
        <!-- <template slot="other" slot-scope="text, record">
          <a-button type="primary" @click="showDialog(record)" style="margin-right: 10px">编辑</a-button>
          <a-popconfirm title="确定删除吗?" @confirm="() => onDelete(record)">
            <a-button type="primary" style="background:#F56C6C;border:1px solid #F56C6C">删除</a-button>
          </a-popconfirm>
        </template> -->
      </a-table>
    </div>
    <!-- <edit-table :data=data ref="edit"></edit-table> -->
  </div>
</template>

<script>
export default {
  name: 'mesManage',
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
  }
}
</script>

<style scoped>
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
