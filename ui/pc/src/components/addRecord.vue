<template>
  <div>
    <a-modal title="台账录入" :visible="visible" @ok="handelOk" @cancel="handelCancel" :width="700" :destroyOnClose="true">
      <div>
        <div style="display:flex">
          <a-row class="form_item">
            <span style="margin-left:36px">时间：</span>
            <a-date-picker style="width:220px"></a-date-picker>
          </a-row>
          <a-row class="form_item">
            <span style="margin-left:36px">方式：</span>
            <a-select v-model="activity.way" style="width:220px" @change="handleChange">
              <a-select-option value="上课" key="上课">上课</a-select-option>
              <a-select-option value="观看影片" key="观看影片">观看影片</a-select-option>
            </a-select>
          </a-row>
        </div>
        <div style="display:flex">
          <a-row class="form_item">
            <span style="margin-left:8px">活动类别：</span>
            <a-select v-model="activity.typeId" style="width:220px" @change="selectItem" placeholder="请选择活动类别">
              <a-select-option v-for="item in types" :key="item.id" :value="item.id">{{item.name}}</a-select-option>
            </a-select>
            <div style="margin-left:80px">
              <a-select v-model="theme" :open="false" mode="tags" style="width: 130px" disabled></a-select>
            </div>
            <a-button>添加主题</a-button>
          </a-row>
        </div>
        <div style="display: flex">
          <a-row class="form_item">
            <span style="margin-left:8px">组织单位：</span>
            <div style="flex:15">
              <a-select v-model="activity.deptId" style="width:220px" @change="handleChange" placeholder="请选择组织单位">
                 <a-select-option value="0" key="上课">上课</a-select-option>
                <a-select-option value="1" key="观看影片">观看影片</a-select-option>
              </a-select>
            </div>
            <span style="margin-left:10px">参加人员：</span>
            <a-select style="width: 220px" placeholder="请选择参加人员" mode="tags" v-model="name">
              <a-select-option v-for="(user) in takePart" :key="user.id" :value="user.trueName">{{user.trueName}}</a-select-option>
            </a-select>
          </a-row>
        </div>
        <a-row class="form_item">
          <span class="name">活动内容：</span>
          <div style="flex:15">
            <a-textarea v-model="activity.content" placeholder="Basic usage" :rows="4" />
          </div>
        </a-row>
        <a-row class="form_item">
          <span class="name">地点：</span>
          <div style="flex:15">
            <a-input placeholder="Basic usage" v-model="activity.place" />
          </div>
        </a-row>
        <a-row class="form_item">
          <span class="name">主持人：</span>
          <div style="flex:15">
            <a-input placeholder="Basic usage" v-model="activity.holder" />
          </div>
        </a-row>
        <a-row class="form_item">
          <span class="name">讲课人：</span>
          <div style="flex:15">
            <a-input placeholder="Basic usage" v-model="activity.speaker" />
          </div>
        </a-row>
        <a-row class="form_item">
          <span class="name">备注：</span>
          <div style="flex:15">
            <a-textarea v-model="activity.remark" placeholder="Basic usage" :rows="4" />
          </div>
        </a-row>
        <a-row class="form_item">
          <span class="name">学时：</span>
          <div style="flex:15">
            <a-input-number :min="1" :max="10" v-model="activity.hours" />
          </div>
        </a-row>
      </div>
    </a-modal>
  </div>
</template>

<script>
export default {
  name: 'addRecord',
  data () {
    return {
      visible: false,
      activity: {
        start: '2019-10-15 00:00:00',
        typeId: '请选择活动类别',
        way: null,
        content: null,
        place: null,
        holder: null,
        speaker: null,
        remark: null,
        deptId: null,
        hours: null,
        ids: [1]
      },
      takePart: [],
      types: [],
      theme: [],
      name: []
    }
  },
  methods: {
    handelOk () {
      console.log('参加人员', this.name)
      this.addRecord()
      this.activity = {}
      this.name = []
      this.theme = []
      this.visible = false
    },
    handelCancel () {
      this.visible = false
    },
    open () {
      this.visible = true
    },
    addRecord () {
      this.$post('/activity/add_activity', this.activity).then(res => {
        if (res.success) {
          this.$message.success('添加成功')
          this.$emit('refresh')
        } else {
          this.$message.error(res.message)
        }
      })
    },
    getTypes () {
      this.$my_get('/sys/type_list').then(res => {
        this.types = res.data
      })
    },
    selectItem (val) {
      console.log(val)
      const type = this.types.filter(item => item.id === val)[0]
      this.theme.length = 0
      type.details.forEach(res => {
        this.theme.push(res.name)
      })
    },
    handleChange () {
    },
    getUsers () {
      this.$my_get('/user/user_list').then(res => {
        console.log('before', this.takePart)
        this.takePart = res.data
        console.log('after', this.takePart)
      })
    }
  },
  mounted () {
    this.getTypes()
    this.getUsers()
  }
}
</script>

<style scoped>
.form_item {
  margin-bottom: 10px;
  display: flex;
}
.name {
  flex: 2;
  text-align: right;
}
</style>
