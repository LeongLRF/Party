<template>
  <div>
    <a-modal :title="edit ? '修改活动类型' : '添加活动类型'" :visible="visible" @ok="handleOk" @cancel="handleCancel">
      <span>活动类别:</span>
      <a-input style="width: 20%" v-model="type.name"></a-input>
      <span>活动主题:</span>
      <a-select
        mode="tags"
        placeholder="Please select"
        v-model="defaultValue"
        style="width: 160px"
        :open="false"
      >
      </a-select>
      <a-button @click="add">添加</a-button>
    </a-modal>
    <a-modal title="请输入主题" @ok="handleAdd" @cancel="handleCan" :visible="visible2">
      <span>主题名称:</span>
      <a-input style="width: 30%" v-model="name"></a-input>
    </a-modal>
  </div>
</template>

<script>
export default {
  name: 'addType',
  data () {
    return {
      visible: false,
      edit: false,
      type: {
        name: '',
        details: []
      },
      visible2: false,
      defaultValue: [],
      name: ''
    }
  },
  methods: {
    handleOk () {
      this.defaultValue.forEach(it => {
        this.type.details.push({
          name: it
        })
      })
      this.$post('/sys/add_type', this.type).then(res => {
        if (res.success) {
          this.$message.success('添加成功')
        } else {
          this.$message.error(res.message)
        }
      })
      this.visible = false
    },
    handleCancel () {
      this.visible = false
    },
    open (data, edit) {
      this.visible = true
    },
    handleAdd () {
      this.defaultValue.push(this.name)
      this.visible2 = false
      console.log(this.defaultValue)
    },
    handleCan () {
      this.visible2 = false
    },
    add () {
      console.log('点击了')
      this.visible2 = true
    },
    popupScroll () {
      console.log('popupScroll')
    }
  }
}
</script>

<style scoped>
</style>
