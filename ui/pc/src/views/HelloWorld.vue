<template>
  <div style="background:#fff">
      <a-row>
        <a-row>
          <a-col :span="11">
            <a-carousel :afterChange="onChange" style="width: 90%;margin: 20px;height: 350px">
              <div><h3>1</h3></div>
              <div><h3>2</h3></div>
              <div><h3>3</h3></div>
              <div><h3>4</h3></div>
            </a-carousel>
          </a-col>
          <a-col :span="11">
            <a-list :dataSource="data" style="margin: 20px 20px 10px 30px; width: 80%">
              <a-list-item slot="renderItem" slot-scope="item, index"><a href="">{{item}}</a></a-list-item>
              <div slot="header" style="font-size: 20px; font-weight: bold">校内资讯&nbsp;<a-icon type="bars" /></div>
            </a-list>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-list :dataSource="data" style="margin: 30px 20px 70px 10px; width: 80%">
              <a-list-item slot="renderItem" slot-scope="item, index">{{item}}</a-list-item>
              <div slot="header" style="font-size: 20px; font-weight: bold">学校通知&nbsp;<a-icon type="bars" /></div>
            </a-list>
          </a-col>
          <a-col :span="12">
            <a-list :dataSource="data" style="margin: 30px 20px 10px 10px; width: 80%" >
              <a-list-item slot="renderItem" slot-scope="item, index">{{item}}</a-list-item>
              <div slot="header" style="font-size: 20px; font-weight: bold">学院通知&nbsp;<a-icon type="bars" /></div>
            </a-list>
          </a-col>
        </a-row>
      </a-row>
    </div>
</template>

<script>
const data = [
  '数学与计算科学学院开展“不忘初心、牢记使命”主题教…',
  '我院老师赴成都参加第三届泛太平洋拓扑学国际学术会议…',
  '数学与计算科学学院组织观看“不忘初心、牢记使命”主…',
  '数学与计算科学学院召开师范专业学生学业规划暨2020届…',
  '数学与计算科学学院开展“不忘初心、牢记使命”主题教…',
  '数学与计算科学学院举行兼职教授聘任仪式'
]
export default {
  name: 'HelloWorld',
  data () {
    return {
      data
    }
  },
  methods: {
  },
  mounted () {
  },
  beforeDestroy () {
  }

}
</script>

<style scoped>
h1 {
  font-weight: normal;
  padding: 20px;
}
/* For demo */
.ant-carousel >>> .slick-slide {
  text-align: center;
  height: 350px;
  line-height: 350px;
  background: #364d79;
  overflow: hidden;
}
.text-center{
  text-align: center;
}
.footer{
  background-color: rgb(85,85,85);
  height: 100px;
}

.ant-carousel >>> .slick-slide h3 {
  color: #fff;
}
</style>
