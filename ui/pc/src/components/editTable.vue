<template>
  <div>
    <a-modal title="党员基本情况登记表" :visible="visible" @ok="handleOk" @cancel="handleCancel" :width=750>
        <div >
          <table class="table" border='1px'>
          <tr >
            <td class="name">姓名</td>
            <td class="text">2</td>
            <td class="name">性别</td>
            <td class="text">2</td>
            <td class="name">出生年月</td>
            <td class="text">2</td>
            <td style="width:100px" rowspan="4">
              <div style="height:160px">
                <a-upload-dragger v-decorator="[{
                    valuePropName: 'fileList',
                    getValueFromEvent: normFile,
                  }]" name="files" action="/upload.do">
                  <p>
                    <a-icon type="plus" />
                  </p>
                  <p>
                    照片
                  </p>
                </a-upload-dragger>
              </div>
            </td>
          </tr>
          <tr >
            <td class="name">民族</td>
            <td class="text">2</td>
            <td class="name">籍贯</td>
            <td class="text">2</td>
            <td class="name">婚姻状况</td>
            <td class="text">2</td>
          </tr>
          <tr >
            <td class="name">入党时间</td>
            <td class="text">2</td>
            <td class="name">转正时间</td>
            <td class="text">2</td>
            <td class="name">参加工作时间</td>
            <td class="text">2</td>
          </tr>
          <tr >
            <td class="name">入党时所在支部</td>
            <td class="text">2</td>
            <td class="name">转正时所在支部</td>
            <td class="text">2</td>
            <td class="name">入党介绍人</td>
            <td class="text">2</td>
          </tr>
          <tr >
            <td class="name">所在支部</td>
            <td class="text">2</td>
            <td class="name">进入党支部日期</td>
            <td class="text">2</td>
            <td class="name">现任党内职务</td>
            <td class="text2" colspan="2">2</td>
          </tr>
          </table>

        </div>
    </a-modal>
  </div>
</template>
<script>
export default {
  name: 'editTable',
  props: {
  },
  data () {
    return {
      visible: false
    }
  },
  methods: {
    showModal () {
      this.visible = true
    },
    handleOk (e) {
      this.form.validateFields((err, values) => {
        if (!err) {
          console.log('dddd', values)
          console.log('aaa')
          this.visible = false
        }
      })
    },
    handleCancel (e) {
      console.log('Clicked cancel button')
      this.visible = false
    },
    normFile (e) {
      console.log('Upload event:', e)
      if (Array.isArray(e)) {
        return e
      }
      return e && e.fileList
    }
  }
}
</script>

<style  scoped>
.table {
  font-size: 16px;
  text-align: center;
}
.name{
  width:80px;
}
.text{
  width: 100px;
}
</style>
