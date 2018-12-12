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
        <td>
          <img :src="captchaPath" @click="getCaptcha()">
        </td>
        <td>
          <input type="text" v-model="imageCode">
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
import { getUUID } from "@/util/index";
export default {
  name: "index",
  data() {
    return {
      username: "admin",
      password: "123",
      captchaPath: "",
      uuid:'',
      imageCode:''
    };
  },
  methods: {
    login() {
      this.$http({
        url: this.$http.adornUrl("/login"),
        method: "post",
        params: this.$http.adornParams({
          username: this.username,
          password: this.password,
          imageCode:this.imageCode
        })
      }).then(res => {
        if (res.data === "ok") this.$router.replace({ name: "home" });
        else alert(res.data);
      });
    },
    getCaptcha() {
      this.uuid=getUUID();
      this.captchaPath = this.$http.adornUrl(`/captcha.jpg?uuid=${this.uuid}`)
    }
  },
  created() {
    this.getCaptcha();
  }
};
</script>

<style scoped>
</style>
