<template>
  <div>
    <a-tabs hideAdd v-model="getselectTab.content" type="editable-card" @edit="onEdit" @tabClick="tabClick">
      <a-tab-pane v-for="(pane,index) in panesList" :key="pane.content" :closable="pane.closable">
        <span slot="tab">
          <a-icon type="home" v-if="index === 0" />
          {{pane.title}}
        </span>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex'
export default {
  name: 'topTab',
  data () {
    const panes = [
      { title: 'Home', content: '/index', closable: false, key: '1' }
    ]
    return {
      panes
    }
  },
  computed: {
    ...mapGetters('tab', ['getTabList', 'getselectTab']),
    panesList: function () {
      return this.panes.concat(this.getTabList)
    }
  },
  watch: {
  },
  methods: {
    ...mapMutations('tab', ['removeTabList', 'setSelectTab']),
    callback (key) {
      console.log(key)
    },
    onEdit (targetKey, action) {
      console.log(action, targetKey)
      this[action](targetKey)
    },
    remove (targetKey) {
      this.removeTabList(targetKey)
    },
    tabClick (targetKey) {
      this.setSelectTab(targetKey)
    }
  },
  created () {
  }
}
</script>

<style  scoped></style>
