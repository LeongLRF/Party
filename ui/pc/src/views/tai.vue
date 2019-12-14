<template>
  <div>
    <div class="nav">
      <a-col style="margin-bottom: 10px">
        <a-button @click="open()"><a-icon type="plus" />台账录入</a-button>
        <a-button ><a-icon type="download" />批量导入</a-button>
      </a-col>
      <div>
        <span>所在支部：</span>
        <a-radio-group defaultValue="a" buttonStyle="solid">
          <a-radio-button value="a">第一支部</a-radio-button>
          <a-radio-button value="b">第二支部</a-radio-button>
        </a-radio-group>
        <span style="margin-left:45px">党内职务：</span>
        <a-select defaultValue="a1" style="width: 200px" @change="handleChange">
          <a-select-option v-for="i in 5" :key="(i + 9).toString(36) + i">
            {{(i + 9).toString(36) + i}}
          </a-select-option>
        </a-select>
        <span style="margin-left:20px">党员姓名：</span>
        <a-select defaultValue="a1" style="width: 200px" @change="handleChange">
          <a-select-option v-for="i in 25" :key="(i + 9).toString(36) + i">
            {{(i + 9).toString(36) + i}}
          </a-select-option>
        </a-select>
      </div>
      <div style="margin:10px 0">
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;大类：</span>
        <a-radio-group defaultValue="a" buttonStyle="solid">
          <a-radio-button value="a">学习类</a-radio-button>
          <a-radio-button value="b">活动类</a-radio-button>
          <a-radio-button value="c">其他</a-radio-button>
        </a-radio-group>
        <span style="margin-left:43px">类别：</span>
        <a-select defaultValue="k11" style="width: 200px" @change="handleChange">
          <a-select-option v-for="i in 10" :key="(i + 9).toString(36) + i">
            {{(i + 9).toString(36) + i}}
          </a-select-option>
        </a-select>
        <span style="margin-left:48px">方式：</span>
        <a-select defaultValue="m24" style="width: 200px" @change="handleChange">
          <a-select-option v-for="i in 25" :key="(i + 9).toString(36) + i">
            {{(i + 9).toString(36) + i}}
          </a-select-option>
        </a-select>
      </div>
    </div>
    <div class="bar">
      <a-table bordered :dataSource="dataSource" rowKey="id" :columns="columns" size="small" :loading="loading">
        <template slot="type" slot-scope="text,record">
          <span>{{record.type.name ? record.type.name : '' }}</span>
        </template>
        <template slot="theme" slot-scope="text,record">
          <span v-for="(item, index) in record.type.details" :key="index">
            {{item.name ? item.name : ''}}
          </span>
        </template>
        <template slot="other" slot-scope="text,record">
          <a-popconfirm title="确定删除吗?" @confirm="() => onDelete(record)">
            <a><a-icon type="close-circle" style="font-weight: bold;font-size: 20px;color: red" /></a>
          </a-popconfirm>
        </template>
        <template slot="takePart" slot-scope="text,record">
          <span v-for="(item, index) in record.takeParts" :key="index">
            {{item.users ? item.users.trueName &nbsp; : ''}}
          </span>
        </template>
        <template slot="start" slot-scope="text">
          {{$getyyyyMMdd(new Date(text),0,false)}}
        </template>
      </a-table>
    </div>
    <add-record ref="addRecord" @refresh="getActivity"></add-record>
  </div>
</template>

<script>
export default {
  name: 'tai',
  components: {
    addRecord: () => import('@/components/addRecord')
  },
  data () {
    return {
      dataSource: [

      ],
      columns: [
        { title: '序号', dataIndex: 'index', width: '60px', align: 'center' },
        { title: '日期', dataIndex: 'start', width: '100px', align: 'center', scopedSlots: {customRender: 'start'} },
        { title: '大类', dataIndex: 'type', width: '80px', align: 'center', scopedSlots: {customRender: 'type'} },
        { title: '方式', dataIndex: 'way', width: '120px', align: 'center' },
        { title: '主题分类', dataIndex: 'theme', width: '120px', align: 'center', scopedSlots: {customRender: 'theme'} },
        { title: '内容', dataIndex: 'content', width: '250px', align: 'center' },
        { title: '地点', dataIndex: 'place', width: '80px', align: 'center' },
        { title: '组织单位', dataIndex: 'dept', width: '80px', align: 'center' },
        { title: '主持人', dataIndex: 'holder', width: '70px', align: 'center' },
        { title: '讲课人', dataIndex: 'speaker', width: '70px', align: 'center' },
        { title: '参加人员', dataIndex: 'member', width: '200px', align: 'center', scopedSlots: {customRender: 'takePart'} },
        { title: '参加人员备注', dataIndex: 'remark', width: '120px', align: 'center' },
        { title: '操作', dataIndex: 'other', scopedSlots: { customRender: 'other' }, width: '100px', align: 'left' },
        {}
      ],
      page: {
      },
      data: [],
      loading: false
    }
  },
  methods: {
    open () {
      console.log('123')
      this.$refs.addRecord.open()
    },
    handleChange () {

    },
    getActivity () {
      this.loading = true
      this.$my_get('/activity/activity_list').then(res => {
        this.dataSource = res.data
        this.loading = false
      })
      console.log('获取台账')
    },
    onDelete (data) {
      this.$post('/activity/delete_activity?activityId=' + data.id).then(res => {
        if (res.success) {
          this.getActivity()
          this.$message.success('删除成功')
        } else {
          this.$message.error(res.message)
        }
      })
    }
  },
  mounted () {
    this.getActivity()
  }
}
</script>

<style  scoped>
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
