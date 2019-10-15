<template>
  <div>
    <a-modal title="台账录入" :visible="visible" @ok="handelOk" @cancel="handelCancel" :width="700"></a-modal>
  </div>
</template>

<script>
export default {
  name: 'addRecord',
  data () {
    return {
      visible: false
    }
  },
  methods: {
    handelOk () {
      this.visible = false
    },
    handelCancel () {
      this.visible = false
    },
    open () {
      this.visible = true
    }
  }
}
</script>

<style scoped>
</style>
