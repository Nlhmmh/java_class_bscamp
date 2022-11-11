<template>
  <v-app>
    <v-main>
      <v-app-bar color="deep-purple accent-4" dark>
        <!-- <v-app-bar-nav-icon></v-app-bar-nav-icon> -->
        <v-btn text class="text-h5" @click="goToScreen('/')">Home</v-btn>

        <v-spacer></v-spacer>
        <v-btn text @click="goToScreen('/register')" v-show="!isRegister"
          >Register</v-btn
        >
        <v-btn text @click="goToScreen('/profile')" v-show="isRegister"
          >Profile</v-btn
        >
        <v-btn text @click="goToScreen('/about')">About</v-btn>
        <v-btn text v-show="isRegister" @click="onLogout">Logout</v-btn>
        <!-- <router-link to="/about">
          <v-btn text>About</v-btn>
        </router-link> -->
      </v-app-bar>
      <v-container>
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: "App",

  data: () => ({
    isRegister: false,
  }),

  created() {
    this.isRegister = this.$store.state.isRegister;

    console.log("i", this.isRegister);

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
    onLogout() {
      this.$store.commit("setIsRegister", false);
      this.$store.commit("setUserInfo", {});
      if (this.$router.currentRoute.path != "/") {
        this.goToScreen("/");
      }
    },

    goToScreen(path) {
      this.$router.push({ path });
    },
  },
};
</script>
