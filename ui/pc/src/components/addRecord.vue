<template>
  <div>
    <a-modal title="台账录入" :visible="visible" @ok="handelOk" @cancel="handelCancel" :width="700">
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
  }
}
</script>

<style scoped>
</style>
