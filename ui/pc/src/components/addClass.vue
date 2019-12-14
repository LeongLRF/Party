<template>
  <div>
    <a-modal
    title="添加班级"
    :visible="visible"
    @ok="handleOk"
    @cancel="handleCancel"
    width="700px"
    >
      <a-row type="flex" justify="space-between">
        <a-col :sapn="3">
          <span>班级号</span>
          <a-input placeholer="请输入班级号" style="width: 50%"></a-input>
        </a-col>
        <a-col :sapn="3">
          <span>班级号</span>
          <a-input placeholer="请输入班级号" style="width: 50%"></a-input>
        </a-col>
        <a-col :sapn="3">
          <span>班级号</span>
          <a-input placeholer="请输入班级号" style="width: 50%"></a-input>
        </a-col>
      </a-row>
    </a-modal>
  </div>
</template>

<script>
export default {
  name: 'addClass',
  data () {
    return {
      visible: false
    }
  },
  methods: {
    open () {
      this.visible = true
    },
    handleCancel () {
      this.visible = false
    },
    handleOk () {
      this.visible = false
    }
  }
}
</script>

<style scoped>
</style>
