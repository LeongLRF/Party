<template>
  <div>
    <div class="nav">
        <a-col style="margin-bottom: 10px">
          <a-button ><a-icon type="plus" />台账录入</a-button>
          <a-button ><a-icon type="download" />批量导入</a-button>
        </a-col>
      <a-col style="margin-bottom: 10px">
        <span>按日期：</span>
        <a-range-picker @change="onChange" />
      </a-col>
      <a-col>
        <span>类型：</span>
        <a-select style="width: 5%" defaultValue="123" size="default">
          <a-select-option value="123">123</a-select-option>
        </a-select>
      </a-col>
    </div>
    <div class="bar">
      <a-table bordered :dataSource="dataSource" rowKey="id" :columns="columns" size="small">
        <template slot="other" slot-scope="text, record" style="">
          <a  @click="show(record)"><a-icon type="search" style="font-weight: bold;font-size: 20px;color: green;" /></a>
          <a-divider type="vertical"></a-divider>
          <a  @click="showDialog(record)"><a-icon type="edit" style="font-weight: bold;font-size: 20px" /></a>
          <a-divider type="vertical"></a-divider>
          <a-popconfirm title="确定删除吗?" @confirm="() => onDelete(record)">
            <a ><a-icon type="close-circle" style="font-weight: bold;font-size: 20px;color: red"/></a>
          </a-popconfirm>
          <a-divider type="vertical"></a-divider>
          <a-switch defaultChecked size="small"/>
        </template>
      </a-table>
    </div>
    <edit-table :data=data ref="edit"></edit-table>
  </div>
</template>

<script>
export default {
  name: 'taiManage',
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
        { title: '序号', dataIndex: 'index', width: '20px', align: 'center' },
        { title: '日期', dataIndex: 'start', width: '80px', align: 'center' },
        { title: '大类', dataIndex: 'type', width: '80px', align: 'center' },
        { title: '方式', dataIndex: 'way', width: '50px', align: 'center' },
        { title: '主题分类', dataIndex: 'theme', width: '60px', align: 'center' },
        { title: '内容', dataIndex: 'content', width: '80px', align: 'center' },
        { title: '地点', dataIndex: 'place', width: '40px', align: 'center' },
        { title: '组织单位', dataIndex: 'dept', width: '60px', align: 'center' },
        { title: '主持人', dataIndex: 'holder', width: '40px', align: 'center' },
        { title: '讲课人', dataIndex: 'speaker', width: '40px', align: 'center' },
        { title: '参加人员', dataIndex: 'member', width: '80px', align: 'center' },
        { title: '参加人员备注', dataIndex: 'remark', width: '80px', align: 'center' },
        { title: '操作', dataIndex: 'other', scopedSlots: { customRender: 'other' }, width: '80px', align: 'center' }
      ],
      page: {
      },
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
    }
  }
}
</script>

<style  scoped>
  *{
    /*padding: 0;*/
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
  }
</style>
