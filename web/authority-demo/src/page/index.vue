<template>
  <div>
    index
    <input type="button" value="请求account接口(未授权)" @click="account()">
    <input type="button" value="请求info接口(未匹配资源)" @click="info()">
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {};
  },
  methods: {
    load() {
      this.$http({
        url: this.$http.adornUrl("/"),
        method: "get"
      }).then(res => {
        alert(res.data);
      });
    },
    account() {
      this.$http({
        url: this.$http.adornUrl("account"),
        method: "get"
      }).then(res => {
        alert(res.data);
      });
    },
    info() {
      this.$http({
        url: this.$http.adornUrl("info"),
        method: "get"
      }).then(res => {
        alert(res.data);
      });
    }
  },
  mounted() {
    this.load();
  }
};
</script>

<style scoped>
</style>  
