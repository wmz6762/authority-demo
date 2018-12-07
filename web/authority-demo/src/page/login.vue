<template>
  <div>
    <h2>login</h2>
    <table>
      <tr>
        <td>username:</td>
        <td>
          <input type="text" v-model="username">
        </td>
      </tr>
      <tr>
        <td>password:</td>
        <td>
          <input type="password" v-model="password">
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="login" @click="login">
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      username: "admin",
      password: "123"
    };
  },
  methods: {
    login() {
      debugger;
      this.$http({
        url: this.$http.adornUrl("/login"),
        method: "post",
        params: this.$http.adornParams({
          username: this.username,
          password: this.password
        })
      }).then(res => {
        if (res.data === "ok") this.$router.replace({ name: "home" });
        else alert(res.data);
      });
    }
  }
};
</script>

<style scoped>
</style>
