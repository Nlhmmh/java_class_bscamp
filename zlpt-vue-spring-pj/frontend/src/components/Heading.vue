<template>
  <div>
    <v-app-bar
    elevation="4"
    dense    
    >
    <router-link to="/" class="mx-2 navlink">Home</router-link>
    <!-- <v-spacer></v-spacer> -->
    <v-spacer></v-spacer>
    <router-link to="/addEmployee" class="mx-2 navlink">Add Employee</router-link>
    </v-app-bar>
  </div>
</template>

<script>
export default {
 name: "heading",
 data() {
  return {
    isRegister: false,
  }
 },
 created() {
  this.isRegister = this.$store.state.isRegister;
  this.$store.watch(
      () => {
        return this.$store.state.isRegister;
      },
      (newVal, oldVal) => {
        this.isRegister = newVal;
      },
      {
        deep: true,
      }
    );
 },
 methods: {
  logout() {
    this.$store.commit("setIsRegister",false);
    this.$store.commit("setStudentInfo",{});

    if (this.$router.currentRoute.path != "/") {
      this.$router.push({ path: "/" });
    }
  },
 }

}
</script>

<style scoped>

.navlink {
  text-decoration: none;
}
.navlink:hover {
    text-decoration: underline;
}

</style>