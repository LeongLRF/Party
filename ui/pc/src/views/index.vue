<template>
  <div>
    123
  </div>
</template>
<script>
export default {
  name: 'index',
  data () {
    return {
    }
  },
  mounted () {
    this.$my_get('/sys/current_user').then(res => {
      console.log(res.data)
    })
  }
}
</script>
<style></style>
