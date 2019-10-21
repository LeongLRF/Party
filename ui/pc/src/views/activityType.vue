<template>
  <div>
    <a-table :dateSource="dataSource"  :columns="columns"></a-table>
  </div>
</template>

<script>
export default {
  name: 'activityType',
  data () {
    return {
      columns: [
        {title: 'name', dataIndex: 'name', key: 'name', align: 'center', width: '50px'},
        {title: 'details', dataIndex: 'details', key: 'details', align: 'center', width: '150px'},
        {title: 'operation', key: 'operation', scopedSlots: {customRender: 'operation'}}
      ]
    }
  }
}
</script>

<style scoped></style>
