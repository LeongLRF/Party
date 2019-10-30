<template>
  <div id="infoTable">
    <a-modal title="党员基本情况登记表" :visible="visible" @ok="handleOk" @cancel="handleCancel" :width=750>
      <div>
        <div style="display:flex">
          <div style="flex:20;">
            <div style="text-align: right;">
              <a-row style="height:50px">
                <a-col :span="8">
                  <a-col :span="13">姓名：</a-col>
                  <a-col :span="11">
                    <a-input style="width:100%" v-model="user.trueName" />
                  </a-col>
                </a-col>
                <a-col :span="8">
                  <a-col :span="13">性别：</a-col>
                  <a-col :span="11">
                    <a-select v-model="user.sex" style="width: 100%;" defaultValue="男">
                      <a-select-option value="男">男</a-select-option>
                      <a-select-option value="女">女</a-select-option>
                    </a-select>
                  </a-col>
                </a-col>
                <a-col :span="8">
                  <a-col :span="13">出生年月：</a-col>
                  <a-col :span="11">
                    <a-date-picker style="width: 100%" v-model="user.birthday"/>
                  </a-col>
                </a-col>
              </a-row>

              <a-row style="height:50px">
                <a-col :span="8">
                  <a-col :span="13">民族：</a-col>
                  <a-col :span="11">
                    <a-input style="width:100%" v-model="user.nation" />
                  </a-col>
                </a-col>
                <a-col :span="8">
                  <a-col :span="13">籍贯：</a-col>
                  <a-col :span="11">
                    <a-input style="width:100%" v-model="user.homeTown"/>
                  </a-col>
                </a-col>
                <a-col :span="8">
                  <a-col :span="13">婚姻状况：</a-col>
                  <a-col :span="11">
                    <a-input style="width:100%" v-model="user.marry"/>
                  </a-col>
                </a-col>
              </a-row>
              <a-row style="height:50px">
                <a-col :span="8">
                  <a-col :span="13">入党时间：</a-col>
                  <a-col :span="11">
                    <a-date-picker style="width: 100%" v-model="user.joinTime"/>
                  </a-col>
                </a-col>
                <a-col :span="8">
                  <a-col :span="13">转正时间：</a-col>
                  <a-col :span="11">
                    <a-date-picker style="width: 100%" v-model="user.formalTime"/>
                  </a-col>
                </a-col>
                <a-col :span="8">
                  <a-col :span="13">参加工作时间：</a-col>
                  <a-col :span="11">
                    <a-date-picker style="width: 100%" v-model="user.workTime"/>
                  </a-col>
                </a-col>
              </a-row>
              <a-row style="height:50px">
                <a-col :span="8">
                  <a-col :span="13">学号/教工号：</a-col>
                  <a-col :span="11">
                    <a-input style="width: 100%" v-model="user.userName"/>
                  </a-col>
                </a-col>
                <a-col :span="12">
                  <a-col :span="9">班级：</a-col>
                  <a-col :span="11">
                    <a-select style="width: 100%" v-model="user.classId">
                      <a-select-option v-for="(item, index) in clazz" :value="item.id" :key="index">{{item.code}}</a-select-option>
                    </a-select>
                  </a-col>
                </a-col>
              </a-row>
            </div>
          </div>
          <div style="flex:4;height:140px;padding-left:10px;">
            <a-upload-dragger v-decorator="[{
                  valuePropName: 'fileList',
                  getValueFromEvent: normFile,
                }]" name="files" action="/upload.do">
              <div>
                <a-icon type="plus" />
              </div>
              <div>
                照片
              </div>
            </a-upload-dragger>
          </div>
        </div>
      </div>
      <div style="text-align:right">
        <div style="margin:10px 0;display:flex">
          <span style="flex:1">入党所在支部：</span>
          <a-input style="flex:2;" v-model="user.takePartDept"></a-input>
          <span style="flex:1">转正所在支部：</span>
          <a-input style="flex:2" v-model="user.formalDept">
          </a-input>
        </div>
        <div style="margin:10px 0;display:flex">
          <span style="flex:1">入党介绍人：</span>
          <a-input style="flex:2;" v-model="user.joinPeople"></a-input>
          <span style="flex:1">所在支部：</span>
          <a-input style="flex:2" v-model="user.deptId">
          </a-input>
        </div>
        <div style="margin:10px 0;display:flex">
          <span style="flex:1">入党支部日期：</span>
          <a-date-picker  v-model="user.joinDeptTime"/>
          <span style="flex:1">现任党内职务：</span>
          <a-input style="flex:2" v-model="user.currentPosition">
          </a-input>
        </div>
        <div style="margin:10px 0;display:flex">
          <div style="flex:12;display:flex">
            <span style="flex:1">学历/学位：</span>
            <a-input style="flex:2;" v-model="user.degree"></a-input>
          </div>
          <div style="flex:12;display:flex">
            <span style="flex:2">毕业院校系及专业：</span>
            <a-input style="flex:3" v-model="user.schoolMajor">
            </a-input>
          </div>
        </div>
        <div style="margin:10px 0;display:flex">
          <div style="flex:12;display:flex">
            <span style="flex:1">联系电话：</span>
            <a-input style="flex:2;" v-model="user.phone"></a-input>
          </div>
          <div style="flex:12;display:flex">
            <span style="flex:2">QQ号码或微信：</span>
            <a-input style="flex:3" v-model="user.account">
            </a-input>
          </div>
        </div>
        <div style="margin:10px 0;display:flex">
          <span style="flex:4">工作单位及职务：</span>
          <a-input style="flex:15" v-model="user.workPlace"></a-input>
        </div>
        <div style="margin:10px 0;display:flex">
          <span style="flex:4">组织关系所在单位：</span>
          <a-input style="flex:15" v-model="user.relationship"></a-input>
        </div>
        <div style="margin:10px 0;display:flex">
          <span style="flex:4">现居住地：</span>
          <a-input style="flex:15" v-model="user.currentHome"></a-input>
        </div>
        <div style="margin:10px 0;display:flex">
          <span style="flex:4">身份证号码：</span>
          <a-input style="flex:15" v-model="user.idCard"></a-input>
        </div>
      </div>
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
      form: this.$form.createForm(this),
      user: {
        userName: null,
        password: 123456,
        sex: null,
        roleId: null,
        classId: null,
        deptId: null,
        trueName: null,
        birthday: null,
        nation: null,
        joinTime: null,
        formalTime: null,
        workTime: null,
        joinPeople: null,
        academicId: null,
        joinDeptTime: null,
        currentPosition: null,
        degree: null,
        phone: null,
        salt: null,
        token: null,
        valid: false,
        homeTown: null,
        marry: null,
        takePartDept: null,
        formalDept: null,
        schoolMajor: null,
        workPlace: null,
        relationship: null,
        home: null,
        account: null,
        currentHome: null,
        idCard: null
      },
      calzz: []
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
      this.$post('/user/add_user', this.user).then(res => {
        if (res.success) {
          this.$message.success('添加成功')
          this.$emit('refresh')
        } else {
          this.$message.error(res.message)
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
    },
    getClazz () {
      this.$my_get('/sys/clazz_list').then(res => {
        this.clazz = res.data
      })
    }
  },
  mounted () {
    this.getClazz()
  }
}
</script>

<style  scoped>
</style>
