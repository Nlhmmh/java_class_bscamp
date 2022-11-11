<template>
  <div class="wrapper">
    <h1>
      Welcome to {{ userInfo.name ? userInfo.name : "Language Learning Site" }}
    </h1>
  </div>
</template>

<script>
export default {
  name: "home",

  components: {},

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

  methods: {},
};
</script>

<style></style>
