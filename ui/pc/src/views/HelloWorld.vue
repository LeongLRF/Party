<template>
  <div class="myindex">
    <div class="mytop">
      <div class="LBT">
        <div style="width:100%;">
          <a-carousel autoplay  style="width:100%;height: 500px;">
            <div><h3 >1</h3></div>
            <div><h3>2</h3></div>
            <div><h3>3</h3></div>
            <div><h3>4</h3></div>
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
  padding-bottom:50px ;
  background:#fff;
  width: 100% ;
  overflow: hidden;
  overflow-y: scroll;
}
.mytop {
  display: flex;
  width: 100%;
  position: relative;
  height: 400px;
}
.LBT{
  padding-left: 10px;
  width: 50%;
}
.Message{
  width: 50%;
  padding:0 10px;
}
.Message2{
  padding:0 5px;
}
.title{
  display: flex;
  padding: 0 5px;
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
  height: 400px;
  line-height: 160px;
  background: #364d79;
  width: 500px;
  overflow: hidden;
}
.myContent{
  width: 850px;
  display: flex;
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
</style>
