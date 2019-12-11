<template>
  <div>
    <a-modal
    title="添加班级"
    :visible="visible"
    @ok="handleOk"
    @cancel="handleCancel"
    >
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
    }
  }
}
</script>

<style scoped>
</style>
