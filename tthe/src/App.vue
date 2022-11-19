<template>

<!-- SPA- Single Page Application -->
  <v-app>
    
    <v-main>
      <!-- nav-bar -->
      <v-app-bar color="deep-purple accent-4" dark elevation="4">
        <v-app-bar-title>
          <v-btn class="text-h5" text @click="gotToScreen('/')">Home</v-btn>
        </v-app-bar-title>
        <v-spacer></v-spacer>
        <v-btn v-show="!isRegister" text @click="gotToScreen('/register')">Register</v-btn>
        <v-btn v-show="isRegister" text @click="gotToScreen('/profile')">Profile</v-btn>
        <!-- <router-link to="/about">About</router-link> -->
        <v-btn text @click="gotToScreen('/about')">About</v-btn>
        <v-btn v-show="isRegister" text @click="onClickLogout">Logout</v-btn>
      </v-app-bar>
      <!-- screen -->
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

  methods:{
    onClickLogout(){
      // Store in Vuex state
      // mutations
      this.$store.commit("setIsRegister", false);
      this.$store.commit("setUserInfo", {});

      //Go To Home
      if(this.$router.currentRoute.path != '/'){
        this.gotToScreen('/');
      };
      
    },

    gotToScreen(screenPath){
      this.$router.push({ path: screenPath });
    }
  },

};
</script>

<style scoped>

</style>
