<template>
  <v-app>
    <v-main>
      <!-- Navi Bar -->
      <v-app-bar color="deep-purple accent-4" dark>
        <v-btn class="text-h5" text @click="goToScreen('/')" href="/">Home</v-btn>
        <v-spacer></v-spacer>
        <v-btn text v-show="!isRegister" @click="goToScreen('/register')">Register</v-btn>
        <v-btn text v-show="isRegister" @click="goToScreen('/profile')">Profile</v-btn>
        <v-btn text @click="goToScreen('/course')">Course</v-btn>
        <v-btn text @click="goToScreen('/courseview')">CourseView</v-btn>
        <!--<router-link to="/about">About</router-link>-->
        <v-btn text @click="goToScreen('/about')">About</v-btn>
        <v-btn text v-show="isRegister" @click="onClickLogout">Logout</v-btn>
      </v-app-bar>
      <!-- Screen -->
      <v-container>
        <router-view/>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    isRegister:false,
  }),

  created(){
    this.isRegister = this.$store.state.isRegister;
    this.$store.watch(
      () => {
        return this.$store.state.isRegister;
      },
      (newVal, oldVal) => {
        this.isRegister = newVal;
      },
      {
        deep:true,
      }
    );
  },
  methods:{
    onClickLogout(){
      // Store in Vue State
      this.$store.commit("setIsRegister",false);
      this.$store.commit("setUserInfo",{});

      // Go to Home
      if(this.$router.currentRoute.path != "/"){
        this.goToScreen("/");
      }
    },

    goToScreen(screenPath){
      this.$router.push({path:screenPath});
    },
  }
};
</script>
