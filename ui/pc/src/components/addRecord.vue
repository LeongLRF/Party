<template>
  <div>
    <a-modal title="台账录入" :visible="visible" @ok="handelOk" @cancel="handelCancel" :width="700">
      <a-row type="flex" justify="right">
        <a-col :sapn="11">
          <a-row>
            <span>时间：</span>
            <a-date-picker @change="change"></a-date-picker>
          </a-row>
         <a-row>
           <span>活动类别：</span>
           <a-input-search placeholder="input search text" @search="onSearch" style="width: 50%">
             <a-button slot="enterButton">Custom</a-button>
           </a-input-search>
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
        theme: '',
        content: '',
        place: '',
        holder: '',
        speaker: '',
        remark: '',
        hours: 0,
        ids: [1, 2]
      }
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
    }
  },
  change () {}
}
</script>

<style scoped>
</style>
