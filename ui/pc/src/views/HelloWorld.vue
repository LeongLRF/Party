<template>
  <div style="height:100%;background:#fff">
    <h1>欢迎您，现在时间是：<span style="color: #e2151f">{{time}}</span></h1>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      time: 'new Date().toLocal'
    }
  },
  methods: {
    getTime (date) {
      var Year = date.getFullYear()
      var Month = date.getMonth() + 1
      var Dates = date.getDate()
      var week = date.getDay()
      let h = date.getHours()
      h = h < 10 ? ('0' + h) : h
      let m = date.getMinutes()
      m = m < 10 ? ('0' + m) : m
      let s = date.getSeconds()
      s = s < 10 ? ('0' + s) : s
      var weeks = ['日', '一', '二', '三', '四', '五', '六']
      var getWeek = '星期' + weeks[week]
      this.time = Year + '年' + Month + '月' + Dates + '日' + getWeek + ' ' + h + ':' + m + ':' + s
    },
    nowTimes () {
      this.getTime(new Date())
      this.timer = setInterval(this.nowTimes, 1000)
    }

  },
  mounted () {
    // this.nowTimes()
  },
  beforeDestroy () {
    // if (this.timer) {
    //   console.log('123执行l')
    //   clearInterval(this.timer) // 清除我们的定时器
    // }
  }

}
</script>

<style scoped>
h1 {
  font-weight: normal;
  padding: 20px;
}
</style>
