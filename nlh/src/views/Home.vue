<template>
  <h1>Welcome to home {{ userInfo.name }}</h1>
</template>

<script>
export default {
  name: "home",

  data() {
    return {
      userInfo: {},
    };
  },

  created() {
    this.userInfo = this.$store.state.userInfo;
    this.$store.watch(
      () => {
        return this.$store.state.userInfo;
      },
      (newVal, oldVal) => {
        this.userInfo = newVal;
      },
      {
        deep: true,
      }
    );
  },
};
</script>

<style></style>
