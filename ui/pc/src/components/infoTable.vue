<template>
  <div>
    <a-modal title="党员基本情况登记表" :visible="visible" @ok="handleOk" @cancel="handleCancel" :width=750>
      <a-form :form="form">
        <div style="display:flex">
          <div style="flex:20;">
            <div style="display:flex">
              <a-form-item :label-col="{span: 7,offset:3}" :wrapperCol="{span:12}" style="flex:6" label="姓名">
                <a-input style="width:100px" v-decorator="['name', {rules: [{ required: true, message: '请输入名字' }]}]" />
              </a-form-item>
              <a-form-item :label-col="{span: 7,offset:5}" :wrapperCol="{span: 12}" style="flex:6" label="性别">
                <a-input style="width:100px;margin-left:3px"
                  v-decorator="['sex', {rules: [{ required: true, message: '请输入性别' }]}]" />
              </a-form-item>
              <a-form-item :label-col="{span: 8,offset:4}" :wrapperCol="{span: 12}" style="flex:9" label="出生年月">
                <a-input style="width:100px"
                  v-decorator="['birthday', {rules: [{ required: true, message: '请输入出生年月' }]}]" />
              </a-form-item>
            </div>
            <div style="display:flex">
              <a-form-item :label-col="{span: 7,offset:3}" :wrapperCol="{span: 12}" style="flex:6" label="民族">
                <a-input style="width:100px"
                  v-decorator="['nation', {rules: [{ required: true, message: '请输入民族' }]}]" />
              </a-form-item>
              <a-form-item :label-col="{span: 7,offset:5}" :wrapperCol="{span: 12}" style="flex:6" label="籍贯">
                <a-input style="width:100px;margin-left:3px"
                  v-decorator="['source', {rules: [{ required: true, message: '请输入籍贯' }]}]" />
              </a-form-item>
              <a-form-item :label-col="{span: 7,offset:5}" :wrapperCol="{span: 12}" style="flex:9" label="婚姻状况">
                <a-input style="width:100px" />
              </a-form-item>
            </div>
            <div style="display:flex">
              <a-form-item :label-col="{span: 9}" style="flex:6;padding-left:5px" label="入党时间">
                <a-input style="width:100px" />
              </a-form-item>
              <a-form-item :label-col="{span: 8}" style="flex:7;padding-left:2px" label="转正时间">
                <a-input style="width:100px;" />
              </a-form-item>
              <a-form-item :label-col="{span: 8}" style="flex:6.5" label="转正时间">
                <a-input style="width:100px;margin-left:3px" />
              </a-form-item>
            </div>
          </div>
          <div style="flex:4;height:150px">
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
        </div>
      </a-form>
    </a-modal>
  </div>
</template>
<script>
export default {
  name: 'infoTable',
  props: {
    data: Array
  },
  data () {
    return {
      visible: false,
      form: this.$form.createForm(this)
    }
  },
  methods: {
    open () {
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
