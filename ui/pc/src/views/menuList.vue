<template>
  <div>
    <div class="nav">
      <a-button><a-icon type="plus"/>添加菜单</a-button>
    </div>
    <div style="background-color:#fff;margin-top: 20px">
      <a-table bordered :columns="columns" :dataSource="dataSource"  size="small" :loading="loading">
        <template v-for="(col,key) in ['code', 'name', 'url', 'permission', 'parent', 'icon']" :slot="col" slot-scope="text, record">
          <a-input
          v-if="record.editable"
          :value="text"
          style="margin: -5px 0"
          :key="key"
          />
          <span v-else :key="key">{{text}}</span>
        </template>
        <span slot="operation" slot-scope="text,record">
          <a v-if="!record.editable" @click="() => edit(record)"><a-icon type="edit" class="font-default" /></a>
          <a v-if="record.editable" @click="() => save(record)"><a-icon type="check" class="font-default" /></a>
        <a-divider type="vertical"></a-divider>
          <a-popconfirm title="是否删除" @confirm="() => deleteMenu(record)">
            <a-icon type="close-circle" class="font-danger" />
          </a-popconfirm>
           <a-divider type="vertical"></a-divider>
          <a-switch size="small" :checked="record.valid" @change="change(record)"></a-switch>
      </span>
      <span slot="icon" slot-scope="text">
        <a-icon :type="text" class="font-default"></a-icon>
      </span>
        <span slot="valid" slot-scope="text,record">
          {{record.valid ? '是' : '否'}}
        </span>
        <span slot="permission" slot-scope="text,record">
          <span v-for="(role, index) in record.roles" :key="index">
            {{role.name}}
          </span>
        </span>
        <span slot="parent" slot-scope="text,record">
          {{record.parent ? record.parent.name : ''}}
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
        {title: '编号', dataIndex: 'code', key: 'code', align: 'center', width: '50px', scopedSlots: {customRender: 'code'}},
        {title: '菜单名', dataIndex: 'name', key: 'name', width: '110px', align: 'center', scopedSlots: {customRender: 'name'}},
        {title: '路径', dataIndex: 'url', key: 'url', width: '100px', align: 'left', scopedSlots: {customRender: 'url'}},
        {title: '使用权限', dataIndex: 'permission', key: 'permission', width: '200px', align: 'center', scopedSlots: {customRender: 'permission'}},
        {title: '父菜单', dataIndex: 'parent', key: 'parent', width: '250px', align: 'center', scopedSlots: {customRender: 'parent'}},
        {title: '图标', dataIndex: 'icon', key: 'icon', width: '50px', align: 'center', scopedSlots: {customRender: 'icon'}},
        {title: '启用', dataIndex: 'valid', key: 'valid', width: '50px', align: 'center', scopedSlots: {customRender: 'valid'}},
        {title: '操作', dataIndex: 'operation', key: 'operation', scopedSlots: {customRender: 'operation'}}
      ],
      dataSource: [],
      loading: false
    }
  },
  methods: {
    getMenus () {
      this.loading = true
      this.$my_get('/sys/all_menu').then(res => {
        this.dataSource = res.data
        this.loading = false
      })
    },
    change (data) {
      data.valid = !data.valid
      console.log(data)
      this.$post('/sys/edit_menu', data).then(res => {
        if (res.success) {
          this.$message.success('修改成功')
          this.getMenus()
        } else {
          this.$message.error(res.message)
        }
      })
    },
    deleteMenu (data) {
      this.$post('/sys/delete_menu?id=' + data.id).then(res => {
        if (res.success) {
          this.$message.success('删除成功,请重新登录')
          this.$router.push('/login')
        } else {
          this.$message.error(res.message)
        }
      })
    },
    edit (key) {
      const newData = [...this.dataSource]
      console.log(newData)
      const target = newData.find(item => item.id === key.id)
      console.log(target)
      if (target) {
        target.editable = true
        this.dataSource = newData
      }
    },
    save (data) {
      const newData = [...this.dataSource]
      const target = newData.find(item => item.id === data.id)
      if (target) {
        target.editable = false
        this.dataSource = newData
      }
    }
  },
  mounted () {
    this.getMenus()
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
