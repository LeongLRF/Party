<template>
  <div>
    <div class="nav">
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
      <a-table bordered :dataSource="dataSource" rowKey="id" :columns="columns" size="small" :customRow="row">

      </a-table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'tai',
  components: {

  },
  data () {
    return {
      dataSource: [

      ],
      columns: [
        { title: '序号', dataIndex: 'index', width: '50px', align: 'center' },
        { title: '学号/教工号', dataIndex: 'userName', key: 'userName', width: '100px', align: 'center' },
        { title: '名字', dataIndex: 'name', width: '100px', align: 'center' },
        { title: '部门', dataIndex: 'dept', width: '100px', align: 'center' },
        { title: '班级', dataIndex: 'class', width: '100px', align: 'center' },
        { title: '职位', dataIndex: 'brief', width: '100px', align: 'center' },
        { title: '操作', dataIndex: 'other', scopedSlots: { customRender: 'other' } }
      ],
      page: {
      },
      data: []
    }
  },
  methods: {
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
