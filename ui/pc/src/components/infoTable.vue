<template>
  <div>
    <a-modal title="党员录入" :visible="visible" @ok="handleOk" @cancel="handleCancel" :width=750>
      <h1>党员录入</h1>
      </a-modal>
  </div>
</template>

<script>
export default {
  name: 'infoTable',
  data () {
    return {
      visible: false
    }
  },
  methods: {
    open () {
      this.visible = true
    },
    handleOk (e) {
      this.visible = false
    },
    handleCancel (e) {
      console.log('Clicked cancel button')
      this.visible = false
    }
  }
}
</script>

<style  scoped>

</style>
