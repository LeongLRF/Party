<template>
  <div>
    <a-modal title="党员基本情况登记表" :visible="visible" @ok="handleOk" @cancel="handleCancel" :width=700>
      <div style="text-algin:center">
        <table class="table" border='1px' id="empty">
          <tr>
            <td class="name">姓名</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save" v-model="user.trueName"></a-input>
              <div v-else>{{user.trueName}}</div>
            </td>
            <td class="name">性别</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save" v-model="user.sex"></a-input>
              <div v-else>{{user.sex}}</div>
            </td>
            <td class="name">出生年月</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save" v-model="user.birthday">
              </a-input>
              <div v-else>{{$getyyyyMMdd(new Date(user.birthday))}}</div>
            </td>
            <td style="width:120px" rowspan="4">
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
          <tr>
            <td class="name">民族</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.nation"></a-input>
              <div v-else>{{user.nation}}</div>
            </td>
            <td class="name">籍贯</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.homeTown"></a-input>
              <div v-else>{{user.homeTown}}</div>
            </td>
            <td class="name">婚姻状况</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.marry"></a-input>
              <div v-else>{{user.marry}}</div>
            </td>
          </tr>
          <tr>
            <td class="name">入党时间</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save" v-model="user.joinTime"></a-input>
              <div v-else>{{$getyyyyMMdd(new Date(user.joinTime))}}</div>
            </td>
            <td class="name">转正时间</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save" v-model="user.formalTime"></a-input>
              <div v-else>{{$getyyyyMMdd(new Date(user.formalTime))}}</div>
            </td>
            <td class="name">参加工作时间</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save" v-model="user.workTime"></a-input>
              <div v-else>{{$getyyyyMMdd(new Date(user.workTime))}}</div>
            </td>
          </tr>
          <tr>
            <td class="name">入党时所在支部</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.takePartDept"></a-input>
              <div v-else>{{user.takePartDept}}</div>
            </td>
            <td class="name">转正时所在支部</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.formalDept"></a-input>
              <div v-else>{{user.formalDept}}</div>
            </td>
            <td class="name">入党介绍人</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.joinPeople"></a-input>
              <div v-else>{{user.joinPeople}}</div>
            </td>
          </tr>
          <tr>
            <td class="name">所在支部</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save"></a-input>
              <div v-else></div>
            </td>
            <td class="name">进入党支部日期</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.joinDeptTime"></a-input>
              <div v-else>{{$getyyyyMMdd(new Date(user.joinDeptTime))}}</div>
            </td>
            <td class="name">现任党内职务</td>
            <td class="text" colspan="2" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.currentPosition"></a-input>
              <div v-else>{{user.currentPosition}}</div>
            </td>
          </tr>
          <tr>
            <td class="name">学历学位</td>
            <td class="text" colspan="3" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.degree"></a-input>
              <div v-else>{{user.degree}}</div>
            </td>
            <td class="name">毕业院校系及专业</td>
            <td class="text" colspan="2" @click="edit">
              <a-input type=text class="input" v-if="isEdit"></a-input>
              <div v-else></div>
            </td>
          </tr>
          <tr>
            <td class="name" colspan="2">工作单位及职务</td>
            <td class="text" colspan="5" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save"></a-input>
              <div v-else></div>
            </td>
          </tr>
          <tr>
            <td class="name" colspan="2">组织关系所在单位</td>
            <td class="text" colspan="5" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save"></a-input>
              <div v-else></div>
            </td>
          </tr>
          <tr>
            <td class="name" colspan="2">户籍所在地</td>
            <td class="text" colspan="5" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.home"></a-input>
              <div v-else>{{user.home}}</div>
            </td>
          </tr>
          <tr>
            <td class="name" colspan="2">现居住地</td>
            <td class="text" colspan="5" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.currentHome"></a-input>
              <div v-else>{{user.currentHome}}</div>
            </td>
          </tr>
          <tr>
            <td class="name" colspan="2">身份证号码</td>
            <td class="text" colspan="5" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.idCard"></a-input>
              <div v-else>{{user.idCard}}</div>
            </td>
          </tr>
          <tr>
            <td class="name" colspan="1">联系电话</td>
            <td class="text" colspan="3" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.phone"></a-input>
              <div v-else>{{user.phone}}</div>
            </td>
            <td class="name" colspan="1">QQ号码或微信号</td>
            <td class="text" colspan="3" @click="edit">
              <a-input type=text class="input" v-if="isEdit" v-model="user.account"></a-input>
              <div v-else>{{user.account}}</div>
            </td>
          </tr>
          <!-- <tr>
            <td class="name" colspan="1">党员流动信息</td>
            <td class="text" colspan="6">
          <tr>
            <td class="name">联系电话</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save" :value=sex v-model=sex>{{sex}}</a-input>
              <div v-else>{{sex}}</div>
            </td>
            <td class="name">QQ号码或微信号</td>
            <td class="text" @click="edit">
              <a-input type=text class="input" v-if="isEdit" @blur="save" :value=sex v-model=sex>{{sex}}</a-input>
              <div v-else>{{sex}}</div>
            </td>
          </tr>
          </td>
          </tr> -->
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
      visible: false,
      isEdit: false,
      flag: false,
      user: {}
    }
  },
  methods: {
    showModal (data, val) {
      console.log(111, val)
      if (val === 'edit') {
        this.flag = true
      }
      this.visible = true
      this.user = data
      console.log(111, this.flag)
    },
    handleOk (e) {
      // this.form.validateFields((err, values) => {
      //   if (!err) {
      //     console.log('dddd', values)
      //     console.log('aaa')
      //     this.visible = false
      //   }
      // })
      this.saveUser()
      this.visible = false
      this.flag = false
    },
    handleCancel (e) {
      console.log('Clicked cancel button')
      this.visible = false
      this.flag = false
    },
    normFile (e) {
      console.log('Upload event:', e)
      if (Array.isArray(e)) {
        return e
      }
      return e && e.fileList
    },
    edit () {
      if (this.flag) {
        this.isEdit = true
      }
    },
    save () {
      this.isEdit = false
    },
    saveUser () {
      this.$post('/user/edit_user', this.user).then(res => {
        if (res.success) {
          this.$message.success('修改成功')
        } else {
          this.$message.error(res.message)
        }
      })
    }
  }
}
</script>

<style  scoped>
.table {
  font-size: 16px;
  text-align: center;
}
.name {
  width: 80px;
}
.text {
  width: 100px;
  height: 35px;
  text-align: center;
}
.input {
  border: 0px;
  padding: 0 5px;
  margin: 0;
  text-align: center;
  font-size: 16px;
  width: 100%;
}
</style>
