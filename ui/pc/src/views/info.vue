<template>
  <div style="background-color:#eee;">
    <a-row>
      <a-col span="7" style="background-color:#fff;margin-right: 35px;">
        <div class="header">
          <a-avatar :size="100" icon="user"/>
          <p class="position" style="margin: 0;font-weight: bold">PROFESSOR</p>
          <p class="name">My`Leong</p>
        </div>
      </a-col>
      <a-col span="16" style="background-color:#fff;"></a-col>
    </a-row>
  </div>
</template>

<script>
export default {
  name: 'info',
  data () {
    return {
    }
  }
}
</script>

<style scoped>
  *{
    margin: 0;
    padding: 0;
  }
  .header{
    text-align: center;
    padding-top: 20px;
    padding-bottom: 20px;
  }
  .position{
    font-weight: bold;
    font-size: 20px;
  }
</style>
