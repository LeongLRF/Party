<template>
  <div>
    <a-modal title="台账录入" :visible="visible" @ok="handelOk" @cancel="handelCancel" :width="700">
      <a-row type="flex">
        <a-col :sapn="11">
          <a-row class="form_item">
            <span>时间：</span>
            <a-date-picker></a-date-picker>
          </a-row>
         <a-row>
           <a-row class="form_item">
             <span>活动类别：</span>
             <a-select v-model="activity.typeId" style="width: 150px" @change="selectItem">
               <a-select-option v-for="item in types" :key="item.id" :value="item.id">{{item.name}}</a-select-option>
             </a-select>
           </a-row>
           <a-row class="form_item">
             <a-select v-model="theme" :open="false" mode="tags" style="width: 120px" disabled></a-select>
             <a-button>添加主题</a-button>
           </a-row>
           <a-row class="form_item">
             <span>方式:</span>
             <a-select v-model="activity.way" style="width: 120px;" @change="handleChange">
               <a-select-option value="上课" key="上课">上课</a-select-option>
               <a-select-option value="观看影片" key="观看影片">观看影片</a-select-option>
             </a-select>
           </a-row>
         </a-row>
        </a-col>
      </a-row>
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
        typeId: 0,
        way: '',
        type: '',
        content: '',
        place: '',
        holder: '',
        speaker: '',
        remark: '',
        hours: 0,
        ids: [1, 2]
      },
      types: [],
      theme: []
    }
  },
  methods: {
    handelOk () {
      this.addRecord()
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
    }
  },
  mounted () {
    this.getTypes()
  },
  activated () {
    this.getTypes()
  }
}
</script>

<style scoped>
  .form_item{
    margin-bottom: 10px;
  }
</style>
