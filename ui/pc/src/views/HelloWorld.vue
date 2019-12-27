<template>
  <div class="myindex">
    <div class="mytop">
      <div class="LBT">
        <div style="width:100%;">
          <a-carousel autoplay  style="width:100%;height: 400px;">
            <div><img src="@/assets/2.jpg" alt="" width="100%" height="100%"></div>
            <div><img src="@/assets/1.jpg" alt="" width="100%" height="100%"></div>
            <div><img src="@/assets/5.jpg" alt="" width="100%" height="100%"></div>
            <div><img src="@/assets/4.jpg" alt="" width="100%" height="100%"></div>
          </a-carousel>
        </div>
      </div>
      <div class="Message">
        <div class="title">
          <div>学院动态</div>
          <div>更多...</div>
        </div>
        <div class="MesList">
          <div v-for="(res,index) in 7" :key="index" class="mlist">
            <div class="listText">
              <span><a-icon type="forward" width="4em" /></span>
              <span>数学与计算科学学院开展“不忘初心、牢记使命”主题教育系列党课</span>
            </div>
            <div >[2019-12-26]</div>
          </div>
        </div>
      </div>
    </div>
    <div class="myContent">
      <div class="Message2">
        <div class="title">
          <div>学院动态</div>
          <div>更多...</div>
        </div>
        <div class="MesList">
          <div v-for="(res,index) in 7" :key="index" class="mlist">
            <div class="listText">
              <span><a-icon type="forward" width="4em" /></span>
              <span>数学与计算科学学院开展“不忘初心、牢记使命”主题教育系列党课</span>
            </div>
            <div >[2019-12-26]</div>
          </div>
        </div>
      </div>
      <div class="Message2">
        <div class="title">
          <div>学院动态</div>
          <div>更多...</div>
        </div>
        <div class="MesList">
          <div v-for="(res,index) in 7" :key="index" class="mlist">
            <div class="listText">
              <span><a-icon type="forward" width="4em" /></span>
              <span>数学与计算科学学院开展“不忘初心、牢记使命”主题教育系列党课</span>
            </div>
            <div >[2019-12-26]</div>
          </div>
        </div>
      </div>
      <div class="img"></div>
    </div>
    <div class="bot">
      <div>
        联系地址:广东省江门市蓬江区迎宾大道中99号  邮编:529020  办公室电话:07503296590|07503296591  联系邮箱:math@mail.wyu.com
      </div>
      <div>版权所有 © 五邑大学 数学与计算科学学院  粤ICP备15096031号</div>
      <div>登录管理</div>
      <div>访问次数：0000290938</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      data: [
        {title: 'Ant Design Title 1'}
      ]
    }
  },
  methods: {
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
.myindex{
  height:100%;
  /*padding-bottom:50px ;*/
  /* background:#fff; */
  width: 100% ;
  overflow: hidden;
  overflow-y: scroll;
  background:-moz-linear-gradient(top, #ea4d4f,#5c2929);
}
.img{
  float:right;
  width: 33.33%;
  background-image: url('../assets/bgc.jpg');
  background-size: 100% 100%;
}
.mytop {
  display: flex;
  width: 100%;
  /*position: relative;*/
  height: 400px;
}
.LBT{
  width: 33.33%;
}
.Message{
  width: 33.33%;
  padding:0 10px;
}
.Message2{
  width: 33.33%;
  padding: 0 1%;
}
.title{
  display: flex;
  padding: 0 15px;
  justify-content: space-between;
  line-height: 40px;
  background-color: #f2f2f2f2;
}
.MesList{
  height: 350px;
  overflow: hidden;
  overflow-y: scroll;
}
.MesList::-webkit-scrollbar {
  display: none;
}
/*.MesList ul{*/
/*  padding-left: 25px;*/
/*}*/
.ant-carousel >>> .slick-slide {
  text-align: center;
  height: 350px;
  line-height: 160px;
  background: #364d79;
  width: 500px;
  overflow: hidden;
}
.myContent{
  display: flex;
  width: 100%;
  margin-top: 10px;
}
.mlist{
  width: 100%;
  line-height: 45px;
  display: flex;
  justify-content: space-between;
}
.listText{
  width: 75%;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.bot{
  text-align: center;
}
.bot div{
  line-height: 30px;
}
</style>
